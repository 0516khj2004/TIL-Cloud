# Docker 볼륨 마운트 (-v)

- index.js 수정 

  - build    --> X (code에서 수정하고 서버를 내렸다가 써야됨 ) - 윈도우즈에서 code 수정 
  - container 에서 수정  -- > docker exec -it 아이디 sh -> 수정 -> docke  restart id 
  - 수정 window , 바로 컨테이너로 반영 (-v 볼륨 마운트 )

- 볼륨 마운트(-v)  -docker 공유 폴더 

  - 호스트 : 컨테이너 (윈도우에서 파일을 수정해도 컨테이너에서 적용)

  ```shell
  $ docker run -v C:\Users\HPE\docker\day01\simpleweb:/home/node -d
  -p 8080:8080 0516khj2004/simpleweb:modified   //-v host파일 위치:container파일 위치  
  ```

  - 컨테이너 : 컨테이너 (이미지가 외부에서도 공유가 된다)

    mysql 컨테이너가 삭제되도 데이터 베이스의 데이터가 mysql-data에 존재하기 때문에  데이터가 존재한다.

  ```dockerfile
  FROM busybox
  VOLUME /var/lib/mysql 
  CMD ["bin/true"]
  ```

  ```shell
  $ docker build -t example/mysql-data:latest .
  $ docker run -d --name mysql-data example/mysql-data:latest
  $ docker run -d --rm --name mysql `
  -e "MYSQL_ALLOW_EMPTY_PASSWORD=yes" `
  -e "MYSQL_DATABASE=volume_test" `
  -e "MYSQL_USER=example" `
  -e "MYSQL_PASSWORD=example" `
  --volumes-from mysql-data `          //mysql-data container과 마운트 함
  -v 호스트폴더:컨테이너폴더 `
  mysql:5.7
  $ docker exec -it mysql mysql -uroot -p volume_test //첫번째 mysql은 컨테이너 이름임 
  
  # create table user(id int primary key auto_increment, name varchar(20));
  
  # insert into user(name) values('User1');
  ```

  

  

