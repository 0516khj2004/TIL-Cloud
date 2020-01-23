# JavaScript -2 

### 5. 함수 : 코드의 집합을 나타내는 자료형 

- 익명함수 

  let add = function() { }                -- add변수처럼 사용 

  ```html
   <script>
   let func = function(a) {
  	 let output = prompt(a + "님, 숫자를 입력하세여");
  	 alert(output);
   };
   func("koo");
   </script>
  ```

- 선언적 함수

  ```javascript
  function func2(name){
  alert("hello " + name) };
  func2("koo");
  ```

- 매개변수와 리턴 값 

  ```javascript
  function func2(name){
      return "hello" + name;
  };
  let result = func2("koo");
  ```

- Array함수 

  ```javascript
  let myarray1 = ["a","b","c"]; //고정배열
  let myarray2 = new Array();// 가정배열
  
  myarray2[0] = "g";
  myarray2[1] = "f";
  myarray2[2] = "l";
  
  console.log(myarray1);
  console.log(myarray2);
  ```

- 타이머 함수 

  - setInterval( ) - 함수를 반복해서
  - setTimeout( ) - 일정 시간후 종료

  ```
  setTimeout(function(){ alert('test'); },3000);
  ```

- 코드 실행 함수

  - eval(string) --> string을 자바스크립트 코드로 실행

  ```
  let willEval ="";
  willEval += 'var number =10;';
  willEval += 'console.log(number);';
  
  eval(willEval);               // 10
  ```

- 숫자 확인 함수

  - isFinite( )   --> number가 무한한 값인지 확인
  - isNaN()  --> number가 NaN인지 확인

  ```
  let a = parseInt('123');
  let b = parseIoat("3.14");
  
  console.log(typeof a);
  console.log(typeof b);
  
  let won = "1000원";
  let doller = "1.5$";
  
  console.log(won + "/"+ doller);
  ```

- 화살표 함수

  ```
  let func = () => {
  console.log("hello");
  }
  ----------------------
  let func = function() {
  console.log("hello");
  }
  ```

  