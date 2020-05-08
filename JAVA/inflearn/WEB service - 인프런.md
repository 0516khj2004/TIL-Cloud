# WEB service



### Section 1.

- REST 

  - HTTP 메소드를 통해서 resource를 처리하기 위한 아키텍처 
  - RESTful
    - 웹 브라우저  -> 서버 
    - Resource -> url 

- Spring boot 

  - 스프링프레임워크에서의 별도의 설정을 안해도 된다 .
  - 비지니스 로직을 하는데 시간을 투자할 수 있다 .

- spring boot 동작 원리 

  - application.yml 

    - 설정이름 :  값 
    - 환경설정 파일 

  - DispatcherServlet -> '/'

    - 클라이언트의 모든 요청을 한곳으로 받아서 처리

    - 요청에 맞는 Handler로 요청을 전달

    - Handler의 실행 결과를 Http Response형태로 만들어서 반환 

      ![](C:\Users\0516k\OneDrive\Pictures\dispatcherServler.PNG)

  - RestController 

    - 전달하고자 하는 메세지를 restbody에 저장하지 않고 전달가능 

- Path Variable 

  - 값을 전달하여 endpoint에 저장할 수 있다 .
  
- @Bean 

  - 메소드 어노테이션 

### Section 2.  - User Service API추가  - 비지니스로직

- User Domain
- GET
- POST
- Exception Handling 
- DELETE



### Section3.  - RestFul Service 기능확장 

- Validation
  - @Valid 
- Internationnalization(다국어 처리 라이브러리 )
- XML format으로 반환하기
- Filtering
- Version 관리 
  - URI versioning
  - Request Parameter Versioning
  - Media type versioning
  - headers versioning

### Section4. -Spring Boot ApI 사용 

- REST API Level3을 위한 `HATEOAS` 설정 

  - 현재 리소스와 연관된(호출 가능한 ) 자원 상태 정보를 제공 

- REST API Documentation을 위한 `Swagger` 설정 

  - 도움말 api 
  - Swagger-ui

- REST API Monitoring을 위한 `Actuator` 설정

  - 현재 서버의 상태를 알 수 있다 .

  - .yml에 추가하면 더 많은 정보를 모니터링 할 수 있다.

    - ```
      management:
        endpoint:
        endpoints:
          web:
            exposure:
              include: "*"
      ```

  - HAL Browser 

- Spring Security

  - xml
    - spring-boot-starter-security 인증처리가능함 

### 5. Section

- JPA개요 

  - jpa(java persistence API)
    - 자바 ORM기술에 대한 API 표준 명세 
    - 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스 
    - EntityManager를 통해 CRUD 처리
  - Hibernate 
    - JPA의 구현체, 인터페이스를 직접 구현한 라이브러리 
    - 생산성, 유지보구 ,비종속성
  - Spring Data JPA
    - springModule
    - Jpa를 추상화한 Repository 인터페이스 제공 

- Entity

  - @Entity 사용하면 h2 db에 테이블이 생성된다 .
  - id 값에 @id , @GeneratedValue을 넣어준다 
  - resoures 폴더에 .sql문 파일을 제공하면 값이 들어간다.
  - Repository 
  - Controller 
    - findAll - 전체 조회
    - findById  - 개별 조회 
      - Optional<User> user = userRepository.findById(id);
    - deleteById - 개별 삭제 
    - save - 등록 

- H2 console사용을 위한 SecurityConfig 파일 수정

- JPA Service를 위한 GET/POST/DELETE메소드 추가

- Post Entity 추가와 User Entity와의 관계 설정  

  - user : post -> 1:N  -> main: sub

  - user 도메인 

    - @OneToMany(mappedBy = "user")

      private List<Post> posts;

  - post 도메인 

    - @ManyToOne(fetch = Fetch.Lazy) -> jpa 지연 로딩 
    - private User user;

### 6. Section - Restful APl 설계 가이드

- Richardson Maturity Model(성숙도 모델)
  - Level 0
  - Level 1 
    - Resources
  - Level 2
    - HTTP Methods
  - Level 3 
    - Level2 + HATEOAS 
    - Hypermedia controls
- Best Practices