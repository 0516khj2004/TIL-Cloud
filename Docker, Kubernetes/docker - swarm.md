# docker- Swarm

## 1.  -network (docker network ls )

- bridge network 

  $ docker network create --driver=bredge mongo-network  

- host network 

  윈도우의 호스트 주소를 가져와서 쓰기 때문에 충돌이 일어날수 있다.

- none network 

  네트워크 사용 x - 외부와 단절

- container network 

  다른 컨테이너의 네트워크 환경공유

- overlay  network 

  다른 호스트들 간에 네트워크 공유 

​      쿠버네티스   // 대부분 사용 

## 2. 서비스 

- docker -compose
    (단일 호스트)
    서비스 : 생성하고자하는 컨테이너의 종류 

- docker swarm 
    네트워크로 묶음(멀티 호스트) 

   서비스 : 컨테이너가 하나 이상 묶인 집합을 관리 (복제될 수 있음)

   스택 : 여러대의 서비스를 합한 전체 어플리케이션을 관리 

- 쿠버네티스 
   멀티 호스트
   서비스  : 

## 3. Swarm

> 여러 docker 호스트를 묶어 주는 컨테이너 오케스트레이션 
>
> 클러스터 구축 및 관리 (주로 멀티 호스트) - docker swarm 

**컨테이너 5개 생성 registry 1 manager 1 worker 3**

- docker-compose.yml

```
version: "3"
services: 
  registry:
    container_name: registry
    image: registry:latest
    ports: 
      - 5000:5000
    volumes: 
      - "./registry-data:/var/lib/registry"

  manager:
    container_name: manager
    image: docker:19.03.5-dind
    privileged: true
    tty: true
    ports:
      - 8000:80
      - 9000:9000
    depends_on: 
      - registry
    expose: 
      - 3375
    command: "--insecure-registry registry:5000"
    volumes: 
      - "./stack:/stack"

  worker01:
    container_name: worker01
    image: docker:19.03.5-dind
    privileged: true
    tty: true
    depends_on: 
      - manager
      - registry
    expose: 
      - 7946
      - 7946/udp
      - 4789/udp
    command: "--insecure-registry registry:5000"

  worker02:
    container_name: worker02
    image: docker:19.03.5-dind
    privileged: true
    tty: true
    depends_on: 
      - manager
      - registry
    expose: 
      - 7946
      - 7946/udp
      - 4789/udp
    command: "--insecure-registry registry:5000"

  worker03:
    container_name: worker03
    image: docker:19.03.5-dind
    privileged: true
    tty: true
    depends_on: 
      - manager
      - registry
    expose: 
      - 7946
      - 7946/udp
      - 4789/udp
    command: "--insecure-registry registry:5000"
```



- docker in docker , dind 

  ```
  $ docker pull docker:19.03.5-dind   // docker에사 docker다운로드         
  ```

- docker swarm init

  ```
  $ docker exec -it manager sh
  # docker swarm init // 매니저에서 swarm 설치 
   docker swarm join --token SWMTKN-1-1fjoczo1ekg0fmu6mbf6vb0hifffjn61k32xec9avd7qhiuvjt-01gudp6w30nzopx6kxb6zbw6i 172.31.0.3:2377
  // worker 01,02,03 에 위에 내용 붙에서 node join하기 
  # docker node ls  // swarm 목록 확인 
  # docker swarm leave --force  // swarm join풀기 
  ```

  

- registry (hub와 비슷한 역활- local 이미지 저장  )

  ```shell
  $ docker tag busybox:latest localhost:5000/busybox:latest // 이미지 이름 바꾸기 
  $ docker  push localhost:5000/busybox:latest //registry에 이미지 올리기 
  http://localhost:5000/v2/_catalog  // 웹페이지에서 이미지 올라온거 확인 가능 
  $ docker exec -it manager sh
  
  #docker pull registry:5000/busybox:latest
  ```
  
- 서비스 - 애플리케이션 이미지를 하나만 다룸 

  ```
  $ docker tag gihyodocker/echo localhost:5000/example/echo
  $ docker push localhost:5000/example/echo
    http://localhost:5000/v2/_catalog  //확인 
  $ docker exec -it manager sh
  # docker pull localhost:5000/example/echo
  # docker service create --replicas 1 --publish 80:8080 --name echo registry:5000/example/echo  
    //window<-->manage<--> 8000:80 localhost:8000 확인가능 
  
  # docker service ls  //서비스 목록 
  # docker service scale echo=3 //컨테이너를 3개 증가
  # docker servicce ps echo // echo라는 서비스가 어떤 컨테이너로 구성되어있는지 확인하는 목록 
  # docker service rm echo // 서비스 삭제 
  ```

- 스택 - 애플리케이션을 구성하는 일부 컨테이너를 제어하기 위한 단위  -서비스보다 큰 단위

  **overlay 네트워크** - 스택을 사용해 배포된 서비스 그룹 

   ```
  # docker network create --driver=overay --attachable ch03
  # docker network ls 
   ```

  stack 파일에 my-webapi.yml 파일 생성

  ```
  version: "3"
  services:
      api:
          image: registry:5000/example/echo:latest
          deploy:
              replicas: 3
              placement :
                  constraints: [node.role != manager]
          networks:
              - ch03
      nginx:
          image: gihyodocker/nginx-proxy:latest
          deploy:
              replicas : 3
              placement:
                  constraints: [node.role != manager]
          environment:
              BACKEND_HOST: echo_api:8080
          networks:
              - ch03
          depends_on:
              - api
  networks:
      ch03:
          external: true
  ```

  ```
  # docker stack deploy -c /stack/my-webapi.yml  echo
  # docker stack ls
  # docker stack service echo
  # docker service ps echo_api
  # docker service ps echo_nginx
  ```

- visualizer 컨테이너 배치 시각화 

  visualizer.yml

  ```
  version: "3"
  services: 
      app:
          image: dockersamples/visualizer
          ports:
              - "9000:8080"
          volumes:
              - /var/run/docker.sock:/var/run/docker.sock
          deploy:
              mode: global
              placement:
                  constraints: [node.role == manager]
  ```

  ```
  #docker stack deploy -c /stack/visualizer.yml visualizer
  ```

- HAProxy 

  HAProxy 를 이 프록시 서버로 이용해 스윔 클러스터 외부에서 nginx서비스에 접근함 

​       window port 8000 <-> Manager 80<-> HAProxy 80<-> nginx 8080

 my-ingress.yml  - 추가SERVICE_POSTS: 80

       ````
version: "3"
services: 
    haproxy:
        image: dockercloud/haproxy
        ports:
            - 80:80
            - 1936:1936
        volumes:
            - /var/run/docker.sock:/var/run/docker.sock
        deploy:
            mode: global
            placement:
                constraints: [node.role == manager]
        networks:
            - ch03
networks:
    ch03:
        external: true    
        
       ````

```
# docker stack deploy -c /stack/my-webapi.yml echo
# docker stack deploy -c /stack/my-ingress.yml echo

localghost: 8000
```



