# Chapter 13 ~ Chapter 15

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

    - 바이트 스트림  - 바이트 단위로 자료를 읽고 씀(동영상, 음악 파일) - 최상위 클래스 
      - FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream
      - 입력 스트림은 파일이 없는 경우 예외 발생
      - 출력 스트림은 파일이 없는 경우 파일을 생성하여 출력
    - 문자 스트림 - 문자는 2바이트씩 처리함 
      - FileReader, FileWriter, BufferedReader, BufferedWriter
      - 추상 메서드를 포함한 추상 클래스로 하위클래스가 상속받아서 구현 

  - 스트림의 종류 : 기반 스트림 , 보조 스트림 

    - 기반 스트림 - 대상에 직접 자료를 읽고 쓰는 기능의 스트림

      - FileInputStream, FileOutputStream ,FileWriter

    - 보조 스트림(데코레이터) - 직접 읽고 쓰는 기능은 없고 추가적인 기능을 제공해 주는 스트림, 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개변수를 포함함 

      - FileInputStream, FileOutputStream이 최상위 클래스임

      - InputStreamReader, OutputStreamWriter, BufferedInputStream,  BufferedOutputStream

      - InputStreamReader - 바이트 단위를 문자로 바꿔서 읽음

      - Buffered 스트림 - 내부에 8192바이트 배열을 가지고 있음, 읽거나 쓸 때 속도가 빠름

      - DataInputStream / DataOutputStream - 자료가 저장된 상태 그대로 자료형을 유지하며 읽거나 쓰는 기능을 제공하는 스트림  

      - 보조 스트림은 겹처서 사용 가능하다

        ```
        BufferedReader isr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ```

- 표준 입출력 - System 클래스의 표준 입출력 멤버

  - PrintStream out; - 표준 출력 스트림
  - InputStream in; - 표준 입력 스트림
  - PrintStream err; - 표준 에러 스트림 

- Scanner 클래스 

  - 문자뿐 아니라 정수, 실수 등 다양한 자료형을 읽을 수 있음
  - 생성자가 다양하여 여러 소스로 부터 자료를 읽을 수  있음

- Console 클래스 

  - console cmd 창에서 사용함

### 4. 직렬화(Serialization)

> 인스턴스의 상태를 그래도 저장하거나 네트웍으로 전송하고 이를 다시 복원하는 방식
>
> 프로그래머가 객체의 직렬화 가능 여부를 명시화 
>
> implements Serializable => 직렬화하겠다는 의도를 표시 

- 보조스트림 사용
  - ObjectInputStream	
  - ObjectOutputStream

- 직렬화

  - implements Serializable => 직렬화하겠다는 의도를 표시 
  - transient => 직렬화하지 않겠다는 의도 표시 
  - implements Externalizable => 직접 구현할수 있다

### 5. 그 외 입출력 클래스와 데코레이터 패턴

- File 클래스
  - 파일 개념을 추상화한 클래스 
  - 입출력 기능은 없고 파일의 속성, 경로, 이름 등을 알 수 있음
- RandomAccessFile 클래스
  - 입출력 클래스 중 유일하게 파일 입출력을 동시에 할 수 있는 클래스 
  - 파일 포인터가 있어서 읽고 쓰는 위치의 이동이 가능함
  - 다양한 자료형에 대한 메소드 제공 
- 데코레이터 패턴
  - 자바의 입출력 스트림은 데코레이터 패턴을 사용
  - 실제 입출력 기능을 가진 객체와 그 외 다양한 기능을 제공하는 데코레이터을 사용하여 다양한 입출력 기능을 구현
  - 상속보다 유연한 확장성을 가짐
  - 지속적인 서비스의 증가와 제거가 용이함 

### 6. Thread

- Process

  - 실행중인 프로그램
  - OS로부터 메모리를 할당 받음

- Thread

  - 실제 프로그램이 수행되는 작업의 최소 단위
  - 하나의 프로세스는 하나 이상의 Thread를 가지게 된다 

- Thread 구현하기 

  - extends Thread => 하나받게 상속받지 못함

    ```java
    class MyThread extends Thread{
        public void run(){
            int i;
            for (i=0; i<=200 ;i++ ){
                System.out.print(i +"\t");
    
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public class ThreadTest {
        public static void main(String[] args) {
    
            System.out.println("start");
            MyThread th1 =new MyThread();
            MyThread th2 =new MyThread();
    
            th1.start();
            th2.start();
    
            System.out.println("end");
    
        }
    }
    ```

    Thread class에 sleep()가 있어서 바로 사용 가능 

  - implements Runnable => Runnable인터페이스 구현

    이미 다른 클래스를 상속받는 경우 Thread는 상속받지 못하기 때문에 Runnable을 구현해야한다.

    ```
    class MyThread implements Runnable{
        public void run(){
            int i;
            for (i=0; i<=200 ;i++ ){
                System.out.print(i +"\t");
    
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public class ThreadTest {
        public static void main(String[] args) {
    
            System.out.println("start");
            MyThread  runner1 =new MyThread();
            MyThread runner2 =new MyThread();
    
           Thread th1 = new Thread(runner1);
           Thread th2 = new Thread(runner2);
    
           th1.start();
           th2.start();
    
            System.out.println("end");
    
        }
    }
    ```

- 메서드의 활용

  - ![](C:\Users\0516k\TIL\images\thread.PNG)
  - join() 메서드
    - 다른 thread의 결과를 보고 진행해야 하는 일이 있는 경우 join()메서드를 활용 
    - join메서드를 호출한 thread가 non-runnable 상태가 되어야 함 
  - interrupt() 메서드
    - 다른 thread에 예외를 발생시키는 interrupt를 보냄
    - thread가 join(), sleep(), wait() 메서드에 의해 블럭킹 되었다면 interrupt에 의해 다시 runnable 상태가 될 수 있음 

### 7. Multi-Thread 

- 동시에 여러개의 thread가 수행되는 프로그래밍

- thread는 각각의 작업공간(context)를 가짐

- critical section에 대한 동기화의 구현이 필요 -순서가 필요

- 임계영역(critical section)

  - 두개 이상의 thread가 동시에 접근하게 되는 리소스
  - critical section에 동시에 thread가 접근하게 되면 실행결과 보장 안됨
  - thread간의 순서를 맞추는 동기화 가 필요

- 동기화(synchronization)

  - 임계영역에 여러 thread가 접근 하는 경우 한 thead가 수행 하는 공안 공유 자원을 lock하려 다른 thread의 접근 막음

  - 동기화를 잘못 구현하면 deadlock에 빠질수 있음'

  - 동기화 구현

    - synchronization 수행문

      - ```
        synchronized(this)
        ```

    - synchronization 메서드

      - ```
        public synchronized void saveMoney(this save)
        ```

- wait()

  - 리소스가 더 이상 유효하지 않은 경우 리소스가 사용 가능할 때까지 위해 thread를 non-runnable상태로 전환
  - wait() 상태가 된 thread은 notify()가 호출 될 때까지 기다린다.

- notify() 

  - wait() 하고 있는 thread 중 한 thread를 runnable한 상태로 깨움
  - 하지만 랜덤으로 깨움
  - if 문 사용

- notifyAll()

  - wait() 하고 있는 모든 thread가 runnable한 상태가 되도록 함 
  - notify() 보다 notifyAll()을 사용하기를 권장
  - 튿정 thread가 통지를 받도록 제어 할 수 없으므로 모두 깨운 후 scheduler에 cpu를 점유하는 것이 좀 더 공평함 
  - while 문 사용

