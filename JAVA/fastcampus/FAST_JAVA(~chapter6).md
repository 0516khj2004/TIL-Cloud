# 객체지향 프로그래밍 

### 1. 객체 

- 객체 -> 구체적 , 추상적 데이터 단위
- 클래스 -> 객체를 코드를 구현한 것 
  - public class는 하나만 존재해야 하고 , 파일 이름이랑 같아야한다.
- 멤버 변수 -> 객체가 가지는 속성을 변수로 표현 
- 매서드 -> 객체의 기능을 구현 / 함수 

- 객체지향 프로그래밍OOP ->객체를 기반으로 하는 프로그래밍 
  - java
- 절차 지향 프로그래밍 -> 시간이나 사건의 흐름에 따라 프로그래밍 
  - C

### 2. 함수

-  함수 
  - 하나의 기능을 수행하는 일련의 코드
  - 함수는 호출하여 사용하고 기능이 수행된 후 값을 반환 할 수 있음
  - 함수로 구현된 기능은 여러 곳에서 호출되어 사용- 재사용
  - 함수에 따라 매개변수가 없을 수도 ,반환 겂이 없을 수도 있다
- public static void hello ( String s){ System.out.print(s);}
  - void -> 반환값 return값이 없음 

### 3. 메소드

- 메소드
  - 객체의 기능을 구현하기 위해 클래스 내부에 구현되는 함수 
  - 메소드를 구현함으로써 객체의 기능이 구현 됨
- Static -> 지역 변수 

### 4. 인스턴스

- 인스턴스 
  - 클래스로부터 생성된 객체
  - 클래스가 메모리에 생성된 상태
  - 힘 메모리에 멤버 변수의 크기에 따라 메모리 생성
  - 클래스를 기반으로 new 키워드를 이용하여 여러 개의 인스터스 생성 
- New
  - new 했을 때 힙메모리에 멤버 변수가 생긴다 

### 5. 생성자 / 생성자 오버로딩 

- 생성자 
  - 객체를 생성할때 new 키워드와 함께 호출
  - 인스터스를 초기화하는 코드가 구현 됨
  - 반환 값이 없음 / 상속되지 않음
  - 생성자는 클래스 이름과 동일 
- default 생성자
  - 프로그래머가 생성자를 구현하지 않으면 자바 컴파일러가 자동으로 생성자 코드를 ㄴ넣어줌 
  - 매개변수가 없고, 구현부가 없음 (body에 내용이 없음)
- 생성자 오버로딩 
  - 생성자를 두 개 이상 구현하는 경우
  - 사용하는 코드에서 여러 생성자 중 선택하여 사용할 수 있음 
  - private 변수도 생성자를 이용하여 초기화 할 수 있음

### 6. 참조 자료형

- String, Date , Student 등 ,,,

### 7. 정보은닉

- public 
- private
- protected
- default

- this 
  - 자신의 메모리를 가리킴
  - 생성자에서 다른 생성자를 호출 함
  - 인스턴스 자신의 주소를 반환



### 8. static 변수

- static 
  - 처음 프로그램이 로드 될 때 데이터 영역에 생성 됨 
  - 인스턴스의 생성과 상관없이 사용할 수 있으므로 클래스 이름으로 참조 
  - 클래스변수, 정적 변수라고 함 
  - static변수에서는 인스턴스 변수를 사용할 수 없음 
  - 클래스이름으로 참조해서 사용하는 메서드

