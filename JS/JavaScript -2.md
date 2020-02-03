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

- 콜백함수 - > 익명함수를 매개변수에 곧바로 넣은 함수 

  ```
  function callNTime(n, callback){
      for(let i=0; i< n; i++){
      callback();
      }
  }
  
  callNTime(4,function(){
  	alert("출력합니다");
  });
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

  - setInterval( ) - 함수를 반복해서 -> clearInterval() 타이머 제거
  - setTimeout( ) - 일정 시간후 종료 ->clearTimeout() 타이머 제거

  ```javascript
  setTimeout(function(){ alert('test'); },3000);
  ```

- 코드 실행 함수

  - eval(string) --> string을 자바스크립트 코드로 실행

  ```javascript
  let willEval ="";
  willEval += 'var number =10;';
  willEval += 'console.log(number);';
  
  eval(willEval);               // 10
  ```

- 숫자 확인 함수

  - isFinite( )   --> number가 무한한 값인지 확인 - 셀수있으면 true 
  - isNaN()  --> number가 NaN인지 확인

  ```javascript
  let a = parseInt('123');
  let b = parseFIoat("3.14");
  
  console.log(typeof a);
  console.log(typeof b);
  
  let won = "1000원";
  let doller = "1.5$";
  
  console.log(won + "/"+ doller);
  ```

- 화살표 함수

  ```javascript
  let func = () => {
  console.log("hello");
  }
  ----------------------
  let func = function() {
  console.log("hello");
  }
  ```

  

### 6. 객체

> 자료형 - > 불필요한 데이터 낭비를 방지하기 위해서 
>
> 숫자, 문자열 , 불 ,함수 , undefined 
>
> 배열은 자료형이 아니다 -> 배열은 객체다 /  배열은 요소에 인덱스로 접근, 객체는 요소에 키로 접근 

- 객체  - JSON 파일의 형태 

  - 키 : '속성'  == 인덱스 : 요소 (배열) 

- 메서드 - **동작**을 나타내는 함수 

  - 메서드 호출 -> person.eat() -> 객체.메서드 
  - this 키워드 -> 자기 자신이 가진 속성을 나타낼 때

  ```javascript
   let person = {                  // person = 객체 
       name: '구현진',              // name = 속성
       address: '서울',            // address = 속성
       eat: function(food){		// eat = 속성 , 메서드 
       console.log(this.name +"은 " + food + "을 먹었습니다");
       }     						//this = 자기 자신이 가진 속성을 나타낼 때 
   };
  
  console.log(person.name);			
  person.eat("사과");                // 메서드 호출 
  ```

- with 키워드 

  ```javascript
  let student = {};
  student.name = "구현진";
  student.kor = 100;
  student.mat = 90;
  student.eng = 80;
  
  let sum =0;
  let avg =0;
  
  //sum = student.kor + student.mat + student.eng;
  //avg = sum /3 ;
  
  with(student){
  sum = kor + mat +eng;
  avg = sum/3;
  }
  console.log("총점:" + sum);
  console.log("평균:" + avg);
  
  ```

- 반복문 

  ```javascript
  let students = [];
  students.push({이름: 'aaa', 국어 :90, 수학:30 ,영어:70});
  students.push({이름: 'bbb', 국어 :80, 수학:40 ,영어:60});
  students.push({이름: 'ccc', 국어 :70, 수학:50 ,영어:50});
  students.push({이름: 'ddd', 국어 :60, 수학:60 ,영어:40});
  students.push({이름: 'eee', 국어 :50, 수학:70 ,영어:30});
  
  
  for(let i in students){
      //students[i].sum = students[i].국어 + students[i].수학 +students[i].국어+ students[i].영어 ; 
      //students[i].avg = students[i].sum /3;
  
      students[i].sum = function(){
      return this.국어 + this.영어+ this.수학;
      }
      students[i].avg = function(){
      return this.sum() /3 ;
      }
  }
  
  let totalsum = 0;
  let totalavg =0;
  
  for(let i in students){
      with(students[i]){
      console.log(이름 + "/" +sum() + "/" + avg());
      totalsum += sum();
      }
  }
  
  console.log("전체평균:" + +(totalsum/ students.length/3));
  ```

### 7. 생성자 함수 (내장 함수)

> 객체를 생성할 때 사용하는 함수

- new 키워드 -> new 뒤에 있는 함수가 생성자 함수 / 객체를 생성하는 키워드 / 

  - 생성자 이름 -> 일반적으로 대문자로 시작함 

- 배열

  ```javascript
  function Students(name, kor, mat, eng){
      this.이름 = name;
      this.국어 = kor;
      this.수학 = mat;
      this.영어 = eng;
  
      this.sum = function(){
      return this.국어 + this.영어 + this.수학;
      };
  
      this.avg = function(){
      return this.sum() / 3;
      };
  }
  
  let students = [];
  students.push(new Students('aaa',80,40,60));
  students.push(new Students('bbb',70,50,40));
  students.push(new Students('ccc',60,40,50));
  students.push(new Students('ddd',20,40,90));
  students.push(new Students('eee',10,30,20));
  
  let totalsum = 0;
  
  for(let i in students){
      with(students[i]){
      console.log(이름 + "/" +sum() + "/" + avg());
      totalsum += sum();
      }
  }
  console.log("전체평균:" + +(totalsum/ students.length/3));
  ```

- 캡슐화 

  - 게터 : get을 붙여 만든 메서드 - 값을 가져오는 행위  
  - 세터 : set 을 붙어 만든 메서드 - 값을 넣는 행위

### 8. 기본 내장 객체

- 추가 함수 

  ```javascript
  let primtiviNumber = 273; // 속성, 메서드 추가 X
  let objectNumber = new Number(273); // 속성, 메서드 추가 가능
  Number.prototype.method = function(){
  	return " method on prototupe";                   // 내장함수에 메서드 추가
  };
  
  console.log("primitive:" + primtiviNumber);
  console.log("object:" + objectNumber + "/"+ objectNumber.method());
  ```

- **Object** 객체의 메서드

  - 생성방법

    - let myObject1 = new Object(); // 처음부터 가지고 만드는 방법
    - let myObject2 = {}; //동적 추가

  - 7가지의 내장 메서드가 있다 

    - toString() - > 객체를 문자열로 바꾼다  

      ->  기본console.log(myObject1.toString());  -> `결과 [object Object]`

      -> 오버라이딩(함수의 내용을 재정의함 )

      ```javascript
      let student = {
          name:"구현진",
          grade:'1학년',
          toString: function(){
          return this.name + "/" + this.grade; // toString 재정의 
          }
      }
      
      console.log("Student:" + student);     // 결과 Student:구현진/1학년
      ```

- **Number**객체의 메서드 

  - object객체가 가진 7가지 메서드를 포함해 3가지 메서드 추가로 가진다
  - MAX_VALUE

- **String** 객체의 메서드

  - 생성방법

    - let srt2 = new Strinf("Hello world!");
    - let str1 = "Hello world!";

  - length 속성 

    - console.log(str1.length)  --> 속성이기 때문에 () 사용하지 않는다/ 문자열의 길이
    - charAt -> 위치하는 문자를 리턴
    - concat -> 문자열 결합 
    - indexOf -> 앞에서부터 가지고 있는 문자열에사 원하는 문자의 위치를 리턴 
    - lastIndexOf -> 뒤에사부터 가지고 있는 문자열의 원라는 문자의 위치를 리턴
    - split -> 가지고 있는 문자열에서 특정 문자로 잘라서 배열에 리턴한다
    - substr -> 시작부터 카운트만큼 문자열을 잘라서 리턴
    - substring - > 시작부터 끝까지 문자열을 잘라서 리턴 

    ```
    let str1 = "Hello World!";
    
    console.log(str1.length);             // 12
    console.log(str1.charAt(4));          // o
    console.log(str1 = str1.concat("Hi THere")); // Hello World!Hi THere 변경값이 str1에 대입 
    console.log(str1.indexOf("World"));   // 6
    console.log(str1.lastIndexOf("World"));// 6
    
    
    let ipaddress = "192.22.21.33";
    let value = ipaddress.split(".");
    
    console.log(typeof value);     // object
    console.log(value); 		   // ["192","22","21","33"]
    console.log(value[0]);			// 192
    console.log(ipaddress.substr(0,3));	// 192
    console.log(ipaddress.substring(4,6));	// 22
    ```

- **Array** 객체 

  > ​	여러가지 자료를 쉽게 관리할 수 있게 도와주는 객체

  - length 속성 = 배열의 요소가 몇개 인가 

    - concat()

    - pop() -> 마지막 데이터 값을 가져온다 - 데이터는 삭제됨

      ```
      let total = students.length
          for ( let i=0 ; i<total; i++){
          console.log(students.pop());
      }
      ```

    - push() -> 마지막 부분에 새로운 요소 추가 

    - sort() -> 배열을 정리할때

      ```
      students.sort(function(left, right){
      	return right.sum() - left.sum();
      });                     // 내림차순 (left - right)순서 바꾸면 오름차순
      ```

      

    - splice() -> 부분 삭제

- **Date**객체

  > 현재 시간 출력

  let now = new Date()

- **Math**객체

  - abc()
  - ceil()
  - floor()
  - pow()
  - round()
  - random()
  - pow(x,y) -> x 제곱 y 
  - max()
  - min()

- ECMAScript 5 **Array**객체

  - forEach() -> 배열 각각의 요소를 사용해 특정 함수를 for in반복문처럼 실행

    ```javascript
     let array = [ 50,200,242,516,5,314,325,602,426,818];
     array.forEach(function(element){
     	console.log(element);
     });
    ```

  - map() -> 기존의 배열에 특정 규칙을 적용해 새로운 배열을 만든다

    ```
    let newMAp = array.map(function(element){
    	return element *10;
    });
    ```

  - filter() - > 특정 조건을 만족하는 요소를 추출해 새로운 배열을 만든다

    ```
    let rank = [90,52,45,23,12,74,88,55]
    rank = rank.filter(function(element, index, array){
    	return element >=60; 
    })
    ```

  - reduce() or reduceRight()

- ECMAScript 5 **Json**객체

  - JSON.parse() -> JSON문자열을 자바스크립트 객체로 뱐환합니다.

    ```
    let openapi= `{
    	"weather": [
    		{
    		"main": "clear"
    		}
    	],
    	"main": {
    		"temp":281.52
    	}
    }`
    let parsedJson = JSON.parse(openapi);
    console.log("현재온도:"+ parsedJson.main.temp);
    console.log("현재날씨:" + parsedJson.weather[0].main);
    ```

  - JSON.stringify() -> 자바스크립트 객체를 JSON문자열로 반환합니다.

### 9. 브라우저 객체 모델 

> 모든 객체는 속성과 메서드를 가지고 있다.

- window 객체 

  - alert() - > 경고 상자

  - prompt() -> 

  - open() -> 새로운 윈도우 창 열기 

    ```
    window.open("http://www.naver.com","mynaver","width=600, height=400",true);
    // 사이즈를 명시하지 않으면 같은 크기의 브라우저가 열린다 
    ```

    ```
    이벤트 속성 이용 - onclick
    <script>
    	 function myOpen(url){ window.open(url)}
    </script>
    
    <body><ul>
    <li><a onclick="myOpen('http://www.naver.com')">naver</a></li>
    <li><button onclick="myOpen('https://www.google.co.kr')">google</button></li>
    </ul></body>
    ```

  - onload 이벤트 속성 -> 화면에 데이터가 읽어올때 발생하는 이벤트 

    > on으로 시작하는 속성을 이벤트 속성이라고 한다.

    ```
    <script>
        console.log('Process - 0');
        window.onload = function(){
        console.log('Process - 3');
        }
    </script>
    </head>
    <body>
        <h1>Process - 1</h1>
        <script>console.log("Process - 1");</script>
        <h1>Process - 2</h1>
        <script>console.log("Process - 2");</script>
    </body>
    
    ----------------결과값-----------------------
    Process - 0       
    Process - 1
    Process - 2
    Process - 3        //onload는 가장 마지막에 실행
    ```

     

- location 객체 - 주소값으로 이동 

  -  href -> location.href="https://www.multicampus.com"

- navigator 객체 -> 반응형 웹을 구현할 때 사용 

  

