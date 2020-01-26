# Data Base



## 1. data base 

- DBMS(데이터 베이스 관리 시스템) - `oracle`, `mysql`, `mssql`

  데이터베이스를 관리하며 응용프로그램들이 데이터베이스를 공유하며 사용할 수 있는 환경을 제공하는 소프트웨어

  중복제거, 일관성 유지, 데이터의 독립성 , 짧은 시간에 큰 프로그램 개발 가능,파일로 저장됨

  - RDBMS(관계형 데이터 베이스 관리 시스템) `mysql`,  `postgreSQL`, `amason RDS`

    행과 열인 2차원 **테이블** 형태인 관계형 데이터 베이스를 생성하고 수정하고 관리할 수 있는 소프트 웨어

  - NOSQL (not only sql 비정형 데이터 베이스)  `mongoDB,` `mysql cluster`

    - 특수한 데이터 구조를 사용
    - 테이블을 설계하고 싶지 않음 - 단순한 구조

## 2. DB용어 정리 

- DBMS 언어

  - 정의어 (DDL)

    create, alter, drop

  - 조작어 (DML)

    insert, select, delete, update

  - 제어어 (DCL) - 무결성유지, 보안, 병행제어 

    commit, rollback, grant, revoke

- 데이터 웨어 하우스 (DWH)

  의사결정지원 시스템이 효율적으로 운영되기 위해 다양한 소스의 데이터를 별도로 추출하여 관리하는 것   - 칼럼형 데이터 베이스 적합 

- 테이블 (릴레이션)

  -  행(가로) = Row = 튜블 = record = 카디날리티( 행의 수)
  -  열 (세로) = Column = 속성 = 애트리뷰트 = 차수( 열의 수) = 필드

- 도메인

  하나의 속성이 취할 수 있는 같은 타입의 원자 값들의 집합

- 스키마 - 성질의 이름 

  데이터베이스의 전체적인 구조와 제약조건에 대한 명세를 기술 한 것,

  스카마는 컴파일이 되어 데이터 사전에 저장됨

  - 외부스키마 - 서브 스키마, 사용자의 뷰(가상 테이블)
  - 개념스키마 - 전체적인 뷰
  - 내부스미카

- 인스턴스 - 실질적인 내용 

- entity(앤티티) - 실체 객체 

  - 행위 엔티티
  - 중심 엔티티
  - 기본 엔티티

  예) 학생(앤티티) : 학번, 이름,학점(속성)

- 무결성 - 일괄성, 정확성 

  - 키의 무결성 - 하나의 릴레이션에는 적어도 하나의 키가 존재한다
  - 널 무결성 - 속성이 null값을 가질 수 없다.
  - 고유 무결성 - 특정 속성에 대한 각 튜블이 갖는 값은 달라야한다
  - 개체 무결성 - 한 릴레이션의 기본키를 구성하는 어떤한 속성 값도 널값이나 중복값을 가질 수 없다
  - 참조 무결성 - 참조할 수 없는 외래키값을 가질 수 없다
  - 영역 무결성 - 속성값들은 정해진 범위 내에 있어야 한다.

- 키- 릴레이션에 존재하는 튜플을 식별하기 위한 식별자

  - 기본키 - 후보키 중에서 대표로 지정된 키 (중복 x , null x)
  - 후보키 - 정보를 가지고 있는 키
  - 대체키- 기본키를 제외한 후보키 
  - 외래키 - 참조하는 릴레이션의 기본키
  - 고유키 - 언제든지 기본키가 될 수 있다 (null 허용)

## 3. CMD 창에서 MYSQL 사용하기

- 기본적은 db 명령어 

```
$ mysql -u root -p       //mysql에 접속 
 # show database;        //db 목록 출력
 # use mysql;            //해당 db사용
 # show tables;          // table 목록 출력
 # select * from user    // user table에 있는 데이터 출력
 # create database memberdb;  // db 생성 
 # use memberdb;             
 # create table member_tx(id int, name varchar(10), pwd varchar(10));            //table 생성  
```

- 계정 생성 명령어 

```
# create user 'kootest'@'%' identifird by 'test123';
//계정 생성 % - 외부에서의 접속을 허용 
# grant all privileges on memberdb.* 'kootest'@'%'; 
// memberdb 스카마에 모든 테이블에서 모든 조작어가(all) 가능하다
# drop user kootest  // 계정 삭제
```

- table 생성  - create 

  ```
  UNIQUE -- null가능하지만 두번째부터는 안된다.. 유일한 값 
  $ arter table  - 테이블 수정 
  $ drop table - 테이블 전체가 삭제 
  $ traucate table  - 구조는 남아있고 , 데이터만 삭제(완전 초기화_
  
  dml
  insert into
  update ____ set_____where _____
  delete from 테이블이름 where _______ - 22
  ```

  

## 4. JOIN

- 조인 테이블 만들기 2방법
  - 1) select * from  (중복되서 좋지 않은 방법이다 10*20)
  - 2) select * from  where 
  - 3) select* from ___
- 명시 방법 (3가지)
  - 1),
  - 2) JOIN - inner
        from 테이블 1 inner join 테이블 2 on 조인조건 
        where 검색조건
  - 3) LEFT JOIN ----outer  왼쪽에 데이터가 있지만 오른쪽에 데이터가 없더라도 출력이 가능하다
  - 4) self join 
       select a.employee_id , concat(a.first_name, ' ', a.last_name) as name,
       concat(b.first_name, ' ',b.last_name) as '매니저 이름 '
       from employees a left outer  join  employees b
       on a.manager_id =b.employee_id ; 
  - 5)서브 질의 (쿼리에다가 하나의 쿼리가 또 다시 들어가는것)
    where price =(select max(price ) from book  
    범위를 지정할 수 있음
    where cusrid in ( slect custid from orders)  -----중복값 제외 
    - 예시 ) 
      select c.name, b.ublisher 
      from order o join customer c 
      on o.cusiud = c. custod
      join book b 
      on o.bookid = b.bookid
      =둘이 같은 내용임 
      select (select name from customer where custid = o.custid ) as name 
      , (select publicher from book where bookid = o.bookid) as publicher 
      from order as o 
      where custid = (selcet custid from order  where group by custid having count(custid)
    -  예시 )
      select  max(cnt)
      from
      (select manager_id , count(manager_id) as cnt
      from employees
      group by manager_id) as result 
  -  6) 합집합 union 
    컬럼의 개수가 같아야 한다 .