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

  ```
  public class IDFormatException extends Exception {
      public  IDFormatException(String message){
          super(message);
      }
  }
  ```

- IDFormatTest

  ```
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


