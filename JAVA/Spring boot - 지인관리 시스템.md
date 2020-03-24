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