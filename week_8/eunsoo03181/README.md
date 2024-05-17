# Java 8주차

## 개요

인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 하며, 개발 코드가 인터페이스의 메소드를 호출하면 객체의 메소드를 호출시키는 방식입니다. 

---

## 다중 상속

클래스가 두 개 이상의 클래스를 상속받을 수 있다면, 다양한 일을 수행할 수 있을 것입니다. C++에서는 다중 상속을 지원하여, 상속을 복합적으로 활용할 수 있습니다. 

```cpp
#include <iostream>
using namespace std;

class Parent1 {
private:
	int a = 1;

public:
	int getA() {
		return a;
	}
};

class Parent2 {
private:
	int b = 1;

public:
	int getB() {
		return b;
	}
};

class Child : public Parent1, public Parent2 {
public:
	int getTotal() {
		return getA() + getB();
	}
};

int main() {
	Child ch;
	cout << "a + b = " << ch.getTotal() << endl;
}
```

위의 코드에서는 두 부모 클래스의 필드값을 다중 상속을 통해 받고 둘의 합을 구하는 소스코드입니다.

```java
package WEEK08.Sample;

class Parent1 {
    private int a = 1;

    public int getA() {
        return a;
    }
}

class Parent2 extends Parent1 {
    private int b = 1;

    public int getB() {
        return b;
    }
}

class Child extends Parent2 {
    public int getTotal() {
        return getA() + getB();
    }
}

public class Alternative {
    public static void main(String[] args) {
        Child ch = new Child();
        System.out.println("a + b = " + ch.getTotal());
    }
}
```

Java의 경우, 다중 상속이 지원되지 않기 때문에 기본적으로 위와 같이 하고 싶다면, 객체를 따로 생성하거나, 상속을 두 번 사용하여 구현을 할 수 있습니다. C++로 구현한 것보다 복잡해 보입니다.

하지만, 다중 상속을 하게 된다면 메소드 출처의 모호성이 발생할 수 있습니다. 이를 ‘죽음의 다이아몬드(DDD: The Deadly of Diamond Dead)’라고 부릅니다.

```cpp
#include <iostream>
using namespace std;

class Parent1 {
public:

	void printA() {
		cout << "A" << endl;
	}

	void method() {
		cout << "Hello, World!" << endl;
	}
};

class Parent2 {
public:

	void printB() {
		cout << "B" << endl;
	}

	void method() {
		cout << "This is cpp world!" << endl;
	}
};

class Child : public Parent1, public Parent2 {
public:
	void getAandB() {
		printA();
		printB();
	}

	void getMethod() {
		// method(); > 오류: method 엑세스가 모호합니다.
		Parent1::method();
		Parent2::method();
	}
};

int main() {
	Child ch;
	ch.printA();
	ch.printB();
	ch.getAandB();
	ch.getMethod();
	//ch.method(); > 오류
	ch.Parent1::method();
	ch.Parent2::method();
}
```

두 개의 부모 클래스가 같은 메소드를 가지고 있다면, 자식 클래스는 메소드를 호출할 때 문제가 발생하게 됩니다. 위와 같은 경우, 자식 클래스가 method()를 호출할 떄, 두 부모로부터 같은 메소드를 상속받기 때문에, method의 접근이 모호해집니다. 이를 해결하기 위해서는, 어떤 부모의 메소드를 상속받았는지를 정확히 명시함으로, 에러를 피할 수 있습니다. (여기서 ‘::’는 범위 지정 연산자입니다.)

   

다중 상속의 문제점은 이뿐만 아니라, 코드 간의 의존성과 결합성을 과도하게 높여 코드의 보수와 수정을 어렵게 만들고, 코드가 복잡해져 가독성이 떨어진다는 점이 있습니다.

위와 같은 문제점이 있어, 다중 상속을 지원하는 C++ 개발자도 다중 상속을 기피하는 경향이 있습니다. 많은 객체 지향 프로그래밍 언어는 다중 상속을 금지하고 있고, Java도 여기에 포함됩니다.

