# Spring MVC

> MVC(Model - View - Controller)
>
> - 소프트웨어 공학에서 사용되는 아키텍쳐 패턴으로 MVC패턴의 주 목적은 Business logic 과 Presentation logic 분리하기 위함이다.
> - 시각적요소나 그 이면에서 실행되는 비지니스 로직을 서로 영향 없이  쉽게 고칠수 있는 애플리케이션을 만들 수 있다.

### J2SE / J2EE(enterprise edition)

- j2ee가 제공하는 API에는 대부분이 인터페이스로 구성이 되어있다
- 인터페이스들은 was(web app server) vender가 구현한다 . 
- was -> web container + ejb container 
-  JSP / servlet, ejb, jpa(java persistence api), jta(java transaction api), jms(java messaging service, async)

### JSP

- html 내에 java code를 포함시킬 수 있다. 스크립트

- webContent
- import 
  - <%@ page import="java.util.Date" %>
- java 구현
  - <% %> : jsp안에 java code를 자유롭게 기술 할 수 있는 영역, scriptlet tag
  - <%= %> : java의 method의 실행 결과, 변수를 출력 expression tag

### Servlet

- java code 내에 html을 포함시킬 수 있다. 컴파일 

- src  

  - 1. Content Type 설정 - Mine Type, encoding 
       		response.setContentType("text/html; charset=utf-8");
    2.  출력 스트림 생성 
       		PrintWriter out = response.getWriter();
    3. html 생성
       		Date date = new Date();
       		out.println("<h2>현재 날짜는 : " + date +"</h2>" );
       		out.println("Http Method : " + request.getMethod());
       		out.close();

  - @WebServlet("/hello") 경우 
  - web.xml 에 설정하는 경우 

- request  -> 요청 

- response -> 응답

### MVC 

- html -> servlet/jsp-> java
- mvc 패턴을 기반으로 web app architecture (Model2 architecture)
  - view -> jsp(jstl 라이브러리 ), html
  - controller -> Servlet, 
  - model -> java(dao, service, vo)
- web.xml 2가지 설정 
  - Spring Beans Configuration XML 정보를 Tomcat에 알려줘야 함
  - FrontConroller 역활을 수행하는 Disp
- Spring MVC기반 웹 어플리케이션 작성 절차
  1. 클라이언트의 요청을 받는 DispatcherServlet를 web.xml에 설정
  2. 클라이언트의 요청을 처리할 Controller를 작성
  3. Spring Bean으로 Controller를 등록
  4. JSP를 이용한 View 영역의 코드를 작성
  5. Browser 상에서 JSP를 실행