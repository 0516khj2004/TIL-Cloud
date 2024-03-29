# Spring boot - restaurant

## # 개념

- Dependency injection - 의존성 주입

  - 의존관계 

     a는 b에 의존한다 => a가 b를 사용한다 =>b에 의해 a에게 영향 

- Spring  IoC Container -  스프링이 직접 관리

  - @Component
  - @Autowired

- Mock Object 

  - Mockito

  - @MockBean

    - ```java
      List<Restaurant> restaurants = new ArrayList<>();
      restaurants.add(new Restaurant(1004L, "Bob zip","Seoul"));
      
      given(restaurantService.getRestaurants()).willReturn(restaurants);
      ```

  - @Mock 

    - ```java
      MockitoAnnotations.initMocks(this);
      ```

- JPA - java persistence  API

  - persistence  - 영속화 
  - Hibernate -
  - @Entity
  - Spring Data JPA 사용 
  - H2 - in memory

- front-end

  - Webpack
  - CORS - Cross-Origin Resource Sharing
    - @CrossOrigin

- Lombok

  - @Setter
  - @Getter
  - @Builder
  - @NoArgsConstructor  
    - 기본생성자를 쓰지 않을 때

- Validation - 사용자가 입력을 잘 못 했을 때

  - @Valid -- HTTP Satus400(Bad request)
    - @NotNull
    - @NotEmpty
    - @Size(max =10)

- Not Found - HTTP Satus404(Not found)

  - @ControllerAdvice
  
- ./gradlew build   => 한번에 돌리기 위해서 (3개의 api)

  - jar { enabled = true }
  - bootJar { enabled = false }

## # 레이아웃

- UI Layout
  - interfaces
    - Controller
- Application Layout
  - application
    - Restaurant service
- Domain Layout 
  - domain
    - Restaurant 
    - Repository

##  #  가게 - 구성

- 가게 목록  -  GET/restaurants

  - Http Status 200

  - ```java
    @GetMapping("/restaurants")
    public  List<Restaurant> list(){
       List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }
    ```

- 가게 상세 - GET/restaurants/{id}

  - Http Status 200

  - ```java
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = repository.findById(id);
    
        return restaurant;
    }
    ```

- 가게추가 - Post/restaurants 

  - Http Status 201(Created)

- 가게 수정 - PATCH/restaurants/{id}

  - Http Status 200

  - @Transactional - > 자동으로 db에 업데이트 됨

    addRestaurant의 save(restaurant)이랑 같은 기능

    ```java
    @Transactional
    public Restaurant updateRestaurant(long id, String name, String address) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        restaurant.updateInformation(name, address);
        return restaurant;
    }
    ```

## #메뉴 관리

- Bulk Update 
  - 한꺼번에 처리하는 방법 
- 메뉴 추가 -  PATCH/restaurants/{id}/menuitems
  - Http Status 200
  - 메뉴 전체 추가 
  - save 
  -  deleteById 
  - id 입력하지 않음 
- 메뉴 삭제 
  - id: 2
  - "destroy": true -> 메뉴를 삭제하겠다는 의미  
  - @Transient - db에 넣지 않을 때
- 메뉴 변경
  - id : 2 
  - 같은 아이디 입력

## # 고개 평가

- 고객 리뷰 등록
  - Post/restaurants /{id}/reviews

## # 프로젝트 분리

- common
  - 공통적인 부분
- admin-api
  - 관리자 api
- customer-api
  - 고객 api

## #진짜 영속화(db영구저장)

- h2 db 
  - momory -> file 로 변경에서 저장되게 함  
  - Profiles -> 테스트할때, 저장할때, 진짜로 사용할때 
- h2 -console 
  - localhost:8080/h2-console

## #가게목록 필터링

- 지역(Region)  - 35~37
  - address
    - findAllByAddressContaining - address에 포함된 문자열 
      - findeAllAddressStartingWith - address에 시작하는 문자열 
  - admin-api 
    - GET/ regions
    - POST/regions
  - customer-api
    - GET /regions
- 분류 (Category) 38~40
  - admin-api 
    - GET/ categorys
    - POST/categorys
  - customer-api &category=3
    - GET /categorys

## # 사용자 관리 - admin-api (User)

- User
  - email - 고유번호
  - name
  - level - role
    - 1 - coustomer
    - 2 - restaurant owner 
    - 3 - admin
- admin-api
  - User list
  - User create - 회원가입
  - User update
  - User delete(deactivate()) 
    -  level이 0이 되어서 아무것도 할 수 없는 상태가 됨 

## # 회원가입 - customer-api(User)

- Password

  - Hashing -> Spring Security-> (HttpSecurity)

    - ```
      implementation 'org.springframework.boot:spring-boot-starter-security'
      ```

    - SecurityJavaConfig.clss 

      - 만들어서  security로 부터 만들어진 로그인from등을 disable한다 

    - BCrypt

-  coustomer-api

  - e-mail
  - Name
  - Password 

## #인증(Authentication)

- Authentication
- Post / session
  - access Tocken

## # JWT(JSON WEB Token)

- 3Part
  - Header.
    - 어떤 타입
    - 어떤 알고리즘
  - Payload. 
    - 어떤 데이타 (암호화X)
  - Singnature.
    - Claims (많은 데이터를 담는 것은 좋지 않다)
      - 사용자 id, 사용자 name 등,,, 
    - JMAC-SHA256 (서명 데이타)
- Base64 URL Encoding

## # 인가(Autherization)

- Stateless 
- Heater을 통해서 
  - Authorization: Bearer
- Filter(BasicAuthorizationFilter)
  - 모든 요청에 대해서 토큰이 세팅됨 
- AuthorizationTocker
  - spring내부에서만 사용된 

## #로그인 Api(Stateless 상태를 가지고 있지 않은 데이터)

- eatgo-login-api
  - User reataurantId

## # 테이블 예약(Reservation)

- Reservation
  - uerId
  - name
  - dare
  - time
  - partySize
- 예약 하기
  - POST/reservations
- 예약보기
  - GET/reservations
- eatgo-customer-api
- eatgo-admin-api

## # Multi API Server

- container(Docker Compose)
  - front end
  - mysql 
- docker-compose.yml
  - env_file - .env
  - volumes - ./data/mariadb
  - healthcheck
- docker 실행
  - ./gradlew bootJar
  - docker-compose up
  - docker-compose ps
  - 