# Chapter 07~Chapter 10

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

