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

##  # 구성

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