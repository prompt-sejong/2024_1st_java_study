목차
- [자바 상속의 특징](#자바-상속의-특징)
- [super 키워드](#super-키워드)
- [메소드 오버라이딩](#메소드-오버라이딩)
- [다이나믹 메소드 디스패치 (Dynamic Method Dispatch)](#다이나믹-메소드-디스패치-dynamic-method-dispatch)
  - [Dynamic method dispatch](#dynamic-method-dispatch)
  - [Double dispatch](#double-dispatch)
- [추상 클래스](#추상-클래스)
  - [abstract method](#abstract-method)
  - [abstract class](#abstract-class)
- [final 키워드](#final-키워드)
  - [Variable](#variable)
  - [Method](#method)
  - [Class](#class)
- [Object 클래스](#object-클래스)
  - [java.lang Package](#javalang-package)
  - [java.lang.Object Class](#javalangobject-class)

# 자바 상속의 특징
상속은 사실 이전에도 언급만 없었지 다뤄왔다. 2주 차에 타입 캐스팅을 설명하며 상속을 다뤘다. 그래도 설명을 해보자.
```java
class Parent { }

class Child extends Parent { ... }
```
위와 같이 extends 키워드만 사용하면 상속이 끝난다.

클래스를 상속시키면 child class는 parent class가 가진 것을 사용할 수 있다. `private`로 선언된 것을 제외하곤 전부 사용할 수 있다. 다음 super를 다루는 내용에서 이어서 설명하겠다.

# super 키워드
이전 주차에서 this 키워드에 대해 공부했다. super 또한 this와 비슷하다.

클래스 상속을 받으면 부모 클래스에 접근해야 할 때가 생길 것이다. 그때 사용하는 것이 super 키워드이다.

super
- 부모 클래스의 멤버 변수나 메소드에 접근하기 위해 사용

super()
- 클래스의 부모 생성자를 호출하기 위해 사용

# 메소드 오버라이딩
메소드 오버라이딩은 이전 주차에서 생성자를 통해 학습했었다. 상속에서의 메소드 오버라이딩은 조금 결이 다르다. 이 또한 2주 차 학습 내용에서 다룬 적이 있다. 

이번엔 기본 뼈대부터 살펴보자.
``` java
class Parent {
    public void info() {
        System.out.println("Parent입니다");
    }
}

class Child1 extends Parent {
    @Override
    public void info() {
        System.out.println("Child1입니다");
    }
}

class Child2 extends Parent {
    @Override
    public void info() {
        System.out.println("Child2입니다.");
    }
}

class MyMethods {
    public void printInfo(Parent parent) {
        parent.info();
    }
    // do something
}

public class CastingTest2 {
    public static void main(String[] args) {
        MyMethods methods = new MyMethods();
        Parent parent = new Child2();
        // Parent(상위 클래스) 타입에 Child2(하위 클래스)로 업 캐스팅
        methods.printInfo(parent);
    }
}
```
이런 식으로 코드를 짤 수 있다. 아래 자세한 [예시](https://ittrue.tistory.com/132)를 보자.

```java
class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

class Americano extends Coffee {
    public Americano() {
        super(4000); // 상위 메서드 생성자 호출
    }
    // Object 클래스 toString() 메서드 오버라이딩
    public String toString() { 
        return "아메리카노";
    }
}

class CaffeLatte extends Coffee {
    public CaffeLatte() {
        super(5000);
    }
    // Object 클래스 toString() 메서드 오버라이딩
    public String toString() {
        return "카페라떼";
    }
}

class Customer {
    int money = 50000;

    // 커피 구매 메서드(다형성 활용)
    void buyCoffee(Coffee coffee) {
        if (money < coffee.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        money -= coffee.price;
        System.out.println(coffee + "를 구매하였습니다.");
    }

    void getMoney() {
        System.out.printf("잔액: %d원\n", money);
    }
}

public class BuyCoffee {
    public static void main(String[] args) {
        Customer m1nu = new Customer();
        Coffee coffee = new CaffeLatte();
        // Parent(상위 클래스) 타입에 Child2(하위 클래스)로 업 캐스팅

        m1nu.buyCoffee(coffee); // 카페라떼를 구매하였습니다.
        m1nu.getMoney();        // 잔액: 45000원

        // subclass를 가리키는 superclass 참조변수를 만들 필요는 X
        m1nu.buyCoffee(new Americano());    // 아메리카노를 구매하였습니다.
        m1nu.getMoney();                    // 잔액: 41000원

        coffee = new Americano();   // method overriding
        m1nu.buyCoffee(coffee);     // 아메리카노를 구매하였습니다.
        m1nu.getMoney();            // 잔액: 37000원
    }
}
```

# 다이나믹 메소드 디스패치 ([Dynamic Method Dispatch](https://www.educative.io/answers/what-is-dynamic-method-dispatch-in-java))
## Dynamic method dispatch
`Dynamic Method Dispatch`는 재정의된 메소드에 대한 호출이 `compile-time`이 아니라 `run-time`에 이루어지는 것이다. 이것이 가능한 이유는 `superclass reference variable`은  `subclass object`를 참조할 수 있기 때문이다. 이를 위 예시에서 쉽게 설명해 보자.
1. 변수 `latte`는 `Coffee`라는 `superclass` 참조 변수이다.
2. 이 변수가 가리키는 것은 `CaffeLatte`라는 `subclass` 객체이다.
3. 따라서 해당 문법이 `run-time`에서 재정의된 메소드를 호출할 수 있는 것이다.

## [Double dispatch](https://velog.io/@maigumi/Dynamic-Method-Dispatch)
일단 [예시](https://velog.io/@iamtaehoon/y3uuyvw5)부터 보자.
```java
import java.util.ArrayList;
import java.util.List;

interface Espresso {
    public void extractingMethods(Extraction ex);
    public void extractingMethods(EnglandExtraction ex);
    public void extractingMethods(AustriaExtraction ex);
    public void extractingMethods(AmericanExtraction ex);
}

class M1nuEspresso implements Espresso {
    @Override
    public void extractingMethods(Extraction ex) {
        System.out.printf("기본 추출 방식");
    }

    @Override
    public void extractingMethods(EnglandExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 40g");
        System.out.println("추출 완료: 영국식");
        System.out.println("Investigated by m1nu");
    }

    @Override
    public void extractingMethods(AustriaExtraction ex) {
        System.out.println("도징: 20g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 45g");
        System.out.println("추출 완료: 호주식");
        System.out.println("Investigated by m1nu");
    }

    @Override
    public void extractingMethods(AmericanExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 27s");
        System.out.println("추출양: 38g");
        System.out.println("추출 완료: 미국식");
        System.out.println("Investigated by m1nu");
    }
}

class Num1Espresso implements Espresso {
    @Override
    public void extractingMethods(Extraction ex) {
        System.out.printf("기본 추출 방식");
    }

    @Override
    public void extractingMethods(EnglandExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 26s");
        System.out.println("추출양: 34g");
        System.out.println("추출 완료: 영국식");
        System.out.println("Investigated by num1");
    }

    @Override
    public void extractingMethods(AustriaExtraction ex) {
        System.out.println("도징: 23g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 25g");
        System.out.println("추출 완료: 호주식");
        System.out.println("Investigated by num1");
    }

    @Override
    public void extractingMethods(AmericanExtraction ex) {
        System.out.println("도징: 21g");
        System.out.println("추출시간: 25s");
        System.out.println("추출양: 32g");
        System.out.println("추출 완료: 미국식");
        System.out.println("Investigated by num1");
    }
}

interface Extraction {
    // 추상 메서드 추가
    public void extraction(Espresso espresso);
}

class EnglandExtraction implements Extraction {
    @Override
    public void extraction(Espresso espresso) {
        espresso.extractingMethods(this);
    }
}

class AustriaExtraction implements Extraction {
    @Override
    public void extraction(Espresso espresso) {
        espresso.extractingMethods(this);
    }
}

class AmericanExtraction implements Extraction {
    @Override
    public void extraction(Espresso espresso) {
        espresso.extractingMethods(this);
    }
}

public class ExtractionTest {
    public static void main(String[] args) {
        // 미누와 누미의 추출법
        Espresso m1nu = new M1nuEspresso();
        Espresso num1 = new Num1Espresso();

        // 에스프레소 종류
        List<Extraction> espressoTypes = new ArrayList<>();
        espressoTypes.add(new EnglandExtraction());
        espressoTypes.add(new AustriaExtraction());
        espressoTypes.add(new AmericanExtraction());

        // 미누가 조사한 방식대로 추출
        for (Extraction espressoType : espressoTypes) {
            espressoType.extraction(m1nu);
            System.out.println();
        }

        // 누미가 조사한 방식대로 추출
        for (Extraction espressoType : espressoTypes) {
            espressoType.extraction(num1);
            System.out.println();
        }
    }
}
```
위와 같은 방식은 Visitor 디자인 패턴에서 사용되는 방식이다. 자바는 패키지 구성을 어떻게 하는지 궁금하여 src 파일에 구현해 놓았다.

# [추상 클래스](https://www.tcpschool.com/java/java_polymorphism_abstract)
## abstract method
추상 메소드는 자식 클래스에서 반드시 오버라이딩 해야만 사용할 수 있는 메소드를 의미한다. 따라서 선언만 되어있고, 구현은 되어있지 않다.

```java
abstract returnType FuncName();
```
위와 같이 일반적인 함수 선언처럼 하되, 앞에 `abstract` 키워드를 붙이면 된다.

## abstract class
하나 이상의 추상 메소드를 포함하는 클래스를 추상 클래스라고 한다. 추상 클래스를 상속받는 모든 클래스는 추상 메소드를 반드시 재정의해야 한다.

```java
abstract class ClassName {
    ...
    abstract returnType FuncName();
    ...
}
```
위처럼 구현할 수 있다.

그럼 메소드에만 `abstract`를 붙이지 클래스에도 `abstract` 키워드를 붙이느냐고 할 수 있다. 클래스에 abstract를 붙이는 이유는 단순하다. 추상 메소드가 있으니 `subclass`에 상속하고, 추상 메소드를 재정의한 뒤에 `subclass`를 통해 인스턴스를 생성하라는 의미이다. 즉, 추상 클래스는 인스턴스를 생성할 수 없다.

# [final 키워드](https://sabarada.tistory.com/148)
`final` 키워드는 변수, 메소드, 클래스에 사용될 수 있다.
## Variable
`Primitive Type` 변수에 `final` 키워드를 붙이면 `stack`에 있는 메모리를 변조할 수 없기 때문에, 메모리 주소와 값이 고정된다.

`Reference Type` 변수에 `final` 키워드를 붙이면 마찬가지로 `stack`에 있는 메모리를 변조할 수 없기 때문에, 변수의 메모리 주소와 변수가 가리키는 힙 메모리 주소가 바뀌지 않는다. 힙의 값은 `final`이 제한하는 범위 외부이므로 바뀔 수 있다.

예시는 아래와 같다.
```java
final int myInt = 1;
final String myString = "Hello World!";
```

Static만 주의해서 사용하면 된다. (초기화 시 final로 인해 고정)

## Method
메소드에 `final`을 붙이면 `override`를 제한하게 된다.

## Class
클래스에 `final`을 붙이면 상속을 제한하게 된다.

`final`을 사용하는 클래스의 대표적인 예시로는 `Wrapper Class`가 있다.

# [Object 클래스](https://www.tcpschool.com/java/java_api_object)
## java.lang Package
java.lang 패키지는 자바에서 가장 기본적인 동작을 수행하는 클래스들의 집합이다. 따라서 자바에서는 import를 하지 않아도 클래스 이름만으로 바로 사용할 수 있도록 하고 있다.

## java.lang.Object Class
Object 클래스는 모든 자바 클래스의 최고 조상 클래스가 된다.
따라서 자바의 모든 클래스는 Object 클래스의 모든 메소드를 바로 사용할 수 있다.

Object 클래스는 필드<sub>(클래스에 포함된 변수)</sub>를 가지지 않으며, 총 11개의 메소드만으로 구성되어 있다.

|메소드|설명|
|-|-|
|protected Object clone()           | 해당 객체의 복제본을 생성하여 반환함.|
|boolean equals(Object obj)         | 해당 객체와 전달받은 객체가 같은지 여부를 반환함.|
|protected void finalize()          | 해당 객체를 더는 아무도 참조하지 않아 가비지 컬렉터가 객체의 리소스를 정리하기 위해 호출함.|
|Class<T> getClass()                | 해당 객체의 클래스 타입을 반환함.|
|int hashCode()	                    | 해당 객체의 해시 코드값을 반환함.|
|void notify()	                    | 해당 객체의 대기(wait)하고 있는 하나의 스레드를 다시 실행할 때 호출함.|
|void notifyAll()	                | 해당 객체의 대기(wait)하고 있는 모든 스레드를 다시 실행할 때 호출함.|
|String toString()	                | 해당 객체의 정보를 문자열로 반환함.|
|void wait()	                    | 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.|
|void wait(long timeout)	        | 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지날 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.|
|void wait(long timeout, int nanos)	| 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행하거나 전달받은 시간이 지나거나 다른 스레드가 현재 스레드를 인터럽트(interrupt) 할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출함.|