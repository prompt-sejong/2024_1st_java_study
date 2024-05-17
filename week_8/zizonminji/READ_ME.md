## 인터페이스 정의하는 방법

```java
접근제어자 interface 인터페이스이름 {

    public static final 타입 상수이름 = 값;
    ...

    public abstract 메소드이름(매개변수목록);
    ...
}
```  

클래스를 선언하는 방법과 같은데, 클래스와는 다르게  
인터페이스의 모든 필드는 `public static final`이어야 하며,  
모든 메소드는 `public abstract`여야 함.   

제어자는 생략할 수 없으나, 생략된 제어자는 컴파일 할 경우 자바 컴파일러가 자동으로 추가해줌.  
<br>

- **추상클래스와 인터페이스의 차이점**
<br>

추상 클래스와 인터페이스 둘 다 추상화를 통해 구현을 강제하지만,  
추상 클래스는 일반 클래스와 마찬가지로 객체의 상태와 동작을 가질 수 있음.  
추상 메서드는 하위 클래스에서 반드시 구현해야 하지만, 일반 메서드는 구현할 필요가 없음.  
그러나 인터페이스는 메서드와 상수만 가질 수 있으며,  
구현 클래스에서 인터페이스에서 정의한 메서드를 반드시 구현해야 함.  

## 인터페이스 구현하는 방법  
```java
class 클래스이름 implements 인터페이스 이름 { ...}
```
<br>

인터페이스는 자신이 직접 인스턴스를 생성할 수 없음.  
인터페이스가 포함하고 있는 추상 메소드를 구현해줄 클래스를 작성해야 함.  

```java
interface Person{public abstract void talk();}

class minji implements Person{
    public void talk(){
        System.out.println("hello im minji");
    }
}

public class test1 {

    public static void main(String[] args) {

        Minji m=new Minji();

        m.talk();
    }
}

```

상속과 인터페이스 구현 동시에 할 수 있음.  

```java
class 클래스이름 extend 상위클래스이름 implements 인터페이스이름 { ... }
```



## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

```java
인터페이스 참조변수 = new 구현클래스 ();

구현클래스.멤버메서드();
```
<br>

```java
public interface test{
    public static final int t1=1;

    public abstract void method1();

    public abstract void method2();

}
```
<br>

```java
class testClass implements test {

    public void method1(){
        System.out.println("메서드 오버라이딩1");
    }

    public void method2(){
        System.out.println("메서드 오버라이딩2");
    }

    public void omg(){
        System.out.println("오엠쥐");
    }

}
```


<br>

```java
public class main {
 
    public static void main(String[] args) {

        test t1=new testClass();
        t1.method1();
        t1.method2();

        //사용 불가능
        //t1.omg();
    }
}
```


## 인터페이스 상속

인터페이스는 인터페이스로부터만 상속받을 수 있음.     
클래스처럼 Object같은 최고 조상은 존재하지 않음.   

```java
public interface Mother{

}

public interface Father{

}

public interface Parent{

}

public interface Child extends Parent{

}
```  

다중 상속 또한 가능함.  

```java
public interface child extends Mother, Mother{

}
```  
<br>  


## 인터페이스의 기본 메소드 (Default Method), 자바 8

자바 8에서 추가된 기능으로, 인터페이스에 새로운 메서드를 추가하기 위한 방법임.  
이전 자바에서는 인터페이스에 메서드를 선언하면 해당 인터페이스를 구현하는  
모든 클래스에서 선언한 메서드를 구현해야 했으나(오버라이딩),  
기본 메서드(default method)를 이용하면 구현 클래스에서 해당 메서드를 오버라이드 하지 않아도 됨.  

<br>

1. 정적 메서드: 인터페이스 내부 (기존 방식)
2. 디폴트 메서드: 인터페이스의 기본 구현을 제공 (추가된 방식)

```java
public interface MyInterface {
    // 추상 메서드
    abstract void abstractMethod();

    // default 메서드
    default void defaultMethod() {
        Sysout.out.println("It's a default method.");
    }
}
```

```java
public class MyClass implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("It's a abstract method.");
    }
    
     public static void main(String[] args) {
        MyClass m1 = new MyClass();
        m1.abstractMethod(); 
        m1.defaultMethod(); 
    }
}
```

```
출력 결과:  
It's a abstract method.  
It's a default method.  
```

※디폴트 메서드를 정의한 여러개의 인터페이스를 한 클래스가 다중 상속하면 문제가 발생할 수도 있음. 만약 상속받은 인터페이스의 디폴트 메서드의 이름이 겹치는 경우에는 어떤 인터페이스의 디폴트 메서드를 불러올지 모르게 됨. 따라서 이를 오버라이딩 해주고 return 으로 어떤 인터페이스의 메서드를 사용할지 표기해주어야 함. 

## 인터페이스의 static 메소드, 자바 8

`정적 메소드(static method)`  
인터페이스 안에 static 메소드를 선언하여 인터페이스를 이용해  
간단한 기능을 가지는 유틸리티성 인터페이스를 만들어주는 기능.

```java
public interface car {    
    static void help(){        
        System.out.println("자동차 운전 인터페이스입니다.");    
    }
}
```

```java
public class main {    
    public static void main(String[] args) {
        car c1=new car();
        car.help();
    }
}
```  
```
출력: 자동차 운전 인터페이스입니다.
```

인터페이스 상수같은 경우에도 static이므로 `인터페이스.상수 이름` 으로 접근해야 함.

## 인터페이스의 private 메소드, 자바 9

private method: 인터페이스 내에서만 사용 가능한 메서드  
디폴트 메서드나 정적 메서드에 사용하기 위해 작성되는 메서드.  
인터페이스를 구현하는 클래스에서 재정의하거나 사용할 수 없고, 디폴트나 정적 메서드를 통해서만 사용이 가능함.  

```java
public interface MyInterface {
    
    // 추상 메서드
    void abstractMethod();
    
    // 디폴트 메서드
    default void defaultMethod() {
        System.out.println("Default Method");
        privateHelperMethod();
    }
    
    // 정적 메서드
    static void staticMethod() {
        System.out.println("Static Method");
        privateStaticHelperMethod();
    }
    
    // private 인스턴스 메서드
    private void privateHelperMethod() {
        System.out.println("Private Helper Method");
    }

    // private 정적 메서드
    private static void privateStaticHelperMethod() {
        System.out.println("Private Static Helper Method");
    }
}

public class MyClass implements MyInterface {
    
    // 추상 메서드 구현
    @Override
    public void abstractMethod() {
        System.out.println("Abstract Method Implementation");
        // privateHelperMethod(); // 호출 불가
    }
    
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethod();
        myClass.defaultMethod();
        MyInterface.staticMethod();
    }
}

```

인터페이스의 일반 멤버 메소드에서는 사용이 불가능한가?  
-> 애초에 일반 멤버 메소드는 추상 메소드로 구현되어야 하기 때문에 내용 작성이 불가능함. 
