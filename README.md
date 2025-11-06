# 이자목(202530122)




# (11월 6일 강의)

# (테크 페어 사진)
![테크페어_사진](img/takpar.jpg)
왼쪽 부터
이자목, 박시현(10번), 선우혁, 송서윤, 권기범, 이상민

# PR(Pull Request)
- 남의 저장소의 내용을 내가 가져와서 업데이트한 뒤에
  '이 부분 제가 이렇게 바꿨는데, 제가 작업한 부분도 적용해 주세요!'라는 요청을 보내는 것이다.

# 패키지의 개념과 필요성
 - 여럿이서 개발을하는 경우 동일한 이름의 클래스가 존재할 가능성이있음
 - 이름이 같아도 경로가 다르면 서로 다른 파일로 취급

## 패키지 (package)
- 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 **디렉터리**
- 하나의 응용프로그램은 한 개 이상의 **패키지**로 작성
- 패키지는 `.jar` 파일로 압축할 수 있음

## 모듈 (module)
- 여러 **패키지**와 **이미지 등의 자원**을 모아 놓은 **컨테이너**
- 하나의 모듈을 하나의 `.jmod` 파일에 저장

## 자바의 모듈화의 목적

### 모듈화의 목적
- **Java 9**부터 자바 API를 여러 **모듈(99개)**로 분할  
  → **Java 8**까지는 `rt.jar`의 한 파일에 모든 API 저장  
  → 현재 **70개**로 정리됨
- 응용프로그램이 실행할 때 **꼭 필요한 모듈들만 실행 환경 구축**  
  → 메모리 자원이 열악한 **작은 소형 기기**에 꼭 필요한 모듈로 구성된  
  **작은 크기의 실행 이미지**를 만들기 위함


## 자바 API의 모듈 파일들

- 자바 JDK에 제공되는 **모듈 파일들**
  - 자바가 설치된 `jmods` 디렉터리에 모듈 파일 존재
  - `.jmod` 확장자를 가진 파일
  - 모듈은 수십 개 존재하며, **ZIP 포맷으로 압축된 파일**  
    → 포맷이 `zip`이며, **확장자는 `.jmod`** 입니다.

- 모듈 파일에는 자바 API의 **패키지와 클래스**들이 들어 있음

- `jmod` 명령을 이용하여 **모듈 파일에 들어 있는 패키지**를 풀어낼 수 있음

## 패키지 사용하기, import문

### 다른 패키지에 작성된 클래스 사용
- `import`를 이용하지 않는 경우  
  → 소스에 클래스 이름의 **완전 경로명** 사용

```java
public class ImportExample {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
  }
}
```
### 필요한 클래스만 import
        - 소스 시작 부분에 클래스의 경로명 import
        - `import 패키지.클래스`
        - 소스에는 클래스 명만 명시하면 됨  

```java
import java.util.Scanner;

public class ImportExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
  }
}
```


# (10월 31일 강의)

## 인터페이스의 구성 요소들의 특징
* **상수** : 

-public만 허용,

-public static final 생략


* **추상 메소드** :

  -public abstract 생략 가능


* **default 메소드** :

  -인터페이스에 코드가 작성된 메소드

  -인터페이스를 구현하는 클래스에 자동 상속

  -public 접근 지점만 허용. 생략 가능


* private 메소드 :

  -인터페이스 내에 메소드 코드가 작성되어야 함

  -인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능


* static 메소드 : public, private 모두 지정 가능. 생략하면 public

## 자바 인터페이스 특징
<font color = "orange"></font>
* 인터페이스의 객체 생성 불가
* 인터페이스 타입의 `레퍼런스 변수 선언 가능`

## 인터페이스 상속
* 인터페이스 간에 상속 가능 :

  -인터페이스를 상속하여 확장된 인터페이스 작성 가능

  -extends 키워드로 상속 선언

* 인터페이스 다중 상속 허용 (* 일반 상속에서는 허용하지 않음)

## 인터페이스 구현
* 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
  * implements 키워드 사용
  * 여러 개의 인터페이스 동시 구현 가능
* 인터페이스 구현 사례
  * PhoneInterface 인터페이스를 구현한 SamsungPhone 클래스



