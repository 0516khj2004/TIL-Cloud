# Spring MVC

- MVC(Model - View - Controller)
  - 소프트웨어 공학에서 사용되는 아키텍쳐 패턴으로 MVC패턴의 주 목적은 Business logic 과 Presentation logic 분리하기 위함이다.
  - 시각적요소나 그 이면에서 실행되는 비지니스 로직을 서로 영향 없이  쉽게 고칠수 있는 애플리케이션을 만들 수 있다.

### JSP

- webContent
- import 
  - <%@ page import="java.util.Date" %>

### Servlet

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

- request 요청 

- response 응답





  /**
     * @see HttpServlet#HttpServlet()
          */
        public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
        }