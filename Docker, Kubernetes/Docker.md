# Docker -컨테이너 기반의 오픈소스 가상화 플랫폼

> - 커널 이미지 : 커널이 하나의 파일로 디스크에 저장되어 있는 것이다.
>
>   도커 이미지 : 컨테이너 실행에 필요한 파일과 설정 값 등을 포함 (container - 이미지 실체화)
>
>   ​                       docker hub(public), wordpress (private) - 이미지를 다운 받아서 원하는 파일을 더 추가해						서 이미지를 만듬 
>
> - 가상화
>
>   - 호스트 운영체제형 가상화 - 우분투 , centos 
>
>   - 컨테이너형 가상화 - dockcer 
>
>     guestOS 가 존재 하지 않음 (window host 공유 하기 때문에 )
>
> -  가상화 방식
>
>   - 기존 - vmware ,벌처박스 --> 무겁고 느리다 , 
>   - 프로세스 관리 - docker --> 컨테이너 생성 속도가 빠름 docker engine(docker server, host)
>
> - 오케스트레이션 툴 : 여러가지 서비스가 조합(컨테이너 기반의 가상화를)해서 자동화하기 위해서 
>
>   `도커 스웜`(도커 설치시 기본 툴), `쿠퍼네티스` 등,,
>
> - mysql 설치 -> 리눅스의 최소사양이 포함된 mysql 설치를 하는 것 

- 애플리케이션이 중심이 되는 도커 

  - 호스트 운영 체제의 영행을 받지 않는 실행 환경
  - DSL(dockerfile)
  - 이미지 버전 관리 
  - 다양한 기능의 API

- Dockerfile - docker 이미지를 생성하기 위한 파일 

   base이미지는 한개만 가능 하다  , container 하나만  만든다(리눅스에사 시용하는 processor) 

  ```dockerfile
  # FROM ubuntu:16.04  // 최소사양의(400MB)
  # COPY hellowrld /usr/local/bin // hellowrld 를 /usr/local/bin에 복사
  # RUN chmod +x /usr/local/bin/helloworld  // RUN 실행 명령어 
  # CMD ["heloworld"] // CMD 한번만 존재 해야함 
  ```

- 실행

  ```shell
  $ docker image build -t helloworld:latest . // .현재 디렉터리(. /Dokerfile) , 도커파일을 가지고 이미지 만듬 - 틀 
  $ docker container run helloworld:lates // run : creat + start OS체제 기동
  $ docker stop  // OS Power off
  $ docker start // OS Power on
  ```

- 도커를 사용하는 의의 

  - 변화하지 않는 실행 환경으로 멱등성 확보
  - 코드를 통한 실행 환경 구축 및 애플리케이션 구성 - IAC (코드로 관리하는 인프라)
  - 실행 환경과 애플리케이션의 일체화로 이식성 향상
  - 시스템을 구성하는 애플리케이션 및 미들웨어의 관리 용이성 

- 도커 이미지 : 도커 컨테이너를 구성하는 파일 시스템과 실행할 어플리케이션 설정을 하나로 합친 것으로 , 컨테이너를 생성하는 템플릿 역활을 한다.

- 도커 컨테이너 : 도커 이미지를 기반으로 생성되며, 파일 시스템과 어플리케이션이 구체화돼 실행되는 상태 

## 1. docker 실행 

```shell
$ dockerlogin   // 도커 로그인 
$ docker version  // 도크 버전 관리 (client ,server 확인 )
$ docker --help  //docker 명령어 확인 - docker 명령어 --help 
$ docker image ls  // 이미지 리스트 확인 images 
$ docker image pull gihyodocker/echo:latest  // hub.docker 에서 이미지 파일 다운로드
$ docker run -p 9000:8080 gihyodocker/echo:latest // 9000(호스트)->8080(컨테이너) 
$ docker run --name myweb1 -d -p 9000:8080 gihyodocker/echo:latest //name 지정(삭제하거나 중지할 때) -d 백그라운드에서 커멘드 올려줌  --rm // 스탑과 동시에 rm 까지 되어버리는 컨테이너 생성 
$ docker container ls  // 컨테이너 리스트 확인 
$ docker ps  // 현재 작동중인 컨테이너 확인   -a //종료된 컨테이너도 확인 
$ curl http://localhost:9000 // 
$ docker stop $(docker ps -q)   //모두 종류 
$ docker rm id // 종료된 컨테이너 종료 
$ docker rm $(docker ps -qa) // \모든 종료된 컨테이너 삭제 
$ docker container prune  //모든 종료된 컨테이너  삭제
$ docker system prune // 최종 삭제 
$ docker stop id  & docker rm id // 파워쉘에서는 오류, 리눅스에서는 됨 
$ docker image rm image_id // 이미지 삭제 = docker rmi id /-f 이미지 강제 삭제 
$ docer stats 
```

## 2. docker  프로젝트 

- 윈도우

  - 1.개발 (package.json , index.js) 
  - 2.npm install (node가 설치 되어 있어야 ㅎㅎ함 )
  - 3.npm start -> http://localhost:8080    

-  docker

  - FROM -> node 사용 가능 한 이미지
  - RUN -> NPM INSTALL 실행
  - CMD -> NPM START  
  - Dockerfile

  ```dockerfile
  FROM node:alpine            //alpine-가장 작은 리눅스 
  COPY  ./package.json ./package.json // 윈도우에 있는 package 파일을 리눅스에 카피 
  RUN npm install				//node가 설치된 이미지가 아닌 url로도 node를 설치할 수 있다.
  COPY ./index.js ./index.js  
  CMD ["npm","start"]
  ```

  - 이미지 등록 / 컨테이너 생성 

    ```shell
    $ docker image build -t 0516khj2004/simpleweb:latest . //현재 파일에서 이미지 만듬 
    $ docker run -d -p 8080:8080 0516khj2004/simpleweb:latest // 컨테이너 만들고 , 구동 
      // * 오류 발생(이미지 문제로 죽어버림 )
    $ docker logs id  //
    ```

  - 이미지 올리기  / 내리기 

    ```shell
    $ docker push 0516khj2004/simpleweb:latest 
    
    $ docker pull 0516khj2004/simpelweb:latest
    $ docker run -d -p 8080:80800516khj2004/simpleweb:latest 
      // 이미지가 없어도 hub에 올라가 있으면 강제로 다운이 가능하다
    ```

  - 작동중인 컨테이너에 실행하기 

    ```
    $ docker exec -it 01f226d2755e sh // exec 실행 -i 입력 -t 가상의 터미널  (-it) sh 쏄
    $ docket exec -it 01f226d2755e hostname // 컨테이너 id = hostname, ip address = -i 
    
    # WORKDIR /home/node  // dockerfile 설정하지않으면 파일들이 root에 저장되니, home/node로 설정하면 파일들이 들어감
    # vi index.js  // 파일 수정하고 exit나와서 
    $ docker restart id 
  ```
  
- mysql 5.7
  
    ```
    $ docker run -d -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=true --name mysql my
    sql:5.7 // 패스워드 없이 사용한다 
    $ docker exec -it mysql //bin//bash
    
    # mysql -u root -p
  ```
  
    