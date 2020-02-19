# JAVA



### 0. 시작하기 전에

- 임베디드, 웹 ,안드로이드 소프트웨어 개발 분야 
- 객체지향 프로그래밍 (function() -> method )
- 모든 운영체제에서 실행 =>  WORA
- 메모리 자동 정리 => GC 
- 자바 개발 도구 => JDK (javac 포함)
  - SE
  - EE  - 기업용 
- 자바 실행 도구 => JRE ( javac 미포함 )
- 대소문자 구분 (파일이름과 class명과 같아야한다)
- ; 로 끝나야 한다



### 1. 컴파일 

- javac -> .class나온다 (Bytecode 파일) 
  - 컴파일 오류 => 대소문자, ; , 확인
- java -> 
  - Run 오류 
- jvm

### 2. 프로그램 소스 분석

- 패키지 선언  - 폴더명 
  - package test1
- 클래스 선언  - 객체지향 언어 
  - public class Hello{ }   
  - 일반적으로 클래스 이름은 대문자
- 메소드 선언  - 함수
  - public static void main
  - 일반적으로 메소드 이름은 소문자
- 주석
  - //
  - documentation 주석

### 3. 변수 와 타입 

- String.format()

  - String str = "" +3 -> 문자형으로 변경 

- float a = 3.14 -> 오류 : 실수는 기본이 double형이다 

  - double a = 3.14;
  - float a = 3.14f;
  - float a = (float) 3.14 -> 큰 사이즈의 작은 사이즈로 변경하는 것 이기 때문에 데이터 손실이 있다 . 

- 형 변환 

  - 자동 타입  변환 
    - byte < short < int < long < float < double
  - 강제 타입 변환 (casing)
  - 명시적 타입 변환  
    - parseInt ();
    - parseDouble ()

- 입력 

  - Scanner s = new Scanner(System.in) // enter하기 전의 모든 데이터를 가져 온다 .

- 출력 

  - 문자열 => %s
  - 숫자 => %d 

- 문자열 데이터 비교 

  - equals( )

- System.in.read()

- object 

  - collection
    - list 
      - Arraylist 

- 시간

  - ```
    currentTimeMillis();
    ```

  - ```
    nanoTime() //
    ```

- 문자열 조합

  - ```
    StringBuilder  //속도가 빠르다 $$
    ```

### 4. String

> psvm - 틀 생성

- ```
  String name1 = "구현진";
  String name2 = "구현진";
  
  // stack 주소가 같다
  ```

- ```
  String newName1 = new String("구현진");
  String newName2 = new String("구현진");
  
  //stack 주소가 다르다 
  ```

-  주소값이 같은지 == 

- 해당 값이 같은지 name.equals(newName1)

### 5.배열 

> 한 번 생성된 배열은 길이를 늘리거나 줄일 수 있음
>
> int [] intarray = { }
>
> int [] intarray = new int[30 ] 

- 다차원 배열 