그러나, Java는 인터페이스(interface)를 통해, 다중 상속 기능을 지원하고 있습니다.

---

## 인터페이스 선언

인터페이스 선언 방법은 클래스와 유사합니다.

```java
public interface MyInterface { ... }
```

생성자, 필드, 메소드로 구성된 클래스와 달리, 인터페이스는 상수 필드와 추상 메소드만을 멤버로 가집니다. 인터페이스는 클래스와 다른 개념이기 때문에, 객체를 생성할 수 없습니다. 

즉, 인터페이스는 생성자를 가질 수 없습니다.

### 상수 필드 선언

상수를 선언할 때, 주로 ‘public static final’ 특성을 붙이는데, 상수 필드만을 가지는 인터페이스는 기본적으로 필드를 생성할 경우 ‘public static final’ 특성을 자동으로 가집니다.

```java
package WEEK08.Interface;

public interface ConstantField {
    // 상수 필드를 선언합니다.
    double PI = 3.1415926535;
    double e = 2.71828182845;

    int MAX_SPEED = 300000;
}
```

캐멀 케이스로 클래스명을 지은 것처럼, 상수를 선언할 때는 대문자와 언더바()로 연결하는 것이 관례입니다. 위와 같이, 일반적인 필드였다면 maxSpeed와 같은 이름을 지었겠지만, 위는 상수이므로, MAX_SPEED로 이름을 지을 수 있습니다.

### 추상 메소드 선언

인터페이스에서 생성된 메소드는 최종적으로 객체에서 실행되므로, 인터페이스의 메소드는 실행 블록이 필요하지 않은 추상 메소드를 선언할 수 있습니다. 추상 메소드는 ‘public abstract’라는 특성을 가지고 있기 때문에, 인터페이스에서 생성된 메소드는 기본적으로 ‘public abstract’ 특성을 가집니다.

```java
package WEEK08.Interface;

public interface AbstractMethod {
    void printPI();
    void printMAX_SPEED();
    int getArea(int r);
}
```

---

## 인터페이스 구현

소스코드가 인터페이스 메소드를 호출할 경우, 인터페이스는 객체의 메소드를 호출합니다. 객체는 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름, 매개 타입, 리턴 타입을 가진 실체 메소드를 가지고 있어야 하며, 이러한 객체를 인터페이스의 구현 객체(Implement Object)라고 합니다. 구현 객체를 생성하는 클래스를 구현 클래스(Implement Class)라고 합니다.

### 구현 클래스

구현 클래스는 인터페이스 타입으로 사용할 수 있음을 명시하기 위해 다음과 같이 선언합니다.

```java
public class ClassName implements InterfaceName {
// 인터페이스에 선언된 추상 메소드의 실체 메소드 선언
}
```

다음 코드는 두 개의 인터페이스 ConstantField와 AbstractMethod를 구현하는 클래스입니다. 하나의 부모 클래스만 상속 받을 수 있는 것과 달리, 인터페이스는 여러 개를 하나의 클래스에 구현할 수 있습니다.

```java
package WEEK08.Interface;

public class UsingInterface implements AbstractMethod, ConstantField {

    public void printPI() {
        System.out.println(ConstantField.PI);
    }
    
    public void printMAX_SPEED() {
        System.out.println(ConstantField.MAX_SPEED);
    }
    
    public double getArea(double r) {
        return r*r*ConstantField.PI;
    }
}
```

구현 클래스는 인터페이스의 추상 메소드를 모두 실체 메소드로 만들어야 합니다. 이를 구현(Implement)라고 합니다. 구현은 메소드를 재정의하는 오버라이딩(Overriding)과 비슷해 보이지만, 오버라이딩은 상속 관계에서 사용되므로, 둘은 다른 개념입니다.

