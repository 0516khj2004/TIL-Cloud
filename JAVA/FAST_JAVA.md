# JAVA 기초 

### 1. 변수 

- 변하는 수 
- 변수에 맞는 자료형과 변수 이름으로 선언 

- 변수를 선언하는 것은 해당 자료형의 크기 만큼의 메모리를 사용하겠다는 것 
- 메모리 위치를 변수 이름으로 참조 
- 변수 이름 
  - 숫자 시작 x
  - _ or $ 만 사용가능 
  - 예약어 사용할 수 없음 

### 2. 자료형 

- 기본형 - 메모리의 크기가 정해져 있음

  - 정수형

    - byte - 1byte

    - short - 2byte

    - int  - 4byte

    - long -8byte   

      long IVal = 12345678900L;  // 4byte가 넘어가면 L 식별자 명시적으로 표시  

  - 문자형

    인코딩 - 각 문자에 따른 특정한 숫자 값을 부여

    디코딩 - 숫자 값을 원래 문자로 표현 

    - char

  - 실수형

    - float - 4byte

      F 식별자

    - double -8byte

  - 논리형

    - boolean

- 참조형 - 클래스 자료형 , JDK or 만든 클래스 

### 3. 상수와 리터럴

- 상수 : 변하지 않는 수 
- 리터널 : 프로그램에서 사용하는 모든 숫자, 값 ,논리 값 / 상수 풀에 저장됨
- 형변환
  - 묵시적 형 변환 : 
  - 명시적 형 변환 : 역방향으로 타입케스팅  - 자료의 손실이 발생

### 4. 연산자

- 대입연산자 = 

- 부호연산자

  - 단항 연산자 : -연산자는 부호가 바뀐다

- 산수 연산자 

- 복합대입연산자

- 증가, 감소 연산자 

  - val == ++num;   // 증가된 값이 들어간다 
  - val == num++;   // 기존 변수를 대입후 증가 1이 들어간다.

- 관계 연산자(비교연산자)

- 논리연산자

  - 논리곱 && : 둘다 참인 경우 참
  - 논리 합|| : 둘 중 하나만 참인 경우 참
  - ! : 참->거짓 

- 조건 연산자

  int num = (5>3)?10:20  // 참이면 10 거짓이면 20 대입 

- 비트 연산자 - 속도가 빠르다(비트단위)

### 5. 제어문

- 조건문

  - if
  - if -else  --- 조건 연산자로 구현 가능함 
  - if -else if -else 
  - 성적에 따라 학점 부여 하기 > 점수를 입력 받아서 학점을 출력 하세요

  ```java
  Scanner scanner = new Scanner(system.in)
  int scor= scanner.netInt();
  char grade;
  if(score >=90 ){ grade="A";}
  else if(score >=80){grade='B';}
  else if(score >=70){grade='C';}
  else if(score >=60){grade='D';}
  else {grade ='F';}
  system.out.printIn("점수:" + score);
  system.out.printIn("학점:" + grade);
  ```

  - switch-case  - 각 월에 따른 한달 날짜 수를 출력하라

  ```java
  Scanner scanner = new Scanner(System.in);
  int month = scanner.nextInt();
  int day;
  
  switch(day){
      case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
  		day =31;
  		break;
  	case 2:
  		day =28;
  		braek;
      case 4: case 6: case 11:
          day =31;
          break;
  }
  system.out.println(month+"달은 " + day +"일입니다");
  
  ```

  

  