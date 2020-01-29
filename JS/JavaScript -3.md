# JavaScript -3

### 10. 문서 객체 모델

> ​	document객체와 관련된 객체의 집합 

- 기본document 객체

  - createElement(tagName) - > 요소 노드를 생성
  - createTextNode(text) -> 텍스트 노드를 생성
  - appendChild(node) - > 객체에 노드를 연결 

  ```{
  <script>
      window.onload = function(){
          let h1_tag = document.createElement('h1');
          let greeting_text =document.createTextNode("Hi, there");
          
          document.body.appendChild(h1_tag);  
          h1_tag.appendChild(greeting_text);
      }
  </script>
  ```

  -	 ​	*순서 중요* 
  1. <script>를 </body> 아래에 실행 
  2. window.onload = function(){}  onload는 모든 실행 끝

- 이미지 이용 <img src="" widht="" height="">

  ```
   let myImg = document.createElement("img");
   myImg.src = "cotroller.png";
   myImg.width = 100;
   myImg.height = 100;             // 속성 
   document.body.appendChild(myImg);
  ```

- innerHTML -> 태그의 내부를 의미하는 속성 / 전의 데이터가 사라질수 있다

  ```
  document.getElementById(blue).innerHTML ="<h1 style='color:blue;'>HELLOW</h1>";
  ```

  - getElementById("") -> id 속성을 가져옴

  ```
   <script>
   let div1 = document.getElementById("myDiv1");
   div1.innerHTML = "<h1 style='color:blue;'>HELLOW</h1>";
   </script>
   <body>
      <div id="myDiv1"></div>
  </body>
   
  ```

  - innerText -> 문자열이 출력됨 
  - getElementsByName("name")
  - getElementsByTagName(tagName)

  ```
   <script>
    function saveTemporary(){
        let selectsns = document.getElementsByName("sns");
        let selectedcount = 0 ;
        for(let i=0; i<selectsns.length; i++){
            if(selectsns[i].checked){
            selectedcount++;
            console.log(selectsns[i].value);
            }
        }
        if(selectedcount ==0){
        alert("sns 필수 선책사항이다")
        }
    }
  </script>
  
  <input type="checkbox" name="sns" value="facebook"> facebook
  <input type="checkbox" name="sns" value="twitter"> twitter
  <input type="checkbox" name="sns" value="google"> google
  <input type="checkbox" name="sns" value="instagram"> instagram
  ```

- openAPI- 이용하기 - weather.html

- setInterval -> 설정한 시간마다 재 설정 

  ```
  window.onload = function(){
      let clock = document.getElementById("clock");
  
      setInterval(function(){
          clock.innerHTML = new Date().toString();
      },1000);
  }
  ```

### 11. 이벤트 - on

- window.onload -> 웹브라우저에서 자동으로 실행되는 이벤트 - 이벤트를 연결하다.

  - 1. 이벤트 대상 선택
    2. 이벤트 종류 선택

- onclick -> 클릭 이벤트  

  ```
  clock.onclick = function(){
  	clock.style = "color:red;"
  	clock.style.backgroundColor = "blue";
  }
  ```

- 



  

