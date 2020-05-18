# DevOPs

- CLAMS 프레임워크 
  - 문화
  - 자동화
  - 린
  - 측정
  - 공유
- DEV -> QA -> OPS
- CI/CD : 수동 배포가 아닌 여러 환경과 수십대의 서버에 배포해야 하는 경우 



# Microservice

- 작은 서비스 - 독립된 서비스 
  - 다른 서비스 결합이 없는 서비스 
  - 구현, 배포실해으 장애에 대한 영향을 받지 않음 
- 응집된 서비스 
  - 하나의 서비스는 기능적으로 응집
  - 같이 묶을 수 있는 서비스 -> 단순명확, 오류 최소화
- 자율적 서비스 
  - 서비스의 기획, 개발,테스트 , 배포 및 서비스의 운영까지 담당 조직이 독립적으로 의사 결정 -> ownership 



- 용어 

  - http://localhost:8080/ users 

    users -> endpoint    결과-> payload



- 고려 사항 
  - 조직의 구성 
  - Agile (방법론) / DevOps      ->무한 반복 
    - 2주 사이클 
    - todolist -> 원데이 list 
  - cloud native 기술환경
    - ci/cd
    - devops
    - microservices 
    - containers -도커 



# MSA 기반 기술

- Gateway 
  - zuul
- service mesh 
  - MSA인프라 -> 미들웨어 
    - 인증, 권한 처리 ,암호화 ,서비스 검색, 요청 라우팅, 로드 밴런싱,서비스 디스커버리  
    - 자가 치유 복구 서비스
  - 서비스간의 통신과 관련된 기능을 자동화 
  - 디스커버리 서버  
  - configuration 서버 
  - L'B 서버 
  - Router 서버 
- runtime platform
- backing service 
- telemetry
  - 시각화 
  - 모니터링 
- ci/cd autometion
  - source -> 형상관리
  - build (단일화)-> 소스코드 빌드, 이미지빌드 (ex, docker dockerfile)
  - Test -> 단위 테스트 , 소스 정적분석 
  - Artifact Storage-> 도커이미지 저장 
  - Deploy
  - Monitor 
  - 프로그램 -> ex) Jenking



# 예제 .1

- circuit Breaker
  - 전기회로의 차단기와 같은 역활 -> 문제를 감지하면 모든 시스템과의 연결 차단
  - 장애가 발생하는 서비스에 반복적인 호출이 되지 못하게 차단 
  - on(서비스를 차단)-open / off(정상상태)-closed  
  
- 마이크로서비스 아키텍처(1)

  - git : 마이크로서비스 소스 관리, 프로파일 관리 

  - config : git 저장소에 등록된 프로파일 연계 

  - 유레카 : 마이크로서비스 등록 및 발견

  - zuul : 마이크로서비스 부하 분산 및 서비스 라우팅 

  - microservice : 커피 주문 , 회원확인 , 주문처리 상태 확인 서비스

  - Queuing system(하둡) : 마이크로서비스 간 메시지 발행 및 구독 (발행이 되면 반듯이 구독을 해야함)

  - Turbine Server : 마이크로서비스의 스트림 데이터 수집(로그 수집 )

  - Hystrix Dashboaed : 마이크로서비스 스트림 데이터 모니터링 및 시각화 (로그분석 )

    ​									 클라이언트에서 생성하는 스트림을 시각화하여 web화면에 보여주는 									 데시보드

- 마이크로서비스 아키텍처(2)

  - git repository-> config server <-마이크로서비스 (1) - configuration 서버 

    ​		 유레카 server <- 마이크로서비스 (2) -디스커버리 서버 

  - web client -> Zuul 서버 <-마이크로 서비스 (3)

  - service monitoring -> 히스트릭스 대시보드 

    터빈서버 -> 히스트릭스 대시보드 (5)

    터빈서버 -> 마이크로 서비스 (4)
    
  - 하둡 에코 시스템 

    - DFS
    - MapReduce


- .yml 
  spring:
  		profiles: local

  msaconfig:
  		greeting: "Welcome to local server!!!"
  		topic-name: "coffee-topic-local"
  		ipaddress: "192.168.10.102"
  		dbtype: "mysql"                                                          //application-local.yml

  

- 업데이트 


  - 1.5버전 

    - http://localhost:8081/refresh
    - post방식 
    
- zookeeper 설치 -kafka 시스템 

- Rest call

  1. Rest Template 
  2. Feign 

  member.
  
- 직렬화 


  - 
  - 마크업인터페이스 

# 예제 .2

- 8010 eurelca server
- @EnableEurekaServer
  
- 8011 Zuul server

  - @EnableZuulProxy
  - @EnableEurekaClient
  
- 8012 config server 
  - @EnableConfigServer



- localhost:8011/user-ws/         == localhost:apiuser의포트번호 

  - Zuul 서버랑 연결되어있음

  

- cmd 창에서 프로젝트 실행
  - mvn spring-boot:run 
  - mvn spring-boot:run  -Dspring-boot.run.arguments="--spring.application.instance_id=koo9 --server.port=9001"



- AuthenticationFilter URL 변경

  - localhost:8011/user-ws/user/login 

- docker 

  - rabbitmq

  - `docker run -d --name rabbitmq -p 5672:5672 -p 9090:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management -> ` 생성

  - discovery server -> zuul server -> configuration server ->user-ws server (실행 순서)

- 보안 작업 

  - keytool

  - 대칭 암호  

    - config -> bootstrap.yml

      - encrypt:

        ​		key:                -> /encrypt              <--> decrypt

  - 비대칭 암호 

    keytool -genkeypair -alias apiEncryptionkey -keyalg RSA -keypass "1q2w3e4r" -keystore apiEncryptionkey.jks -storepass "1q2w3e4r"

    - congfig -> bootstrap.yml

      - encrypt:

         	key-store:	

        ​	  location: file:///${user.home}/msa/msa/LAB/dev/apiEncryptionkey.jks
    	password: 1q2w3e4r
          	alias: apiEncryptionkey
      
  
- 실행 순서

  - 유레카 (8010)-> config(8012)-> zuul(8011) ->마이크로서비스 api 