## 추상 클래스
* 추상 메소드(abstract method)

  :abstract로 선언된 메소드, `메소드의 코드는 없고 원형만 선언`
```java
abstract public String getName();
abstract public String fail() { return "Good Bye".} // 추상 메소드 아님. 컴파일 오류
```

* 추상 클래스(abstract class)

  -추상 메소드를 가지며, abstract로 선언된 클래스

  -추상 메소드 없이, abstract로 선언한 클래스

```java
// 추상 메소드를 가진 추상 클래스
abstract class Shape {
    public Shape() {...}
    public void edit() {...}
    
    abstract public void draw(); // 추상 메소드
}
```
```java
// 추상 메소드 없는 추상 클래스
abstract class JComponent {
    String name;
    public void load(String name) {
        this.name = name;
    }
}
```

## 추상 클래스의 인스턴스 생성 불가
* 추상 클래스는 온전한 클래스가 아니기 때문에 `인스턴스를 생성할 수 없음`

```java
JComponent p; // 오류 없음. 추상 클래스의 레퍼런스 선언
p = new JComponent(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
Shape obj = new Shape(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
```

## 추상 클래스의 상속과 구현
* 추상 클래스 상속
  * 추상 클래스를 상속받으면 추상 클래스가 됨
  * 서브 클래스도 abstract로 선언해야 함
```java
abstract class A { // 추상 클래스
    abstract public int add(int x, int y); // 추상 메소드
}
abstract class B extends A { // 추상 클래스
    public void show() { System.out.println("B");}
}
```
```java
A a = new A(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
B b = new B(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
```
* 추상 클래스 구현
  * 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현 (오버라이딩)
  * 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님
```java
class C extends A { // 추상 클래스 구현. C는 정상 클래스
    public int add(int x, int y) { return x+y} // 추상 메소드 구현. 오버라이딩
    public void show() { System.out.println("C"); }
}
...
C c = new C(); // 정상
```

## 추상 클래스의 목적
* 추상 클래스의 목적

  -상속을 위한 슈퍼 클래스로 활용하는 것

  -서브 클래스에서 추상 메소드 구현

  -다형성 실현

##


## super 키워드로 슈퍼 클래스에 접근
- 슈퍼 클래스의 멤버에 접근시 사용하는 레퍼런스
- super.슈퍼클래스의 맴버
- 서브 클래스에서만 사용
- 슈퍼 클래스의 필드 접근
- 슈퍼 클래스의 메소드 호출시 super로 이루어지는 메소드 호출 : 정적 바인딩

## 메소드 오버라이딩(Method Overriding)의 개념
* 서브 클래스에서 슈퍼 클래스의 메소드 중복 작성
* 슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨
* 메소드 무시하기로 번역되기도 함

* **오버라이딩 조건**
  > 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성

## 서브 클래스 객체와 오버라이딩된 메소드 호출
* 오버라이딩 한 메소드가 실행됨을 보장
```java
clas A {
    void f() {
        System.out.println("A의 f() 호출");
    }
} 
class B extends A {
    void f() {
        System.out.println("B의 f() 호출");
    }
}
```

## 오버라이딩의 목적, 다형성 실현
* 오버라이딩으로 다형성 실현
* 하나의 인터페이스(다른 이름)에 서로 다른 구현
* 슈퍼 클래스의 메소드를 서브 클래스에서 `각각 목적에 맞게 다르게 구현`
* 사례 : shape의 draw() 메소드를 Line, Rect Circle에서 오버라이딩하여 다르게 구현

## instanceof 연산자 사용
* 레퍼런스가 가리키는 객체의 타입 식별 : 연산의 결과는 true/false의 불린 값으로 반환

`객체레퍼런스 instanccof 클래스 타입`

```java
Person p = new Professor();

if(p instanceof Person) // true
if(p instanceof Student) // false, Student를 상속받지 않음
if(p instanceof Researcher) // true
if(p instanceof Professor) // true
```
```java
if("java" instanceof String) // true
```

# (10월 30일 강의)
 
