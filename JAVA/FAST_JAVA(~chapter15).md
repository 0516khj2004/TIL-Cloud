# Chapter 13~Chapter 

### 1. 예외와 예외처리

> 자바는 예회처리를 통해서 프로그램의 비정상적인 오류를 막고 log를 남길 수 있음

- 컴파일 오류 - 프로그램 코드 작성 중 발생하는 문법적인 오류
- 실행 오류 - 실행 중인 프로그램이 의도하지 않은 동작을 하거나 (bug) 프로그래이 중지 되는 오류
- 시스템 오류 error - 가상머신에서 발생, 프로그래머가 처리 할 수 없음
- 예외 exception - 프로그램에서 제어 할 수 있는 오류 
- Exception 클래스 

  - 입출력 예외 처리(IOException)
  - 실행 오류 예외 처리 (RuntimeException)
- try{ 예외가 발생 할 수 있는 코드 부분 } catch(처리할 예외 타임 e) { try 블록 안에서 예외가 발생했을 때 수행되는 부분 }
- try{ 예외가 발생 할 수 있는 코드 부분 } catch(처리할 예외 타임 e) { try 블록 안에서 예외가 발생했을 때 수행되는 부분 } finally{ 예외 발생 여부와 상관 없이 항상 수행 되는 부분 }
- catch((ArrayIndexOutOfBoundsException e)
- implements AutoCloseable

### 2. 사용자 정의 예외

- 예외처리 미루기

  - throws 
  - 메서드를 호출하는 곳에서 하겠다는 것 

- 다중 처리 예외

- IDFormatException

  ```java
  public class IDFormatException extends Exception {
      public  IDFormatException(String message){
          super(message);
      }
  }
  ```

- IDFormatTest

  ```java
  public class IDFormatTest {
      private  String userID;
  
      public String getUserID() {
          return userID;
      }
  
      public void setUserID(String userID) throws IDFormatException {
          if(userID == null){
              throw new IDFormatException("아이디는 null 일수 없습니다");
          }
          else if (userID.length() < 8 || userID.length() > 20 ){
              throw  new IDFormatException("아이디는 8자 이하, 20자 이상일수 없습니다");
          }
          this.userID = userID;
      }
      public static void main(String[] args) {
          IDFormatTest idtest = new IDFormatTest();
  
          String myid = null;
          try {
              idtest.setUserID(myid);
          } catch (IDFormatException e) {
              System.out.println(e);
          }
          myid="123456";
          try{
              idtest.setUserID(myid);
          } catch (IDFormatException e) {
              System.out.println(e);
          }
      }
  }
  ```

### 3. 자바 입출력 스트림

- 입출력 스트림 
  - 다양한 입출력 장치에 독립적으로 일관성 있는 입출력 방식 제공
  - 입출력이 구현되는 곳에서 모두 I/O 스트림을 사용
- 입출력 스트림 구분
  -  I/O 대상 기준 :  입력 스트림, 출력 스트림
    - 입력 스트림 -  대상으로부터 자료를 읽어 들이는 스트림
      - FileInputStream, FileReader, BufferedInputStream, BufferedReader
    - 출력 스트림 - 대상으로 자료를 출력하는 스트림 
      - FileOutputStream, FileWriter, BufferedInputStream, BufferedWriter
  - 자료의 종류 : 바이트 스트림, 문자 스트림
    - 바이트 스트림  - 바이트 단위로 자료를 읽고 씀(동영상, 음악 파일)
      - FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream
    - 문자 스트림 - 문자는 2바이트씩 처리함 
      - FileReader, FileWriter, BufferedReader, BufferedWriter
  - 스트림의 종류 : 기반 스트림 , 보조 스트림 
    - 기반 스트림 - 대상에 직접 자료를 읽고 쓰는 기능의 스트림
      - FileInputStream, FileOutputStream ,FileWriter
    - 보조 스트림 - 직접 읽고 쓰는 기능은 없고 추가적인 기능을 제공해 주는 스트림, 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개변수를 포함함 
      - InputStreamReader, OutputStreamWriter, BufferedInputStream,  BufferedOutputStream
- 표준 입출력 - System 클래스의 표준 입출력 멤버
  - PrintStream out; - 표준 출력 스트림
  - InputStream in; - 표준 입력 스트림
  - PrintStream err; - 표준 에러 스트림 
- Scanner 클래스 
  - 문자뿐 아니라 정수, 실수 등 다양한 자료형을 읽을 수 있음
  - 생성자가 다양하여 여러 소스로 부터 자료를 읽을 수  있음
- Console 클래스 
  - console cmd 창에서 사용함

