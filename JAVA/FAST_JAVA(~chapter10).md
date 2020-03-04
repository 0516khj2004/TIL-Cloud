# Chapter 07~Chapter 11

### 1. 상속(inheritance) (실선)

```
class B extends A {}
```

- 새로운 클래스를 정의 할 때 이미 구현된 클래스를 상속 받아서 속성이나 기능이 확장되는 클래스를 구현함 

- 상속하는 클래스

  - 상위 클래스 , **parent class**, base class, super class
  - 일반적인 개념과 기능을 가짐

- 상속받는 클래스(확장된 클래스)

  - 하위 클래스, **child class**, derived class, subclass
  - 구체적인 개념과 기능을 가짐 

- protected 예약어

  - 외부 클래스에는 private으로 하위 클래스에서는 public의 기능을 구현한 키워드
  - 상위클래스에서 protected로 선언된 변수나 메소드는 다른 외부 클래스에서는 사용할 수 없지만 하위 클래스에서는 사용 가능 

- 접급제한자 

  |           | 외부 클래스 | 하위 클래스 | 동일 클래스 | 내부 클래스 |
  | --------- | ----------- | ----------- | ----------- | ----------- |
  | public    | O           | O           | O           | O           |
  | protected | X           | O           | O           | O           |
  | default   | X           | X           | O           | O           |
  | private   | X           | X           | X           | O           |

- super()

  - super()로 호출되는 생성자는 상위 클래스의 기본 생성자

- 상위클래스로의 묵시적 형 변환 **(업캐스팅)**

  - 하위 클래스는 상위클래스의 타입을 내포하고 있으므로 상위 클래스로 묵시적 형변환이 가능 함 
  - Customer vc = new VIPCustomer()
  - vc는 customer 것만 사용가능 - 타입이 Customer이기 때문

- 하위 클래스로 명시적 형 변환 **(다운 캐스팅)** - instanceof

  - 묵시적으로 상위 클래스 형변환된 인스턴스가 원래 자료형(하위 클래스)으로 변환되어야 할 때 
  - VIPCustomer vCustomer = (VIPCustomer) vc

### 2. 메서드 오버라이딩(overriding)

- 오버라이딩
  - 상위 클래스에 정의된 메서드의 구현 내용이 하위 클래스에서 구현할 내용과 맞지 않는 경우 하위 클래스에서 동일한 이름의 메서드를 재정의 할 수 있다.
- 가상 메서드 
  - 메서드의 이름과 메서드 주소를 가진 가상 메서드 테이블에서 호출될 메서드의 주소를 참조함 
  - 재정의 되면 메서드 주소가 바뀜 
  - Customer vc = new VIPCustomer() 에서 vc.calcPrice는 재정의된 VIPCustomer가 호출된다

### 3. 다형성 (ploymorphism)

- 다형성
  - 하나의 코드가 여러 자료형으로 구현되어 실행되는 것 
  - 같은 코드에서 여러 실행 결과가 나옴 
  - 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나 
  - 객체지향 프로그래밍의 우연성, 재활용성, 유지보수성에 기본이 되는 특징임 

### 4. 추상 클래스

- 추상메서드 

  - 구현 코드가 없이 선언부만 있는 메서드 

  - abstract 예약어 사용 

  - new할 수 없음 

    ```
    Computer computer = new DeskTop()  // o
    Computer computer = new Computer() // x 
    ```

  - 상위클래스에서 구현하고 하위 클래스에서 사용한다.

- 추상 클래스 

  - 하위클래스가 abstract가 되거나 
  - / 추상 메서드를 다 오버라이드 해야한다

- 추상 클래스 응용 - 템플릿 메서드 

  - 추상 메서드나 구현된 메서드를 활용하여 전체의 흐름(시나리오)를 정희해 놓은 매서드
  - final로 선언하여 재정의 할 수 없게 함

- final 예약어

  - 변경될수 없는 값
  - final 메서드는 하위 클래스에서 재정의 할 수 없음
  - final 클래스는 더 이상 상속되는 않음 

### 5. 인터페이스(점선)

> 클라이언트 프로그램(서비스를 받는 쪽) 에 어떤 메서드를 제공하는지 알려주는  명제 

- 인터페이스 요소

  - 추상메서드

    모든 메서드가 추상 메서드

  - 상수 (static final)

    선언되 모든 변수는 상수로 처리 됨

  - 디폴트 메서드

    기본 구현을 가지는 메서드 - 구현하는 클래스는 재정의 할 수 있음

  - 정적 메서드

    인스턴스 생성과 상관없이 인터페이스 타입으로 호출하는 메서드

    ```
    static int total(int a)
    ```

    

  - private 메서드

    인터페이스 내에서 사용하기 위해 구현한 메서드- 구현하는 클래스에서 재정의 할 수 없음

- 인터페이스 선언 (점선)

  - public **interface** Calc
  - 인터페이스는 구현 코드가 없기 때문에 타입 상속이라고도 함 

- 인터페이스를 활용한 다형성 구현 

  - 하나의 클래스가 여러 인터페이스를 **구현** 할 수 있음

  ```
  public class Customer implements Buy, Sell {}
  ```

  - 인터페이스간에도 **상속**이 가능함 - extends 뒤에 여러 인터페이스를 상속 받을 수 있음

  ```
  public interface MyInterface extends X,Y{}
  ```

  ​    X,Y라는 인터페이스를 상속받아서 MyInterface하는 인터페이스를 만든다

  - 인터페이스 구현과 클래스 상속 함께 사용

  ```
  public class BookShelf extends Shelf implements Queue {}
  ```

### 6. Object 클래스

- 모든 클래스의 최상위 클래스

- **java.lang.Object** 클래스 