## super 키워드로 슈퍼 클래스에 접근
- 슈퍼 클래스의 멤버에 접근시 사용하는 레퍼런스
- super.슈퍼클래스의 맴버
- 서브 클래스에서만 사용
- 슈퍼 클래스의 필드 접근
- 슈퍼 클래스의 메소드 호출시 super로 이루어지는 메소드 호출 : 정적 바인딩

## 추상 클래스의 상속과 구현
- 추상 클래스를 상속받으면 추상 클래스가 됨
-  서브 클래스도 abstract로 선언해야 함

## 추상 클래스 구현
- 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현

## 추상 클래스의 목적
- 상속을 위한 슈퍼 클래스로 활용
- 서브 클래스로 추상 메소드 구현
- 다형성 실현

## 추상 클래스의 구현
```java
abstract class Calculator {
public abstract int add(int a, int b);
public abstract int subtract(int a, int b);
public abstract double average(int[] a);
}

```
위 코드를 받아서 구현할때 사용

## 자바 인터 페이스
- **소프트웨어를 규격화된 모듈로 만들고**, **인터페이스가 맞는 모듈을 조립하듯이 응용프로그램을 작성하기 위해서 사용.**

---

### 자바의 인터페이스
- 클래스가 구현해야 할 **메소드들이 선언되는 추상형**
- 인터페이스 선언 : `interface` 키워드로 선언  
  Ex) `public interface SerialDriver { … }`

---

### 자바 인터페이스에 대한 변화
- **Java 7까지** : 인터페이스는 **상수와 추상 메소드로만 구성**
- **Java 8부터**  
  → 상수와 추상 메소드 포함  
  → `default` 메소드 포함 (Java 8)  
  → `private` 메소드 포함 (Java 9)  
  → `static` 메소드 포함 (Java 9)

---

### 여전히 인터페이스에는 필드(멤버 변수) 선언 불가

## 인터페이스의 구성 요소들의 특징
<h1> 이거 봐 된다니까</h1>

### [ 인터페이스의 구성 요소들 ]

- **상수**
  - `public`만 허용
  - `public static final` 생략 가능

- **추상 메소드**
  - `public abstract` 생략 가능

- **default 메소드**
  - 인터페이스에 코드가 작성된 메소드
  - 인터페이스를 구현하는 클래스에 자동 상속
  - `public` 접근 지정만 허용, 생략 가능

- **private 메소드**
  - 인터페이스 내에 메소드 코드가 작성되어야 함
  - 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능

- **static 메소드**
  - `public`, `private` 모두 지정 가능
  - 생략 시 `public`


# 자바 상속과 업캐스팅 (Upcasting) 개념 정리

이 문서는 자바에서의 **상속**과 **업캐스팅(Upcasting)** 개념을 설명하며, 해당 개념을 실습하는 코드 예시와 함께 설명합니다.

## 클래스와 메소드

- **final 클래스**: 더 이상 클래스 상속 불가능
- **final 메소드**: 더 이상 오버라이딩 불가능

### final 필드

- **final 필드**: 상수를 선언할 때 사용
    - 상수 필드는 선언 시에 초기 값을 지정해야 하며, 실행 중에 값을 변경할 수 없습니다.

### 메소드 제약 조건 1

- **static 메소드**: 오직 static 맴버만 접근 가능
    - 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 맴버 활용 불가

### 메소드 제약 조건 2

- **static 메소드**: `this` 사용 불가
    - static 메소드는 객체 없이도 사용 가능하므로 `this` 레퍼런스를 사용할 수 없습니다.

## 클래스 상속과 객체

- **상속 선언**: `extends` 키워드 사용
- 부모 클래스 -> **슈퍼 클래스**, 자식 클래스 -> **서브 클래스**
- 서브 클래스는 슈퍼 클래스를 확장하고, 부모 클래스에 선언된 필드와 메소드를 상속받습니다.

## 상속의 필요성

- 상속을 사용하면 중복된 멤버를 제거하고, 클래스 구조를 간결하게 할 수 있습니다.

## 서브 클래스 객체의 모양

- 서브 클래스 객체는 슈퍼 클래스의 맴버를 포함합니다.

## 자바 상속의 특징

