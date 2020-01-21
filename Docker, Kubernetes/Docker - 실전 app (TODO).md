# docker - 실전 app (TODO)

### 1. 애플리케이션 전체 구조

- 데이터 스토어 역활을 할 mysql 서비스를 마스터 슬레이브 구조로 구축 
- mysql과 데이터를 주고받을 apl 구현
- nginx를 웹 애플리케이션과 api사이에서 프록시 역활을 함 
- api를 사용해 서버 사이드 렌더링을 수행할 웹 애플리케이션 구현
- 프론트엔드 쪽에 nginx 배치 

### 2. mysql 서비스 구축 

> - mysql_master
> - mysql_slave       // 환경변수에 따라서 maser/slave 선택 할 수 있도록 함 

`$ docker pull mysql:5.7`

- server_id  - > 중복되거나 없으면 안되기 때문에 자동으로 만들어 주는 파일을 생성함 `add- server-id.sh`

- 레플리케이션 설정 

  `prepare.sh`

- CLI  

  - swarm > todo > tododb 

  ```
  $ docker build -t localhost:5000/ch04/tododb:latest .
  $ docker push localhost:5000/ch04/tododb:latest
  ```

- 네트워크 구성 

  ```
  $ docker network create --driver=overlay --attachable todoapp
  $ docker network ls
  ```

- 서비스 구성 

  ```
  $ docker stack deploy -c /stack/todo-mysql.yml todo_mysql
  $ docker stack ls
  $ docker service ls
  ```

- 초기화 데이터 베이스 생성 

   mysql_master로 접근 

  ```
  $ docker exec -it manager docker service ps todo_mysql_master --no-trunc --filter "desired-state=running" --format "doc
  ker exec -it {{.Node}} docker exec -it {{.Name}}.{{.ID}} bash"
  // 나온 문자 복사해서 하면 master 접근
  # init-data.sh
  # mysql -uroot -p 
   # show databases
   # use tododb
   # select * from todo;
  
  슬레이브 접근 
  $ docker exec -it manager docker service ps todo_mysql_slave --no-trunc --filter "desired-state=running" --format "docker exec -it {{.Node}} docker exec -it {{.Name}}.{{.ID}} bash"
  # mysql -uroot -p 
  내용 확인 
  ```
  

## 3. API 서비스 구축 

> todo 앱의 도메인 담당 : 업무 지식
>
> 데이터 베이스를 사용하기 위해서 api를 구축함  

- go언어로 구현

  - cmd/main.go - mysql 접속에 필요한 환경 변수 값 얻어오기, http 요청 핸들러 생성 및 앤드포인트 등록, 서버 실행 , 실질적인 파일 
  - db.go - 환경변수를 받아 오는 코느
  - env.go - mysql 접속 및 테이블 매핑
  - handler.go - 핸들러, todo api의 요청 처리
    - serverGET 
    - serverPOST
    - serverPUT

- dockerfile

  ```dockerfile
  FROM golang:1.10
  
  WORKDIR /
  ENV GOPATH /go
  
  COPY . /go/src/github.com/gihyodocker/todoapi
  RUN go get github.com/go-sql-driver/mysql
  RUN go get gopkg.in/gorp.v1
  RUN cd /go/src/github.com/gihyodocker/todoapi && go build -o bin/todoapi cmd/main.go
  RUN cd /go/src/github.com/gihyodocker/todoapi && cp bin/todoapi /usr/local/bin/
  // go파일 빌드 
  CMD ["todoapi"]   //실행파일 기동 경로 bin/todoapi
  ```

  

- CLI  swarm > todo > todoapi

  ```
  $ docker build -t localhost:5000/ch04/todoapi:latest .
  $ docker push localhost:5000/ch04/todoapi:latest
  $ docker exec -it manager sh
  
  # docker stack deploy -c /stack/todo-app.yml todo_app
  # docker service logs -f doto_app_api
  
  # docker service ps todo_app_api //어떤 노드에 서비스가 설치되었는 확인하는 명령어
  # docker ps = docker container ls //실행 중인 cotainer 리스트 출력 
  # docker stack service todo_app 
  ```

- todo_app_api.1 or todo_app_api.2

  ```
  #apt-get update
  #apt-get install -y net-tools
  #netstat -ntpl //포트 번호 확인 
  
  # curl -XGET http://localhost:8080/todo?status=TODO  //TODO라는 상태를 가지고 있는 출력
  # curl -XPOST -d '{"title":"4장 집필하기", "content":"내용 검토 중"}' http://localhost:8080/todo
  # curl -XPUT -d '{"id":1, "title":"4장 집필하기", "content":"도커를 이용한 실전적 웹 어플리케이션", "status":"PROGRESS"}' http://localhost:8080/todo
  ```

## 4. Nginx 구축

> proxy - 
>
> 단일 접근 (접근 로그 생성)
>
> 캐시 제어
>
> 라우팅 설정 

- CLI  swarm > todo > todonginx

  ```
  $ docker build -t localhost:5000/ch04/nginx:latest .
  $ docker push localhost:5000/ch04/nginx:latest
  $ docker exec -it manager sh
  
  # docker stack deploy -c /stack/todo-app.yml todo_app
  ```

## 5 .웹 서비스 구축

> node.js 실행 컨테이너로 배포하여 nginx를 거쳐 웹 애플리케이션에 접근 
>
> node,js - vue.js기반 프레임워크은 nuxt.js 사용 

- CLI  swarm > todo > todoweb     - 도커파일을 만들어서 이미지파일을 넘긴다,.

  ```
  $ npm install  // package.json파일을 구동하는 명령어 ,, test용도 굳이 안함 
  $ npm run build
  $ npm run start               
  ```

  