하지만, 구현은 오버라이딩과 비슷하게 접근 제어자를 좁힐 수 없습니다. 즉, 인터페이스의 모든 메소드는 public 제어자이기 때문에 실체 메소드의 접근 제어자도 public으로 지정하여야 합니다.

구현 클래스가 인터페이스의 접근 제어자를 좁힐 수 있다면, 그 인터페이스를 구현하는 다른 클래스들에서 해당 메소드에 접근할 수 없게될 수 있으므로, 코드와 객체가 서로 통신을 하는 접점 역할을 하는 인터페이스의 정의에 위반됩니다. 다시 말해, 인터페이스를 구현하는 클래스들은 모두 인터페이스에 정의된 메소드를 구현하여야 합니다. 

오버라이딩도 비슷한 이유입니다. 상속 관계인 두 클래스에 대해, 자식 클래스는 부모 클래스를 대체 가능해야 합니다. 이를 ‘리스코프 치환 원칙(Liskov Substitution Principle)’이라고 합니다.  부모 클래스 형식으로 작성된 코드가 자식 클래스의 객체를 사용할 때, 동작이 예상대로 이루어져야 한다는 것을 의미합니다. 부모 클래스와 자식 클래스는 동일한 방식으로 작동해야 하며, 자식 클래스는 부 클래스의 기능을 보장해야 합니다. 자식 클래스에서 메소드의 접근 제어자를 축소하면, 부모 클래스의 메소드가 클라이언트 코드에서 호출되었을 때 자식 클래스의 메소드가 호출되지 않을 수 있기 때문에 ‘자식 클래스는 부모 클래스를 대체 가능해야 한다.’는 원칙을 위배합니다.

다음은 실행 클래스 예시입니다.

```java
package WEEK08.Interface;

public class Main {
    public static void main(String[] args) {
        UsingInterface ui = new UsingInterface();
        ConstantField cf = ui;
        AbstractMethod am = ui;
        
        // 방법2
        // ConstantField cf;
        // cf = new UsingInterface();
    }
}
```

방법2는 하나의 인터페이스를 구현하는 경우 사용하는 예시입니다. 

기본적으로, 인터페이스로 구현 객체를 사용하고 싶다면, 인터페이스를 선언하고, 구현 객체를 대입하여야 합니다. 

위의 코드의 경우, UsingInterface 클래스는 ConstantField와 AbstractMethod를 모두 구현하고 있으므로, 두 개의 인터페이스에 대입합니다.

---

## 인터페이스 사용

클래스를 선언하면 인터페이스는 필드, 생성자 또는 메소드의 매개 변수, 생성자 또는 메소드의 지역 변수로 선언될 수 있습니다.

개발 코드(UsingInterface)와 구현 객체(ImplementClass) 사이에서 접점 역할을 하는 것이 바로 인터페이스(MyInterface)입니다. 개발 코드는 인터페이스로부터 추상 메소드를 호출하고, 인터페이스는 구현 객체로부터 재정의 메소드를 호출합니다.

다음 코드는 WEEK08.Sample.Alternative.java를 인터페이스로 다시 구현한 것입니다. 인터페이스를 통해 다중 상속과 비슷한 기능을 구현해낼 수 있습니다.

```java
package WEEK08.Sample;

interface Parent1_ {
    int getA();
}

interface Parent2_ {
    int getB();
}

class Parent1Impl implements Parent1_ {
    private int a = 1;

    public int getA() {
        return a;
    }
}

class Parent2Impl implements Parent2_ {
    private int b = 1;
    
    public int getB() {
        return b;
    }
}

class Child_ implements Parent1_, Parent2_ {
    private Parent1_ parent1 = new Parent1Impl();
    private Parent2_ parent2 = new Parent2Impl();

    public int getA() {
        return parent1.getA();
    }

    public int getB() {
        return parent2.getB();
    }

    public int getTotal() {
        return getA() + getB();
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Child_ ch = new Child_();
        System.out.println("a + b = " + ch.getTotal());
    }
}
```

