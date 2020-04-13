# Spring Framework

> 비기능적인 요구사항*성능,보안,확장성,안정성 을 만족하는 구조와 구현된 기능을 안정적으로 실행하도록 제어해주는 잘 만들어진 구조의 라이브러리의 덩어리 
>
> 하부 구조를 구현하는 들어가는 노력을 절감하게 해줌 
>
> 업무 개발자는 기능적인 요구사항(biz logic) 개발에 전념할 수 있게 해준다.
>
> Java 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크이다
>
> 라이브러리 -> 개발자가 제어권을 가짐
>
> 프레임워크 -> 프레임워크가 제어권을 가짐 / 개발자가 작성한 클래스를 프레임워크 컨테이너가 객체를 생성하고 setter method를 호출한다.
>
> jar(java archive)

- spring 기술

  - 마이크로 서비스 
  - Reactive
  - Cloud
  - Web apps
  - SErverless
  - Event  Driven
  - Batch

- spring 프레임워크 특징 

  - [Core technologies](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html)

    -  `dependency injection(의존성 주입- DI)`, events, resources, i18n, validation, data binding, type conversion, SpEL, `AOP(관접 지향 프로그래밍 - Aspect Oriented Prigramming) `

    - IoC(Inversion of Control) - 제어의 역전 

      생명주기 관리를 개발자가 아닌 컨테이너가 대신 해준다

      - DL(DEpendency Lookup - 의존성을 찾음)
      - DI(dependency injection - 의존성 주입)
        - **setter** injection - 기본생성자로 객체를 생성하고 setter method의 인자로 의존하는 객체를 1개씩 주입해 주는 방식
        - **constructor** injection  - (중복정의된)오버로딩 생성자로 객체를 생성하고 이 생성자의 인자로 의존하는 객체를  여러개씩 주입해 주는 방식 
        - method injection

    - spring Dl

      - 빈
        - 스프링이 관리해주는 객체
      - 빈 팩토리 - 빈 컨테이너
        - spring bean 컨테이너 역활을 한다
        - getBean() 메서드로 요청을 한다
      - 애플리케이션 컨텍스트(application Context) -빈 컨테이너
        - spring bean 컨테이너 역활을 한다
      - 설정 메타 정보

  - [Testing](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html)

    - mock objects, `TestContext framework`, Spring MVC Test,

  - [Data Access](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/data-access.html)

    - transactions,` DAO support(Data Access Object)`, `JDBC(Java Database Connectivity)`, `ORM(Object Relational Mapping)`, Marshalling XML.
    - MyBatis - 
    - JPA(java Persistence api) -spring boot

  - [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)(Model View Controller)  

    - 웹 어플리케이션 만들때의 대표적인프레임 워크 
    - JSP(java server page) - 자바 서버 사용

  - Spring Restful web service

    - JSON,Xml
    - 데이타 중심으로 웹 상에 제공 

  - Ajax

    - 비동기적인 자바스크립를 통해서 제공하는 프레임워크 
    
  - 디자인 패턴(Design Pattern-GoF(gang of four) pattern) 

- 역활

  - 라이브러리 - 객체생성을 개발자가 한다 (객체 생성의 주도권 개발자)
  - 프레임워크 
    - 객체 생성을 프레임워크가 제공하는 컨테이너가 한다(객체 생성의 주도권 프레임 워크)
       - 프레임워크를 사용할 때 개발자는 xml(프레임워크와 개발자 사이의 소통 역활)에 설정을 반드시 해야한다.

- 스프링 프레임워크 전략

  - spring 삼각형

    - 엔터프라이즈 개발의 복잡함을 상대하는 spring의 전략

       Portable Service Abstraction, DI, AOP, POJO

- spring context 

  > npm (node package manager)

  - Maven   -> 라이브러리 설치해주는 것 
    - <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>4.3.26.RELEASE</version>
      </dependency>
  - pom.xml -> Maven을 위한 설정 파일

- 프로젝트 만들기 순서

  - dynamic web project 생성 -> web설정 체크 
  - configure에서 maven project로 변경 -> pom.xml
  - pom.xml -> dependency  추가 ->https://mvnrepository.com/artifact/org.springframework/spring-context/4.3.26.RELEASE 카피해오기
  - src-> config폴더 만들어서 -> spring_bean.xml 만들기 (bean, context 추가)
  
- Open Source 

  - Spring(Context, Test)
  - Maven(Pon.xml)
  - junit
  - Tomcat(web container)

# jUnit

- jUnit
  - Java에서 독립된 단위테스트(Unit Test)를 지원해주는 프레임워크이다.
- 특징
  - 단정(assert) 메서드로 테스트 케이스의 수행결과를 제공	
    - assertEquals(a, b); -> 객체 A와 B의 값이 일치함을 확인한다.
    - assertSame(a, b); -> 객체 A와 B가 같은 객체임을 확인한다. assertEquals 메서드는 두 객체의 값이 같은지 확인하고, assertSame메서드는 두 객체의 레퍼런스가 동일한가를 확인한다. (== 연산자) 
  - jUnit4부터는 테스트를 지원하는 어노테이션을 제공한다.     
    - @Test
    - @Before
      - test 전에 수행되기 전에 실행한다.
    - @After 
    - @Ignore 
      - 선언되지 않는다.

