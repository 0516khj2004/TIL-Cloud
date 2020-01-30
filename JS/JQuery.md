# JQuery

### 0. 개요

- jQuery  
  -  모든 브라우저에서 동작하는 클라이언트 자바스크립트 라이브러리
  - 무료로 사용가능한 오픈 소스 라이브러리
- CDN(content delivery network)
  - 콘텐츠를 효율적으로 전달하기 위해 전 세계 여러 지점의 서버에 파일을 저장해두고, 사용자와 가까운 지역에서 해당 파일을 제공해주는 네트워크 시스템을 의미

### 1. 기본

- 다운로드
  - 직접

    - <script src="../jquery/jquery.js"></script>

  - CDN - 인터넷이 되어야함 / 직접가져오는 것보다 더 빠르다 / 양이 적다 

    - <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

- $(document).ready() -> JQuery 사용할때 기본 시작 코드 

```
<script>
	$(document).ready(function(){
        alert("jQuery start");
        $("#buttonred").on('click', function(){
                $("#myh1").css('color','red');  // 아이디 선택자
        });
    });
</script>
<body>
<h1 id="myh1">hello, jquery</h1>
<button id="buttonred">Red</button>
</body>
```

- 선택자
  - class 선택자 -> .
  - id 선책자 -> #
  - 자손 선택자 ->   
    - div>li -> `> `를 사용하면 바로 그 밑에 있는 자손 
    - 공백 -> 밑에 있는 모든 자손 
  - 속성 선택자 -> 
- 배열 관리
  - each() - > 기존의 for문장을 간단하게 가져올 수 있다. 





# Aiax

- .ajax()메서드 

  -  $.ajax({

    ​        url: "./data.html",

    ​        success: function(data){},

    ​        error: function(){}

    ​      });

  -  $.ajax("./data.html",{

    ​        success: function(data) {},

    ​        error: function(){}

    ​      });

- local /server 

  - local 

    url : "./ .json"

  - server 

    https://api.openweathermap.org/data/2.5/forecast

    - 파라미터  ? querystring -> get          form data <- post

    ?q=Seoul&

    APPID=2908634d21bce647335caa5529f4a1f9&

    units=metric

    ```
    url: "https://api.openweathermap.org/data/2.5/forecast",
    method: "GET",
    data: {
        q: "Seoul",
        APPID: "2908634d21bce647335caa5529f4a1f9",
        units: "metric"
    },
    ```

    

