# JavaScript

### 1.개요

- javaScript

  `Html5` 의 도입

  ECMAScript6(ES6)가 모테가 되어 만들어진 언어

- () - 함수 or 산술연산

- +- 문자열 결합 or 덧쌤

- 기본 함수 

  - alert() 경고창
  - confirm() 확인창(버튼 2개)
  - prompt() 입력창 

### 2. 기본문법

- 키워드 : 자바스크립트가 처음 만들어질 때 정해진 특별한 의미가 있는 단어

- 식별자
  - 키워드 안됨
  - 숫자로 시작하면 안됨 
  - 특수문자 안됨( _ ,$ 만 허용)
  - 공백문자 안됨 
  
- 주석
  - <!-- 주석문 -->
  
  - // 주석문 
  
  - /*
  
    주석문
  
    주석문
  
    */
  
- 자료형

  - 숫자 자료형 - 사칙연산( + - * / %)

  - 문자열 자료형 - \ (특수 문자 허용할 수 있도록 하는 문자열 ex- \ ")

  - 불 자료형   

    - 비교연산자 (=== , !== // 값과 data type이 같(다르)다)

    ```javascript
     var a = 10;
     var b = "10";
     console.log(a == b);     // true
     console.log(a === b);    // false
    ```

    - 논리연산자( !-not ,  &&-모두 참일때만 참 논리곱 ,||-모두 거짓일때만 거짓논리합)
    - 조건문  

    ```javascript
    var userValue = prompt("값을 입력하세요!");
    console.log("당신이 입력한 값은 " + userValue);
    //짝수인지 홀수 인지 판단하기 
    if(userValue % 2 ==0){
    console.log("짝수입니다")
    }else{
    console.log("홀수입니다.")
    }
    ```

- 변수 선언

  - var

    중복으로 선언해도 오류가 나지 않는다 - 요즘은 var를 권장하지 않는다.

  - let - local변수 

    중복으로 선언하면 이미 선언된 변수라고 오류가 난다 - ㅇ권장 

    ```javascript
     let userValue = prompt("값을 입력하세요!");
     userValue = "TEST1"                              //const오류
     console.log("당신이 입력한 값은 " + userValue);
     let userValue = "TEST2"                           
     console.log("당신이 입력한 값은 " + userValue);     // let오류 
    ```

  - const - 상수값(한번 정해지면 겂 갱신 x)을 사용할때 

  - 복합 대입 연산자 

    - window.onload - 최초에 실행되는 이벤트 
    - function() - 익명의 함수 
    - += 복합 대입 연산자
    - document.body.innerHTML - js 함수 (body에 html 형태로 출력 함수)

    ```javascript
    window.onload = function(){
                let list ='';
                list += '<ul>';
                list += '   <li>Hello</li>';
                list +='    <li>JavaScript</li>';
                list +='</ul>';
    
    			document.body.innerHTML = list;
    };   
    ```

  - 증감 연산자

    ```javascript
    let a = 10;
    console.log(a);  //10
    console.log(a++);//10
    console.log(++a);//12
    console.log(a);//12
    ```

- 자료형 검사

  - typeof

    ```javascript
     let a = 10;
     let b = "10"
     console.log(typeof(a));  // number
     console.log(typeof(b));  //string
     console.log(a === b)     //false
    ```

- 숫자와 문자열 자료형 변환 **casting-> 형변환**

  - Number()

    - NaN(Not a Number)

    ```javascript
     let userdata = prompt("숫자를 입력하세요");
     let cov = Number(userdata);
     let result = cov +10; 
    
     console.log("restult=" + resu11lt);
    ```

  - String()



### 3. 조건문

- if elseif

  ```html
  <script>
          let useko = Number(prompt("국어 점수"));
          let useen = Number(prompt("영어 점수"));
          let usema = Number(prompt("수학 점수"));
  
          let avg = (useko + useen +usema)/3;
  
          if(avg >=90){
             grade = "수" ;
          }else if(avg >=80){
              grade = "우"
          }else if(avg >=70){
              grade = "미"
          }
          else if(avg >=60){
              grade = "양"
          }else{
              grade = "가"
          }
          alert("당신의 점수는 " + grade  + "입니다");
          console.log(avg);
  </script>
  ```

- switch

  ```javascript
   switch(avg){
       case 90: console.log("A"); break;
       case 80: console.log("B"); break;
       case 70: console.log("C"); break;
       case 60: console.log("D"); break;
       default: console.log("F"); break;
   }	
  ```

- 삼항 연산자

  (number > 0) ? alert('자연수입니다'): alert('자연수가 아니다');

- 짧은 조건문

  - and  ->&&
  - or ->||

- test 

  - indexOf() 



### 4.반복문

- 배열 

  ```html
  <script>
      let array = [ 273,32, 103,57,52];
  
      console.log(array);         // [ 273,32, 103,57,52];
      console.log(typeof array);  //object(객체타입)
      console.log(array.length);  //5
      console.log(array[0]);      //273
      array[1] = 100;
      console.log(array[1]);	    //100
      
      for(let i=0; i<5; i++){
      console.log(array[i]);}    // 273 100 103 57 52
  </script>
  ```

- for(초기식; 조건식; 종결식 ) /횟수제한 

  ```javascript
  let value =0;
  let startTime = new Date().getTime();
  for(var CPS =0; new Date().getTime() < startTime+1000; CPS++){}
  alert("초당 연산 횟수" + CPS);
  ```

- for in 

- do--while

- while 

  - while (true)  --> 무한 루트 
  - break; or false 
  - new --> 새로운 객체 Date() --> 생성자

  ```javascript
  let value =0;
  let startTime = new Date().getTime();
  while(new Date().getTime() < startTime+1000){ value++;}
  alert(value);
  ```

- continue