# Spring Test

- Spring-Test에서 테스트를 지원하는 어노테이션(Annotation) 

  - @RunWith(SpringUnit4ClassRunner.class)

    - junit 프레임 워크를 SpringTest로 확장하는 어노케이션
    - Singleton의 ApplicationContext를 보장한다.

  - @ContextConfiguration(locations = "classpath:config/spring_beans.xml")

    - 스프링 Bean 설정 파일의 위치를 지정할 때 사용되는 어노테이션 

    - ```
      BeanFactory factory = newGenericXmlApplicationContext("config/spring_beans.xml");	
      ```

      junit Test 구문과 같은 역활을 한다.

  - @Autowired

    - getBean과 동일한 역활
    - <property ref=""  />
  
  - @Component
  
    - <bean>
  
  - @Value 
  
    - <property ref="" />
  
  - @Qualifier("stringPrinter")
  
    - 타입이 2개 이상일 때는 지정해야한다

# DI 구현하는 전략 3가지

> 용어 정리
>
> - bean -  스프링이 IoC방식으로 관리하는 객체
> - beanFactory, ApplicationContext - bean 생성 , Spring Bean Container 
> - Configuration MetaData

- 전략 1  - .xml로 구현하는 방식 

  - configuration(설정)을 xml에 한다
  - 장 : 전체 의존관계 구조를 파악하기 쉽다.
  - 단 : xml 파일 공유의 문제점  - 
  - setter injection
    - <bean id="bean의 고유한 이름 " class="package.class이름"  / > 
    - <!-- setValue(Integer val) -->
    - <property name="value" value="100" />
    - <!-- setMyPrinter(Printer p) -->
    - <property name="myPrinter" ref="strPrinter" /> 
  - contructor injection
    - <!-- public Hello(Interger val, String name, Printer pr) -->
    - <bean id ="helloC" class="xxx.hello">
      - <contructor-arg name="val" value="100"/>
      - <contructor-arg name="name" value="스프링" />
      - <constructor-arg name="pr" ref="strPrinter"/> 
    - </bean>

- 전략 2 

  - annotation과 XML를 혼용해서 사용 

  - 장:  개발모드시 편리하다, xml파일 설정이 좀 더 간단해져서 관리가 용이

  - 단: 의존관계를 파악하기가 전력1보다 쉽지 않다,

  -  Annotation

    - <-- <bean> 태그와 동일, bean으로 등록함-->
    - @Component
    - @Controller
    - @Service 
    - @Repository
    - <-- 의존관계가 있는 bean을 찾으러 자동으로 주입시켜 주는 기능-->
    - @Autowired(@Qualifier)  - Type으로 찾음
    - @Value
    - @Qualifier - 타입이 2개 이상일 때는 지정해야한다
    - @Resource - bean의 name(or id)으로 찾음

  - .xml

    - <context:component-scan base-package="myspring.di.annot" />

      :basepackage에서 지정한 팩키지의 아래의 모든 클래스에 선언된 @Component 등  찾아주는(Auto scanning) 기능 

- 전략 3  - java config, No xml

  - Annotation
    - @Configuration - java Config 클래스 
    - @Bean - <bean>태그와 같은 역활 
    - @ComponentScan - < context:component-scan > 태그와 같은 역활 



# Oracle SQL

- JDBC 

  - 인터페이스와 구현을 분리 

    - 특정 db에 종속되지 않고 벤더 중심적으로 어플리케이션을 구현하기 위해서

  - coding 절차

    1. Driver 등록 - class.forName("oracle.jdbc.driver.OracleDriver");
    2. DBMS와 연결 (DB와 연결을 담당하는 Connection 객체 생성)
       - DriverManager.getConnection(url, user, pass);
          - connection 객체가 만들어진다.
          - String url = "jdbc:oracle:this:@localhost:1521:xe"
          - String user = "scott"
          - Stirng pass = "tiger"

    3. statement 생성 - sql 전송해주는 역활을 담당하는 statement 객체 생성  

       - Statement stmt = conn.createStatement();

    4. SQL전송 - executeQuery( ), executeUpdte( ) 메서드 사용

       - (select ) ResultSet set = stmt.executeQuery(query)

         ​				while(re.next()){  String id = rs.getString("userid") ;

         ​												integer value = rs.getInteger(2) ;}

       - (등록 갱신 삭제 ) int cnt = stmt.executeUpdate(query) 

    5. 결과 (사용했던 자원들 받기 ) 닫기  - close()

       - ResultSet, Statement , Connection의 close();

  - javase 포함된 jdbc api는 인터페이스가 대부분을 차지한다

  - java.sql, javax,sql 패키지

  - 인터페이스 구현은 DB vendor 가 한다

  - DB vendor 가 제공하는 JDBC Driver jar(zip) 을 사용한다.

  - Vo(value object) - 변수를 생성하고 get, set를 가진 class -

    - or Java Beans , DTO(Data Transfer Object), Entity 

- ORM (Object Relaction Mapping)

  - MyBatis, JPA

  - 매핑  Rule 

    - | java      | db          |
      | --------- | ----------- |
      | Class(VO) | table       |
      | Object    | Row(Record) |
      | Variable  | Column      |

