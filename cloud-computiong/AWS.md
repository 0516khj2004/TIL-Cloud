# AWS 

### 1. EC2

- 인스턴스 생성

  ![](C:\Users\HPE\TIL\images\ec2.PNG)

- xshell -인스터스 연결

  - 사용자이름 - ec2-user
  - key 기반 로그인- 다운받은 키 

<img src="C:\Users\HPE\TIL\images\xshell-ec2.PNG" style="zoom: 67%;" />

- 인스턴스 정리

  우클릭> 인스턴스 상태>종료

![](C:\Users\HPE\TIL\images\ec2-down.PNG)

### 2.NoSQL 테이블 생성 및 쿼리 -DynamoDB

> 완전 관리형 클라우드 데이터베이스로서  문서 모델과 키-값 스토어 모델을 모두 지원한다

- 원본 NoSQL만들기

  ![](C:\Users\HPE\TIL\images\테이블 생성.PNG)

- 데이터 추가

![](C:\Users\HPE\TIL\images\데이터 추가.PNG)

- NoSQl 테이블 쿼리하기

  **Artist** : *No One You Know*

  **SongTitle** : *S* // S로 시작하는

  <img src="C:\Users\HPE\TIL\images\테이블 쿼리.PNG" style="zoom:67%;" />

## 3. Amazon Linux 2를 사용하여 LAMP 웹 서버 설치

- 인스턴스 생성

  SSH(포트 22), HTTP(포트 80), HTTPS(포트 443) 

- LAMP 웹 서버 설치

  ```
  $ sudo yum update -y 
  $ cat /etc/system-release  //버전 확인 -Amazon Linux 2
  $ sudo amazon-linux-extras install -y lamp-mariadb10.2-php7.2 php7.2
  $ sudo yum install -y httpd mariadb-server
  ```

- Apache 웹 서버 시작 

  ```
  $ sudo systemctl start httpd
  $ sudo systemctl enable httpd
  $ sudo systemctl is-enabled httpd
  
  인스터스 퍼블릭DNS 웹 페이지에 들어가서 웹 서버가 시작된 것을 알 수 있다.
  ```

- 파일 원한 설정

  `c2-user`와 `apache` 그룹의 향후 멤버는 Apache document root에서 파일 추가, 삭제, 편집을 할 수 있고, 이를 통해 사용자는 정적 웹 사이트 또는 PHP 애플리케이션과 같은 콘텐츠를 추가할 수 있다.

  ```
  $ sudo usermod -a -G apache ec2-user
  $ exit // 재부팅하기
  $ groups // 그룹확인 
  $ sudo chown -R ec2-user:apache /var/www // /var/www 및 그 콘텐츠의 그룹 소유권을 apache 그룹으로 변경합니다.
  $ sudo chmod 2775 /var/www && find /var/www -type d -exec sudo chmod 2775 {} \;
  $ find /var/www -type f -exec sudo chmod 0664 {} \;
  ```

- LAMP서버 테스트

  ```
  $ echo "<?php phpinfo(); ?>" > /var/www/html/phpinfo.php  // php페이지 생성
  퍼블릭 DNS/phpinfo.php 
  $rm /var/www/html/phpinfo.php  //파일 삭제
  ```

  ![](C:\Users\HPE\TIL\images\php.PNG)

- 데이터베이스 설정 - mariadb

  ```
  $ sudo systemctl start mariadb
  $ sudo mysql_secure_installation
  $ sudo systemctl enable mariadb
  ```

- phpMyAdmin 설치

  ```
  $ sudo yum install php-mbstring -y
  $ sudo systemctl restart httpd
  $ sudo systemctl restart php-fpm
  $ cd /var/www/html
  $ wget https://www.phpmyadmin.net/downloads/phpMyAdmin-latest-all-languacat ges.tar.gz
  //phpMyAdmin 최신 릴리스의 소스 패키지 다운
  $ mkdir phpMyAdmin && tar -xvzf phpMyAdmin-latest-all-languages.tar.gz -C phpMyAdmin --strip-components 1 // 압축풀기
  $ rm phpMyAdmin-latest-all-languages.tar.gz
  
  퍼블릭 DNS/phpMyAdmin 
  ```

  ![](C:\Users\HPE\TIL\images\phpmyadmin.PNG)

## 4. Elastic Beanstalk  사용시작

- 애플리케이션 생성  - 플랫폼 docker 선탣

  <img src="C:\Users\HPE\TIL\images\Elastic Beanstalk.PNG" style="zoom:50%;" />

- 새 버전 배포

  단일 컨테이너docker 

- 용량 변경 

  <img src="C:\Users\HPE\TIL\images\용량.PNG" style="zoom:80%;" />

## 5. 자습서 : Amazon EC2에서 애플리케이션의 가용성 향상

> Amazon EC2 Auto Scaling  :
>
> - 애플리케이션에 대한 실행 인스턴스 수를 항상 최소한으로 유지할 수 있다.
> - 인스턴스나 애플리케이션의 가용성을 유지
> - ec2용량을 확장하거나 축소할 수 있다.

1. vpc - 가상 사설 클라우드 생성 172.16.0.0/16

   서브넷1 172.16.0.0/24

   서브넷2  172.16.1.0/24

2. 인스턴스 2개 생성 

   인스턴스 1 - 서브넷1

   인스턴스 2 -서브넷2

3. 로드밸런스 생성

   - 가용영역 선택

     <img src="C:\Users\HPE\TIL\images\가용영역.PNG" style="zoom:80%;" />

    - 보안 그룹 구성

      https /http / ssh   -- 위치무관 

4. 인터넷 게이트웨이 생성

5. 접속확인

   ![](C:\Users\HPE\TIL\images\ㅇㅇㅇ.PNG)

6. 결과

   <img src="C:\Users\HPE\TIL\images\1.PNG" style="zoom: 80%;" />

![](C:\Users\HPE\TIL\images\2.PNG)