- **클래스 다중 상속 불허**: 하나의 클래스가 둘 이상의 부모 클래스를 동시에 상속받을 수 없습니다.
- **C++와의 비교**:
    - C++는 다중 상속이 가능하지만, 맴버가 중복 생성되는 문제(다이아몬드 상속 문제)가 발생할 수 있습니다.
    - 자바는 인터페이스의 다중 상속을 허용합니다.
- **모든 자바 클래스는 `java.lang.Object`를 묵시적으로 상속받음**.

## 슈퍼 클래스의 맴버에 대한 서브 클래스의 접근

- **private** 맴버: 서브 클래스에서 접근할 수 없습니다.
- **디폴트** 맴버: 서브 클래스가 동일한 패키지에 있을 경우, 접근 가능합니다.
- **public** 맴버: 서브 클래스에서 항상 접근할 수 있습니다.

## 서브 클래스/슈퍼 클래스의 생성자 호출과 실행

- 서브 클래스 객체가 생성될 때, 슈퍼 클래스 생성자와 서브 클래스 생성자가 모두 실행됩니다.
- **호출 순서**: 서브 클래스 생성자 먼저 호출 -> 슈퍼 클래스 생성자 호출
- **실행 순서**: 슈퍼 클래스 생성자가 먼저 실행 -> 서브 클래스 생성자 실행

### 서브 클래스와 슈퍼 클래스의 생성자 선택

1. **개발자의 명시적 선택**: 서브 클래스 개발자가 `super()`로 슈퍼 클래스의 생성자를 직접 선택
2. **컴파일러의 기본 선택**: 서브 클래스 개발자가 슈퍼 클래스 생성자를 명시하지 않으면, 컴파일러가 자동으로 기본 생성자를 선택

## 컴파일러에 의해 슈퍼 클래스의 기본 생성자가 묵시적 선택

- 개발자가 슈퍼 클래스의 생성자를 명시하지 않으면, 컴파일러는 자동으로 슈퍼 클래스의 기본 생성자를 선택하여 실행합니다.

## 슈퍼 클래스에 기본 생성자가 없어 오류 난 경우

```java
class A {
    public A(int x) {
        System.out.println("생성자A");
    }
}
```
```java
class B extends A {
    public B() {
        System.out.println("생성자B");
    }
}
```
```java
public class ConstructorEx2 {
    public static void main(String[] args) {
        B b = new B();  // 오류 발생: A() 기본 생성자 없음
    }
}
```
# (10월 23의 강의)

## 객체
 - 객체하다 고유한 특성과 행동을 가짐
 <br>
(예시) 테트리스 블록, 한글 프로그램의 버튼<br>

## 캡슐화
- 객체들을 캡슐로싸서 내부를 볼수없게하는것
## 자바의 캡슐화 
 - 클래스(class) : 객체모양을 선언하는 틀<br>
객체: 생성된 실체 : 클래스 내에 메소드와 필드 구현

## 상속
- 상위 객체에 하위객체가 상속됨

## 다형성
- 같은 이름의 매소드가 클래스 혹은 객체마다 다르게 구현되는것

## 객체 지향의 목적
- 컴퓨터 산업의 발전으로 소프트웨어의 생명주기 단축<br>
소프트웨어들을 빠르 속도로 생산할 필요성 증대

## 객체 지향 언어
- 소프트웨어 재사용과 수정이 빠름
- 소프트웨어 생산성 향상

## 클래스
- 맴버: 클래스의 구성요소, 필드(변수),메소드(함수)
- 클래스에 대한 public: 다른 모든 클래스에서 클래스 사용허락
- 맴버에 대한 public: 다른 모든 클래스에서 맴버 사용 가능

## 



# (9월18일 강의)
## 자바의 특징
- 가비지 콜렉터(Garbage Collector, GC)
- 실기간 응용프로그램에 부적합
- 자바는 안전
- 프로그램 작성 쉬움
- 실행 속도 개선을위한 JIT 컴파일러 사용
    1. 바이드 코드를 인터프리터 방식 실행
    2. 기계어 보다 느림

## 코드
1. 소스코드
    - `.java` 코드
    - 사람이 읽을 수 있는 고수준 언어 (High-Level Languag)
