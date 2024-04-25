- [1. 클래스 정의하는 방법](#1-클래스-정의하는-방법)
- [2. 객체 만드는 방법 (new 키워드 이해하기)](#2-객체-만드는-방법-new-키워드-이해하기)
  - [2.1. 키워드 유무 차이](#21-키워드-유무-차이)
- [3. 메소드 정의하는 방법](#3-메소드-정의하는-방법)
- [4. 생성자 정의하는 방법](#4-생성자-정의하는-방법)
  - [4.1. Method Overloading](#41-method-overloading)
- [5. this 키워드 이해하기](#5-this-키워드-이해하기)

# 1. [클래스 정의하는 방법](https://danmilife.tistory.com/19)
클래스의 기본 틀은 다음과 같다.
```java
접근제어자 class ClassName {
    // 변수
    // static이면 클래스 변수
    // non-static이면 인스턴스 변수
    접근제어자 type1 name1;
    접근제어자 type2 name2;
    ...

    // 생성자
    접근제어자 ClassName { }
    ...

    // 메소드
    접근제어자 반환형 methodName() { }
}
```

두 개의 정수로 사칙연산을 하는 클래스를 만들어보자.
```java
// default 접근 제한
class FourCalculator {
    private int x1, x2;

    // FourCalculator() { }
    // default 접근 제한
    // 같은 패키지 내에서만
    FourCalculator(int a, int b) {
        this.x1 = a;
        this.x2 = b;
    }

    int add() { return this.x1 + this.x2; }

    int sub() { return this.x1 - this.x2; }

    int mul() { return this.x1 * this.x2; }

    int div() { return this.x1 / this.x2; }

    // getter, setter...
}

public class FourCal {
    public static void main(String args[]) { ... }
}
```
# 2. 객체 만드는 방법 (new 키워드 이해하기)
## 2.1. [키워드 유무 차이](https://yoo11052.tistory.com/52)
```java
public class KeyWord {
    public static void main(String args[]) {
        String str1 = new String("string");
        String str2 = new String("string");

        String str3 = "string";
        String str4 = "string";

        System.out.println(System.identityHashCode(str1)); // 1933863327
        System.out.println(System.identityHashCode(str2)); // 112810359
        System.out.println(System.identityHashCode(str3)); // 932697283
        System.out.println(System.identityHashCode(str4)); // 932697283
    }
}
```

위와 같이 `Literal` (대개 Primitive Type)과 `Object` (Reference Type)의 차이를 알아볼 수 있는 코드를 짜보았다. `new`를 이용하여 `instatiation`을 하면 인스턴스가 되어 `Heap`에 저장된다. 따라서 매번 할당해주기 때문에 메모리 주소값이 그때 그때 달라진다.

---
Q: 어? `String`은 무조건 `Reference Type` 아닌가요?

A: 아닙니다. 원래 `Literal`은 대개 `Primitive Type`을 지칭하는 경우가 많으나, `""`로 묶인 문자열 또한 `immutable`, 즉 변경 불가능한 값으로 보고 `Literal`을 지원한다. 따라서 `new`를 사용하지 않은 `String`은 `Literal`이다.

# 3. 메소드 정의하는 방법
위의 사칙연산 예시처럼 인자를 정해줘도 되지만, 아래처럼 여러 인자를 받아도 된다.
```java
class Methods {
    private int lastResult;

    public int sum(int... args) {
        int result = 0;
        for (int arg : args) {
            result += arg;
        }
        lastResult = result;
        return result;
    }

    // getter, setter...
    public int getLastResult() { return lastResult; }
}

public class MethodTest {
    public static void main(String args[]) { ... }
}
```
# 4. 생성자 정의하는 방법
생성자는 클래스를 정의하고나서 이를 객체로 만들 때 실행된다. 즉, 인스턴스를 만들 때 실행된다는 뜻이다. 다음과 같은 코드를 예시로 들 수 있다.
```java
class FourCalculator {
    private int x1, x2;

    FourCalculator(int a, int b) {
        this.x1 = a;
        this.x2 = b;
    }

    // four calc. methods

    // getter, setter...
}

public class FourCal {
    public static void main(String args[]) { ... }
}
```
사실 위에서 사용한 예시에서 생성자를 사용했다.

## 4.1. Method Overloading
다음은 `Method Overloading`을 사용한 예시를 보자.
```java
class FourCalculator {
    private int x1, x2;

    FourCalculator(int a, int b) {
        this.x1 = a;
        this.x2 = b;
    }

    FourCalculator(int a) {
        this.(a, 1);
    }

    FourCalculator() {
        this.(1, 1);
    }

    // four calc. methods

    // getter, setter...
}

public class FourCal {
    public static void main(String args[]) { ... }
}
```
위와 같이 메소드 오버로딩을 사용하여 생성자를 여러개 선언할 수 있다. 
# 5. this 키워드 이해하기
생성자 오버로딩을 통해 this.도 사용하고, this()도 사용했다. this가 뭐길래 이렇게 사용하는 걸까?

this는 인스턴스 본인이다. 클래스를 통해서 인스턴스를 생성하고나서 해당 인스턴스의 멤버 변수나 메소드를 불러오기 위해 class에 this로 정의한다.

2주차 학습 내용에서 6.2.2 항목을 보면 `super vs. super()` 내용이 있다. this는 super와 동일한 문법을 갖는다.

this
- 본인의 메모리를 가르키기 때문에 인스턴스 본인과 같다.
- 인스턴스의 멤버 변수에 접근하기 위해 사용

this()
- 인스턴스의 다른 생성자를 호출하기 위해 사용