---

## 인터페이스 타입 변환과 다형성

인터페이스를 이용하여 코딩을 했다면, 구현 객체의 교체는 매우 용이해집니다. 구현 객체를 교체하여 프로그램의 실행 결과를 다양하게 만드는 것을 인터페이스 다형성이라고 합니다.

### 자동 타입 변환

구현 객체가 인터페이스 타입으로 변환되는 것도 자동 타입 변환(promotion)입니다. 인터페이스 구현 클래스를 상속받은 자식 클래스는 인터페이스 타입으로 자동 타입 변환됩니다.

```java
package WEEK08.InterfacePolymorphism;

interface A { }

class B implements A { }
class C implements A { }
class D extends B { }
class E extends C { }

public class InterfacePromotion {
    B b = new B();
    C c = new C();
    D d = new D();
    E e = new E();
    
    // 상속받은 클래스를 인터페이스 타입으로 변환할 수 있습니다.
    A a1 = b;
    A a2 = c;
    A a3 = d;
    A a4 = e;
}
```

상속 때와 마찬가지로, 위와 같은 원리로 필드와 매개변수의 다형성을 구현할 수 있습니다.

### 강제 타입 변환

구현 객체가 인터페이스 타입으로 자동 타입 변환되면, 인터페이스에 선언된 메소드만 사용 가능하므로, 다른 메소드를 사용하고 싶다면, 강제 타입 변환(Casting)을 해 다시 구현 클래스 타입으로 뱐환 후 구현 클래스만이 가지고 있던 필드와 메소드를 사용할 수 있습니다.

```java
package WEEK08.InterfaceCasting;

public interface Vehicle {
    public void run();
}
```

```java
package WEEK08.InterfaceCasting;

public class Car implements Vehicle{
    public void run() {
        System.out.println("부릉부릉");
    }

    public void superRun() {
        System.out.println("힘차게 부릉부릉");
    }
}
```

```java
package WEEK08.InterfaceCasting;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();

        vehicle.run();
        // vehicle.superRun(); 사용 불가

        // 강제 타입 변환
        Car car = (Car) vehicle;

        car.run();
        car.superRun();
    }
}
```

### instanceof 연산자

강제 타입 변환의 경우, 구현 객체가 인터페이스 타입으로 변환되어 있는 경우에만 가능하므로, instanceof 연산자를 통해, 타입 변환이 가능한지를 파악하여 예외(Exception)를 피할 수 있습니다.

---

## 인터페이스 상속

인터페이스도 상속이 가능하며, 클래스와 다른 점은 다중 상속을 허용한다는 점입니다.

```java
public interface ChildInterface extends Interface1, Interface2... { ... }
```

상속하는 인터페이스를 부모(상위) 인터페이스라고 하고, 받는 인터페이스를 자식(하위, 파생) 인터페이스라고 합니다. 자식 인터페이스를 구현하는 클래스는 자식 인터페이스 뿐만 아니라, 부모 인터페이스의 모든 메소드에 대한 실체 메소드가 있어야 하므로, 구현 클래스로부터 객체를 생성한 후에는 자식 인터페이스의 모든 부모 인터페이스로도 타입 변환이 가능합니다.

그러나, 위와 같이 타입 변환을 하게 되면, 부모 인터페이스의 메소드만 사용할 수 있게 됩니다.

```java
package WEEK08.InterfaceInheritance;

public interface Parent1 {
    void method1();
}
```

```java
package WEEK08.InterfaceInheritance;

public interface Parent2 {
    void method2();
}
```

```java
package WEEK08.InterfaceInheritance;

public interface Parent3 {
    void method3();
}
```

```java
package WEEK08.InterfaceInheritance;

public interface Child extends Parent1, Parent2, Parent3 {
    void method4();
}
```