2. 바이코드
    - `.class` 코드
    - Java 컴파일러(javac)가 소스코드를 변환한 중간 코드
    - `JVM`이 실행 해야함 -> cpu가 실행 X
    - JIT 컴파일러가 기계어로 변환 실행
3. 기계어
    - cpu가 직접 실행 가능 - 0과 1의 이진 코드
    - 운영체제(os)와 cpu 아키텍처(intel , arm 등)에 따라 다름
    - 16진수 형태의 기계어

## 기본 구조
주석 / 클래스 생성/  main() 메서드/ 메서드 / 메소드 호출 / 변수 선언 / 문장 ; / 출력

### 식별자

- **정의** - 클래스 , 변수, 상수, 메소드에 붙이는 이름

- 유니코드 사용 가능, 한글 사용 가능 -> 한글 사용은 좋지 않다.

- 자바의 언어 키워드는 식별자로 사용 불가

- 식별자의 첫 번째 문자로 숫자는 사용불가

- `_` , `$`를 식별자 첫번째 문자로 사용 할수는있다. 허나 일반적으로는 사용 안함

- 불릿 리터럴 `(true , false)`과 널 리터럴`(null)`은 식별자로 **사용불가**

- 길이 제한 없음

- 대소문자 구별 : `barChart` 와  `bahrchart`는 다른 식별자

## 데이터 타입
- 문자열은 기본 타입x, string 클래스로 문자열 표현

- 리터럴 : -> int a = `10` 에서 10 을 의미

- 문자열이나 문자열과 다른 자료형의 리터럴을 + 연산을 할 경우 결과는 문자열로 반환
- 객체를 참조하는 변수 유형, 힙(Heap) 영역에 저장된 객체의 메모리 주소를 가르킴
    - 기본 자료형은 스택 영역에 저장
- 객체를 참조 하지 않을 때 null 값을 가질수 있다.

- 일반적으로 `레퍼런스`라고 부른다.
## 참조 자료형 (Reference Type)
- 포인터는 임의의 메로리 주소를 저장 , 참조 자료형은 주소를 저장 X
- JVM이 해당 주소로 안내
- 객체를 참조하는 변수 휴형


## 메모리 관리
- jvm 이 관리 해준다.

## 메모리 구조

- 힙( heap - FIFO) 영역은 프로그래머가 직접 공간을 할당, 해제하는 메모리 공간, jvm이 담당
- 스택(stack - LIFO) 영역은 프로그램이 자동으로 사용하는 임시 메모리 영역
- 힙이 스택을 침범하는 경우를 힙 오버 플로우라고 한다.
    - 스택이 힙을 침범하는 경우를 스택 오버 플로우

## 상수 선언
- final 키워드 사용
- 선언할 때 초기값 지정
- 실행 중 값 변경 불가능

## var 키워드
- type을 생략하고 변수 선언
- 지역 변수에만 선언 가능 , class 필드에서는 사용할 수 없다.
    - 지역 변수 : 메소드 내부에 선언되는 변수.
    - 클래스 필드 : 클래스 내부에 선언되는 변수, 객체 생성과 함께 만들어지는 변수
- 기본적으로는 명시적 자료형을 쓰는 것이 좋다


## print
- `System.out.print();`
- `System.out.println();`
- `System.out.printf();`


## 타입 변환
- 원래 타입보다 큰 타입으로 자동 변환
- 강제 변환
## java의 키 입력
- System.in vs. Scanner
### Sysytem.in
- 키보드와 연결된 자바의 표준 입력 스트림
- 입력되는 키를 `바이트(문자 아님)로 리턴하는 저수준 스트림`
- 직접 사용하면 `바이트를 문자나 숫자로 변환하는 많은 어려움 있음`
### java.utill.Scanner
- 객체를 생성해서 사용
- 키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴
- 입력되는 키 값을 공백으로 구분되는 토큰 단위로 읽음
- 공백 문자 : `'/t' '/r' '/n' '' '/f'`(페이지 나누기, 폼 피드, 프린트 에서 사용)

## Scanner 주요 메서드
이런게 있다~

## 연산자
- 증감
    - `++` : 변수 값을 1 증가
    - `--` : 변수 값을 1 감소