- 모든 클래스는 Object 클래스의 일부 메서드를 재정의하여 사용할 수 있음 - 오버라이딩

  - toStirng() -  객체의 정보를 String으로 바꾸어 사용할 때 유용함

    ```java
    @Override
    public String toString() {
       return  author +"," +title;
    }
    ```

  - equals() - 두 객체의 동일함을 논리적으로 재정의 할 수 있음 / 물리적으로 다른 메모리에 위치한 객체라도 논리적으로 동일함을 구현하기 위해 사용하는 메서드

    ```java
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Student){
            Student std = (Student)obj;
            if (this.studentNum == studentNum)
                return true;
            else 
            	return false;
        }
        return false;
    }
    ```

    

    - ==    -  두 객체의 주소가 동일한지 묻는 것
    - equals   -  두객체의 값이 동일한지 묻는 것

  - hashCode() - 인스턴스가 저장된 가상머신의 주소(10진수)

  - System.identityHashCode() - 실제 해시코드 -주소 값

  - clone() - 객체의 복사본 / 기본 틀(prototype)으로 부터 같은 속성 값을 가진 객체의 복사본을 생성 할 수 있음  / 복제할 객체는 cloneable 인터페이스를 명시해야함 

    ```
    class Book implements Cloneable{} 
    // 복재할 객체는 상속해야한다.
    ```

  - finalize() - 리소스의 해제, 소켓 닫기 , 

### 7. String()

- 선언하기 
  - String str1 = new String("ABC"); => 인스턴스로 생성 / 힙 메모리
  - String str2 = "abc"; => 상수풀에 있는 문자열을 가리킴  
  - String str3 = "abc"; => str2 == str3  true
- 문자열 연결하는 법 
  - concat() or +
    - 새로운 문자열이 생성 되는 것 
    - 문자열을 붙일 때
    - 주소값이 다르다
  - StringBuilder - 주소값이 같다
    - 단일 쓰레드 프로그래밍에서 용이
  - StirngBuffer - 주소값이 같다
    - 가변적인 char[] 배열을 멤버변수라 가지고 있는 클래스
    - toString()메서드로 String 반환
    - StringBuffer는 멀티 쓰레드 프로그래밍에서 동기화가 보장됨 

### 8. Wrapper 클래스

| 기본형  | Wrapper 클래스 |
| ------- | -------------- |
| boolean | Boolean        |
| byte    | Byte           |
| char    | Character      |
| short   | Short          |
| int     | Integer        |
| long    | Long           |
| float   | Float          |
| double  | Double         |

### 9. 재네릭 프로그래밍

> 변수의 선언이나 메서드의 매개변수를 하나의 참조 자료형이 아닌 여러 자료형을 변환 될 수 있도록 프로그래밍하는 방식
>
> 실제 사용되는 참조 자료형으로의 변환은 컴파일러가 검증하므로 안정적은 프로그래밍 방식

- public class Gene<T>{ } -> T 자료형 매개변수 
- <T extends M> M을 상속받아서 사용

### 10. 컬렉션 프레임 워크

- 컬렉션 프레임 워크

  - 프로그램 구현에 필요한 자료구조와 알고리즘을 구현해 놓은 라이브러리 
  - java.util 패키지에 있음

- Collection 인터페이스 

  - List

    - 순서가 있는 자료 관리, 중복 허용
    - 배열의 기능을 구현하기 위한 메서드가 선언됨
    - ArrayList
    - Vector
      - **멀티 쓰레드** 프로그램에서 **동기화** 지원 
    - LinkedList

  - Set

    - 순서가 정해져 있지 않음, 중복 허용하지 않음

    - interator() 메서드 호출  - 순회

      ```java
      Iterator<String> ir = set.iterator();
      while (ir.hasNext()){
          String str = ir.next();
          System.out.println(str);
      }
      // 결과는 순선대로 나오고 / 중복은 허락 하지 않음!
      ```

    - HashSet

      ```java
      HashSet<String> set = new HashSet<String>();
      ```

    - TreeSet  

      -  객체의 정렬에 사용되는 클래스 
      - 중복을 허용하지 않으며 오름차순이나 내림차순으로 객체를 정렬 함 
      - 내부적으로 이진 검색 트리로 구현되어 있음 
      - 객체 비교를 위해 Comparable이나 Comparator 인터페이스를 구현 해야 함 
      - implements Comparable<Member> 
      - implements Comparator<Member> {}
        - TreeSEt<Member> treeSet = new TreeSet<Member>(new Member());

- Map 인터페이스 

  - **쌍**으로 이루어진 객체를 관리하는데 필요한 여러 메서드가 선언되어 있음

  - Key-value 쌍으로 되어 있고 **key는 중복될 수 없음(키는 유일)**

  - Hashtable

    - Properties

  - HashMap 

  - TreeMap -

    - key로 정렬 

      - ```
        hashMap.keySet().iterator();
        hashMap.values().iterator();
        ```

    - Comparable이나 Comparator 인터페이스를 구현 해야 함 

### 11. Stack 과 Queue

- stack

  - Last In First Out(LIFO) - 맨마지막에 추가 된 요소가 가장 먼저 꺼내지는 자료구조 
  - push() - 추가  pop() - 삭제

  ```java
  class MyStack{
      private ArrayList<String> arrayStack = new ArrayList<String>();
  
      public void push(String data){
          arrayStack.add(data);
      }
      public String pop(){
          int len = arrayStack.size();
          if(len == 0){
              System.out.println("스택이 비었습니다");
              return null;
          }
          return arrayStack.remove(len-1);
      }
      
  }
  ```

- Queue 

  - First In First Out(FIFO) - 먼저 저장된 자료가 먼저 꺼내지는 자료구조 
  - enqueue - 추가  dequeue - 삭제

### 







