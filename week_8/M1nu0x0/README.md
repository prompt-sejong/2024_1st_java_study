목차
- [1. 인터페이스 정의하는 방법](#1-인터페이스-정의하는-방법)
- [2. 인터페이스 구현하는 방법](#2-인터페이스-구현하는-방법)
- [3. 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법](#3-인터페이스-레퍼런스를-통해-구현체를-사용하는-방법)
- [4. 인터페이스 상속](#4-인터페이스-상속)
- [5. 인터페이스의 기본 메소드 (Default Method), 자바 8](#5-인터페이스의-기본-메소드-default-method-자바-8)
- [6. 인터페이스의 static 메소드, 자바 8](#6-인터페이스의-static-메소드-자바-8)
- [7. 인터페이스의 private 메소드, 자바 9](#7-인터페이스의-private-메소드-자바-9)

# 1. 인터페이스 정의하는 방법
자바는 다중 상속을 지원하지 않는다. 하지만 다중 상속의 이점을 그냥 버릴 순 없어서, 인터페이스를 통해 다중 상속을 지원한다.

인터페이스란, 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스이다.

인퍼테이스는 클래스와 다르게 일반 메소드나 변수를 가질 수 없으며 오로지 추상 메소드와 상수만을 포함할 수 있다.

```java
접근 제어자 interface 이름 {
    public static final type name = value;
    ...
    public abstract func(params);
    ...
}
```
자바는 인터페이스에서 상수는 항상 `public static final`을 접두사로 붙여야하며, 메소드는 항상 `public abstract`를 접두사로 붙여야 하기 때문에 인터페이스 내부에서 접두사를 적지 않아도 컴파일 타임에서 자동 추가가 된다.

# 2. 인터페이스 구현하는 방법
```java
class className implements interfaceName { ... }
```
위에서 다중 상속의 이점을 버릴 수 없다고 하였다. 그에 대한 해답으로 인터페이스가 다중 상속이 된다.
일단 아래 예시를 보자.
```java
interface Animal { public abstract void cry(); }
interface Movement { public abstract void move(); }

class SmallDog implements Animal, Movement {
    public void cry() {
        System.out.println("왕왕");
    }
    public void move() {
        System.out.println("총총총");
    }
}

class BigDog implements Animal, Movement {
    public void cry() {
        System.out.println("왈왈!!");
    }
    public void move() {
        System.out.println("우당탕탕");
    }
}

public class Polymorphism1 {
    public static void main(String[] args) {
        SmallDog sD = new SmallDog();
        BigDog bD = new BigDog();

        sD.cry();
        sD.move();
        bD.cry();
        bD.move();
    }
}
```
자바에서는 다음과 같이 상속과 구현을 할 수 있다.
```java
class SubClass extend SuperClass implements InterFaceName { ... }
```

# 3. 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
인터페이스 타입의 참조 변수로 구현한 클래스의 인스턴스를 참조하는 것이 가능하다. 단 이와같이 인터페이스 타입의 참조 변수를 사용하면 클래스 상속 때와 마찬가지로 변수 타입이 가진 메소드 이외의 메소드는 사용할 수 없다.
```java
interfaceName variable = new MyClass();

// 인스턴스 접근
variable.method();
```

# 4. 인터페이스 상속
클래스가 다중상속 된 것처럼 인터페이스를 사용할 수 있다.
```java
interface Animal { public abstract void cry(); }
interface SmallDog { public abstract void cry(); }
interface BigDog { public abstract void cry(); }

class MyPet extends SmallDog, BigDog {
    public void cry() {
        System.out.println("왕왕 왈왈!!");
    }
}

public class Polymorphism2 {
    public static void main(String[] args) {
        MyPet pets = new MyPet();
        pets.cry();
    }
}
```
다만, 클래스를 이용하여 상속한 것이 아니기 때문에 구현을 꼭 해주어야한다.

# 5. 인터페이스의 기본 메소드 (Default Method), 자바 8
자바8부터 인터페이스에서 기본 메소드를 정의할 수 있다. 기본 메소드를 정의하면 인터페이스를 상속받고, 메소드를 구현하지 않아도 메소드를 사용할 수 있다.
```java
public interface Animal {
    default void cry() {
        System.out.println("크와앙");
    }
}
```
번외

자바8부터는 Iterable 인터페이스에 forEach() 기본 메소드가 추가 되었기 때문에 다음과 같은 일도 할 수 있다.
```java
ArrayList aList = new ArrayList<String>();
aList.add("Three");
aList.add("Two");
aList.add("One");

aList.forEach((item) -> System.out.println(item));
```
```console
Three
Two
One
```

# 6. 인터페이스의 static 메소드, 자바 8
default 메소드와 비슷하지만 다른 점이 있다. 바로 override가 불가능하다는 점이다. 사용 방법은 다음과 같다.
```java
interface Animal {
    public static void drinkWater() {
        System.out.println("찹찹찹찹");
    }
}
```

# 7. 인터페이스의 private 메소드, 자바 9
인터페이스 내부 default나 static 메소드만이 접근할 수 있는 메소드를 선언할 수 있다. 이에 대한 이점으로 인터페이스를 구현하는 클래스에서 구현에 대한 세부 정보를 숨길 수 있다.
```java
public interface Foo {
    default void bar() {
        System.out.print("Hello");
        baz();
    }
    private static void baz() {
        System.out.println(" world!");
    }

    static void buzz() {
        System.out.print("Hello");
        staticBaz();
    }
    private static void staticBaz() {
        System.out.println(" static world!");
    }
}

public class CustomFoo implements Foo {
    public static void main(String[] args) {
        Foo customFoo = new CustomFoo();
        customFoo.bar();
        Foo.buzz();
    }
}
```
```console
Hello world!
Hello satic world!
```