| 변수유형             | 선언위치                                    | 사용범위                                                     | 메모리      | 생성과 소멸                                                  |
| -------------------- | ------------------------------------------- | ------------------------------------------------------------ | ----------- | ------------------------------------------------------------ |
| 지역변수(로컬)       | 함수 내부에 선언                            | 함수 내부에서만 사용                                         | 스택        | 함수가 호출될 때 생성되고 함수가 끝나면 소멸함               |
| 멤버 변수(인스턴스 ) | 클래스 멤버 변수로 선언                     | 클래스 내부에서 사용하고 private가 아니면 참조 변수로 다른 클래스에서 사용 가능 | 힙          | 인스턴스가 생성될때 힙에 생성되고, 가비지 컬렉터가 메모리를 수거할때 소멸됨 |
| static 변수(클래스)  | static 예약어를 사용하여 클래스 내부에 선언 | 클래스 내부에서 사용하고 private가 아니면 클래스 이름으로 다른 클래스에서 사용 가능 | 데이터 영역 | 프로그램이 처음 시작할 때 상수와 함께 데이터 영역에 생성되고 프로그램이 끝나고 메모리를 해제할 때 소멸됨 |

- singleton Pattern - 단 하나만 존재하는 인스턴스 

  - 생성자는 private으로 static으로 유일한 객체 생성
  - 외부에서 유일한 객체를 참조할 수 있는 public static get()메서드 구현
```java
public class Company {
    private static Company instance = new Company();
    private Company(){}

    public static Company getInstance(){
        if(instance == null){
            instance = new Company();
        }
        return  instance;
    }
}

public class CompanyTest {
    public static void main(String[] args) {
        Company company = Company.getInstance();
        Company company2 = Company.getInstance();

        System.out.println(company);
        System.out.println(company2);

        Calendar calendar = Calendar.getInstance();
    }
}

```

### 9. 배열

- 배열이란?

  - 동일한 자료형의 순차적 자료 구조
  - 물리적인 위치와 논리적인 위치가 같다
  - 연속된 자료 구조 -> 중간에 비워두면 안된다. 
  - int[] arr = new int[10];          ==       int arr[] = new int[10];

- 객체 배열 

  - null 값이 들어감 - 객체의 주소가 들어감

  ```
  Book[] library = new Book[5] 
  for(int i=0; i<library.length; i++){
  	System.out.println(librart[i])
  }
  // 출력 -> 5개의 주소값이 출력됨
  ```

- 배열 복사 

  - System.arraycopy(arr1, 0, arr2, 1,3);

    arr1배열의 0번째부터 복사해서 arr2배열의 1번째 자리부터 3길이만 복사

  - 객체 복사 

    - 얕은 복사

      - ```
        System.arraycopy(library,0,copyLibrary,0,5);
        ```

      - 두개의 배열이 같은 주소를 가진다

      - 하나의 배열의 값을 바꾸면 다른 배열도 달라진다.

    - 깊은 복사 

      - ```
        copyLibrary[0] = new Book();
        copyLibrary[1] = new Book();
        copyLibrary[2] = new Book();
        copyLibrary[3] = new Book();
        copyLibrary[4] = new Book();
        
        for(int i=0; i<library.length; i++){
            copyLibrary[i].setAuthor(library[i].getAuthor());
            copyLibrary[i].setTitle(library[i].getTitle());
        }
        ```

      - 두개의 배열이 다른 주소를 가진다

- 다차원 배열 (2차원 이상의 배열)

  - int `[ ][ ]` arr = new int `[2][3]`
  - arr.lengrh => 2       //행의 개수 
  - arr[1] .length => 3
  - 행의 기준으로 열을 돌린다

### 10. ArrayList 

- 자바에서 제공되는 객체 배열이 구현된 클래스 

- 객체 배열을 사용하는데 필요한 여러 메서드들이구현되어 있음

- | 메서즈              | 설명                                              |
  | ------------------- | ------------------------------------------------- |
  | boolean add(E e)    | 요소 하나를 배열에 추가, E는 요소의 자료형을 의미 |
  | int size()          | 배열에 추가된 요소 전체 개수 반환                 |
  | E get(int index)    | 배열의 index 위치에 있는 요소 값을 반환           |
  | E remove(int index) | 배열의 index위치에 있는 요소 값을 제거하고, 반환  |
  | boolean isEmpty()   | 배열이 비어있는지 확인                            |

  

