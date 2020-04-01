# SpringBoot -  지인정보 관리 시스템 

> 단축어
>
> - sout -> System.out.println();

### 1. 스프링부트 소개

- spring과 spring boot는 다른 것이다

- springboot는 java의 생산성 향상을 가져왔다.

- 개발자가 설정해야 하는 것은 관례를 따르지 않는 점 뿐이다

  

- hello demo test

  - hello.http 
    - 웹페이지에서 확인하지 않고 intelij에서 결과 확인
    - `GET http://localhost:8080/api/helloWorld`

- MockMVC test

  - http 를 사용해서 test

  ```java
  @Test
  void mockMvcTest() throws Exception {
      mvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
      mvc.perform(
              MockMvcRequestBuilders.get("/api/helloWorld"))
              .andDo(MockMvcResultHandlers.print())
              .andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.content().string("helloWorld"));
  }
  ```

### 2. JPA

- 기본 db 쿼리를 사용하는 거 대신에 자바를 활용해서 사용 한 것

- Repository 생성

  - `public interface PersonRepository extends JpaRepository<Person, Long> {}`

- Lombok

  - @Getter

  - @Setter

  - @ToString

    - toString을 오버라이드 하지 않아도 된다.

    - ```
      @ToString(exclude = "phoneNumber")
      ---------------------------------------
      @ToString.Exclude
      private String phoneNumber;
      
      -> phoneNumber가 보안상 보이지 않아야할때 tostring에서 제외한다.
      ```

  - @Constructor

    - `@NoArgsConstructor` 인자가 없는 constructor
    - `@AllArgsConstructor` 모든 인자가 있는  constructor
    - `@RequiredArgsConstructor` 꼭 필요한 인자만 포함하는 constructor

  - @EqualsAndHashCode

  - @Data

    - ```
      @Getter
      @Setter
      @RequiredArgsConstructor
      @ToString
      @EqualsAndHashCode
      ```

- Relation

  - domain -> Block 

    - 걸러져야하는 객체를 위한 class

  - @OneToOne

    - ```
      @OneToOne
      private Block block;
      ```

    - CascadeType - person class 에서 Block class의 영속성을 같이 관리 함 

    - ```
      @OneToOne(cascade = CascadeType.PERSIST)
      private Block block;
      
      @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
      
      @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
      -> 정말로 삭제까지 됨 /orphanRemoval = true 을 하지않으면 block을 삭제해도 그대로 남아있음 
      ```

    - FetchType

    - optional, orphanRemoval

  - Query Method

    - @Embedded 
    - @Embeddable
    - @Valid
    - @Query

  - Data.sql  - test에서 값을 넣지 않고 자동화 하기 위해서 

### 3. Controller

- person 정보를 조회하는 api 생성

  - @Slf4j - 로그 

    - log.info("person  -> {} " , personRepository.findAll());

  - @GetMapping

    - @PathVariable

    - ```
      @GetMapping("/{id}")
          public Person getPerson(@PathVariable Long id){
              return personService.getPerson(id);
      }
      ```

- person정보를 추가하는 api생성

  - @PostMapping

    - @ResponseStatus(HttpStatus.CREATED) - 성공 201

    - ```
      @PostMapping
      @ResponseStatus(HttpStatus.CREATED)
      public void postPerson(@RequestBody Person person){
          personService.put(person);
      
          log.info("person  -> {} " , personRepository.findAll());
      }
      ```

- person 정보를 수정하는 api생성

  - @PutMapping - 전체 업데이트

    - ```
      @PutMapping("/{id}")
      public void modifyPerson(@PathVariable Long id , @RequestBody PersonDto personDto){
          personService.modify(id, personDto);
      
          log.info("person -> {}", personRepository.findAll());
      }
      ```

  - @PatchMapping - 일부만 업데이트

    - ```
      @PatchMapping("/{id}")
      public void modifyPerson(@PathVariable Long id , String name){
          personService.modify(id, name);
      
          log.info("person -> {}", personRepository.findAll());
      }
      ```

- person정보를 삭제하는 api생성

  - `@BeforeEach` -> 해당 test에서 class마다 매번 먼저 실행한다

  - @DeleteMapping

    - ```
      @DeleteMapping("/{id}")
      public void deletePerson(@PathVariable Long id){
          personService.delete(id);
      
          log.info("person -> {}", personRepository.findAll());
          log.info("people deleted : {}", personRepository.findPeopleDeleted());
      }
      ```

  - @Where : JPA (Person domain)

    - ```
      @Where(clause = "deleted = false")
      ```

### 4. Refactoring

- person에서 age필드 지우고 birthday랑 연결해서 사용하기
- persond에서  bloodType필드 지우기 



### 5. Controller Test

- deletePerson()

  - ```
    assertTrue(personRepository.findPeopleDeleted().stream().anyMatch(
            person -> person.getId().equals(1L));
    ```

- modifyPerson()

  - asserAll -> 확인여부를 전체로 알려준다.

- getPerson()

  - age
  - birthday 

- postPerson()

### 6. Repository Test

```
@Transactional
@SpringBootTest
class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName(){
        List<Person> people = personRepository.findByName("koo6");
        assertThat(people.size()).isEqualTo(1);

        Person person = people.get(0);
        assertAll(
                ()->assertThat(person.getName()).isEqualTo("koo6"),
                ()->assertThat(person.getHobby()).isEqualTo("reading"),
                ()->assertThat(person.getAddress()).isEqualTo("Seoul"),
                ()->assertThat(person.getBirthday()).isEqualTo(Birthday.of(LocalDate.of(1991,7,10))),
                ()->assertThat(person.getJob()).isEqualTo("officer"),
                ()->assertThat(person.getPhoneNumber()).isEqualTo("010-2222-5555"),
                ()->assertThat(person.isDeleted()).isEqualTo(false)
        );
    }

    @Test
    void findByNameIfDeleted(){
        List<Person> people = personRepository.findByName("koo7");
        assertThat(people.size()).isEqualTo(0);
    }

    @Test
    void findByMonthOfBirthday(){
        List<Person> people = personRepository.findByMonthOfBirthday(5);

        assertThat(people.size()).isEqualTo(2);
        assertAll(
                ()->assertThat(people.get(0).getName()).isEqualTo("koo"),
                ()->assertThat(people.get(1).getName()).isEqualTo("koo2")
        );
    }

    @Test
    void findPeopleDeleted(){
        List<Person> people = personRepository.findPeopleDeleted();

    assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("koo7");

        }
}
```

### 7. Service Test 

- Mockito test -> 호출되었다고 가정하는 것
  - when -> if와 같은 뜻 
- mock test로 구현했기때문에 spring test보다 더 빠르다 