```java
package WEEK08.InterfaceInheritance;

public class ImplementClass implements Child{
    @Override
    public void method1() {
        System.out.println("1번 메소드");
    }

    @Override
    public void method2() {
        System.out.println("2번 메소드");
    }

    @Override
    public void method3() {
        System.out.println("3번 메소드");
    }

    @Override
    public void method4() {
        System.out.println("4번 메소드");
    }
}
```

```java
package WEEK08.InterfaceInheritance;

public class Main {
    public static void main(String[] args) {
        ImplementClass ic = new ImplementClass();

        Parent1 p1 = ic;
        p1.method1();

        Parent2 p2 = ic;
        p2.method2();
        System.out.println();

        Parent3 p3 = ic;
        p3.method3();
        System.out.println();

        Child ch = ic;
        ch.method1();
        ch.method2();
        ch.method3();
        ch.method4();
    }
}
```

---

## 인터페이스의 기본 메소드

Java 8(2014년 이후)부터 인터페이스에 변화가 생겨 기본 메소드와 static 메소드가 추가되었습니다. 기본 메소드는 인터페이스 내에서 생성할 수 있고, 구현 클래스를 만들 때, 구현 필요 없이 사용할 수 있습니다.

그러나, 필요에 따라 구현 클래스에 기본 메소드는 오버라이딩될 수 있습니다.

```java
package WEEK08.DefaultInterface;

public interface MyInterface {
    void method();

    default void defaultMethod() {
        System.out.println("기본 메소드 호출");
    }
}
```

```java
package WEEK08.DefaultInterface;

public class ImplementClass implements MyInterface {
    @Override
    public void method() {
        System.out.println("Hello, World!");
    }
}
```

```java
package WEEK08.DefaultInterface;

public class ImplementClass2 implements MyInterface {
    @Override
    public void method() {
        System.out.println("Goodbye, World!");
    }

    @Override
    public void defaultMethod() {
        System.out.println("기본 메소드 오버라이딩");
    }
}
```

```java
package WEEK08.DefaultInterface;

public class Main {
    public static void main(String[] args) {
        ImplementClass ic = new ImplementClass();
        ic.method();
        ic.defaultMethod();
        System.out.println();

        ImplementClass2 ic2 = new ImplementClass2();
        ic2.method();
        ic2.defaultMethod();
    }
}
```

---

## 인터페이스의 static 메소드

static 메소드는 인터페이스 자체에 속한 메소드로 default 메소드와 유사해보이지만, 따로 인터페이스를 구현하지 않아도 사용을 할 수 있습니다.

```java
package WEEK08.StaticInterface;

public interface StaticMethod {
    static void method() {
        System.out.println("method() 메소드");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        StaticMethod.method();
    }
}
```

---

## 인터페이스의 private 메소드

인터페이스의 private 메소드는 Java 9(2017년 이후)부터 지원하며, private 제어자의 기능과 마찬가지로, 인터페이스 내에서만 사용할 수 있는 메소드입니다. 구현을 요구하지 않습니다.

```java
package WEEK08.PrivateInterface;

public interface PrivateMethod {

    // static은 인터페이스에 그 자체에 속하기 때문에, private를 통해 접근할 수 없습니다.

    default void method() {
        System.out.println(A() + B());
    }

    private int A() {
        return 1;
    }

    private int B() {
        return 2;
    }
}
```

```java
package WEEK08.PrivateInterface;

public class ImplementClass implements PrivateMethod { }
```

```java
package WEEK08.PrivateInterface;

public class Main {
    public static void main(String[] args) {
        PrivateMethod a = new ImplementClass();
        a.method();
        // a.A(); 오류(private)
    }
}
```

위와 같이 private 메소드는 구현 객체를 통해서 main 메소드에 접근할 수 없고, PrivateMethod 인터페이스 내에서만 호출할 수 있습니다. 또한, 인터페이스의 static 메소드는 객체 소속이 아닌 인터페이스 그 자체에 속하기 때문에, private 메소드에 접근할 수 없습니다.