- 산술
    - `+` : 더하기
    - `-` : 빼기
    - `*` : 곱하기
    - `/` : 나누기
    - `%` : 나머지

- 시프트
    - `>>` : 오른쪽 시프트 (부호 유지)
    - `<<` : 왼쪽 시프트
    - `>>>` : 오른쪽 시프트 (부호 무시, 0으로 채움)

- 비교
    - `>` : 크다
    - `<` : 작다
    - `>=` : 크거나 같다
    - `<=` : 작거나 같다
    - `==` : 같다 (값 비교)
    - `!=` : 같지 않다

- 비트
    - `&` : 비트 AND
    - `|` : 비트 OR
    - `^` : 비트 XOR
    - `~` : 비트 NOT

- 논리
    - `&&` : 논리 AND (그리고)
    - `||` : 논리 OR (또는)
    - `!` : 논리 NOT (부정)
    - `^` : 논리 XOR (배타적 OR)

- 조건
    - `? :` : 조건 연산자 (삼항 연산자)

- 대입
    - `=` : 대입
    - `*=` : 곱 후 대입
    - `/=` : 나눈 후 대입
    - `+=` : 더한 후 대입
    - `-=` : 뺀 후 대입
    - `&=` : 비트 AND 후 대입
    - `^=` : 비트 XOR 후 대입
    - `|=` : 비트 OR 후 대입
    - `<<=` : 왼쪽 시프트 후 대입
    - `>>=` : 오른쪽 시프트 후 대입
    - `>>>=` : 부호 무시 오른쪽 시프트 후 대입
***
# (9월11일 강의)
### vs cod에서 Extension Pack for Java 다운
## JDK란?
Java Development Kit의 약자로, 자바(Java) 프로그램을 개발하기 위한 소프트웨어 개발 도구 모음
자바 프로그램을 작성, 컴파일하고 디버깅하는 데 필요한 컴파일러, 디버거 등 다양한 개발 도구와 라이브러리를 포함하며, 최종 사용자가 아닌 프로그래머가 자바 애플리케이션을 개발하고 실행하기 위해 사용하는 핵심적인 도구
JDK의 종류는 OpenJDK와 Oracle JDK가있다.
Oracle JDK는 상업적으로누 유로지만 개인 용도로는 무료로 사용가능

## [절차 지향언어]
프로그램을 절차, 순서에 따라서 실행하는 방식<br>
데이터와 함수를 분리하여 작성<br>
단점: 코드의 유연성이 부족 재사용이 어려움, 전역변수를 많이 사용하기에 가독성과 유지보수성이 떨어짐
## [함수 지향언어]
함수를 입급 객체로 취급 상태변경을 피하고 불변성을 지향
함수의 조합으로 복잡한 작업을 수행

## WORA(Write once, run anywhere)
한번 작성한 코드는 OS, H/W상관없이 모든 플랫폼에서 실행되는 자바의 특징

## 바이트 코드(.class)
자바 JVM에서 실행가능한 바이너리 코드<br>
컴퓨터 cpu의 의해서 직접싱행되지 않음<br>
자바 JVM이 작동중인 플랫폼에서 실행<br>
자바 JVM이 인터프리터 방식으로 바이트코드 해석<br>
실행법: JVM + Java api


***
# (9월4일 강의)
# Markdown 문법
HTML에서 <h1> ~ <h6>

# 글자 크기
## 글자 크기
### 글자 크기
#### 글자 크기
##### 글자 크기
###### 글자 크기

문자 강조 

이텔릭체

*자바 코딩*<br><br>
**굵은 문자**

수평선
***

## 리스트
* 언오더드 리스트
  * 언오더드 리스트
    * 언오더드 리스트

1. 오더드 리스트
   1. 오더드 리스트
      1. 오더드 리스트

## 코드 블럭
```java
public class HelloWorldApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
    }
}
```
## 인라인 코드

`물결표 쪽에 있는거`

# 링크
## 외부 링크

[구글](https://www.google.com/?hl=ko "구글 주소" )

## 내부 링크
[링크 라벨](#리스트 "리스트")

# 이미지 삽입
![로고](data:image/png;base64,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 "깃")

