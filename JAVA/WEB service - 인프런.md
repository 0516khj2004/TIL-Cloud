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

