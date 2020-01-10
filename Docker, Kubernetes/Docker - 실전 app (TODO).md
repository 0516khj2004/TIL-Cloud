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
  $ docker exec -it manager docker service ps todo_mysql_slave --no-trunc --filter "desired-state=running" --format "doc
  ker exec -it {{.Node}} docker exec -it {{.Name}}.{{.ID}} bash"
  # mysql -uroot -p 
  내용 확인 
  ```

- 

