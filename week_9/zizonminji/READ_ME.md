## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
  
```java
try {
    <수행할 문장 1>;
    <수행할 문장 2>;
    ...
} catch(예외1) {
    <수행할 문장 A>;
    ...
} catch(예외2) {
    <수행할 문장 a>;
    ...
} finally {
    //예외에 상관 없이 반드시 실행됨
    <마지막에 수행할 문장>;
}
```

```java
public class Sample {
    public void sayNick(String nick) throws FoolException {
        //try {   // try .. catch 문을 삭제할수 있다.
        if("바보".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("당신의 별명은 "+nick+" 입니다.");
        //}catch(FoolException e) {
        //    System.err.println("FoolException이 발생했습니다.");
        //}
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.sayNick("바보");
        sample.sayNick("야호");
    }
}
```

sayNick에서 예외 처리를 할 경우 예외 처리한 인스트럭션의 뒷 문장이 같이 실행됨  
그러나 메인 함수에서 try-catch문으로 예외 처리를 할 경우 예외가 발생하면 catch 문장으로 빠져나가서 예외가 발생한 인스트럭션 뒤에 있는 인스트럭션이 실행되지 않음
  
<br>

- **throw와 throws의 차이**  

throw와 throws는 예외 처리와 관련된 키워드로 다음과 같은 차이점이 있음  

**throw:** 메서드 내에서 예외를 발생시키는 데 사용  
(예: throw new FoolException())  
<br>
**thorws:** 메서드 선언부에서 사용되며, 해당 메서드가 처리하지 않은 예외를 호출자에게 전달함을 나타냄.  
(예: public void sayNick(String nick) throws FoolException)  
<br>

## 자바가 제공하는 예외 계층 구조


![](./assets/스크린샷%202024-05-24%20오전%201.00.39.png)

**빨간색:** 체크 예외(checked Exception)

RuntimeException을 상속받지 않은 예외
체크 예외가 발생할 수 있는 메소드를 사용할 경우, 복구가 가능한 예외들이기 때문에 반드시 예외를 처리하는 코드를 작성해야 함.  
이때 해결하지 않으면 컴파일 시 체크 예외가 발생함.  

ex: IOException, SQLException  

**파란색:** 언체크 예외(unchecked Exception)

RuntimeException을 상속한 예외, 예외처리를 강제하지 않음.  
언체크 예외는 따로 catch문으로 예외를 잡거나 throws로 선언하지 않아도 됨. 프로그램에 오류가 있을 때 발생하도록 의도된 것임.  

ex: NullPointerException, illegalArgumentException  

## Exception과 Error의 차이는?

오류: 시스템이 종료되어야 할 수준의 상황과 같이 수습할 수 없는 심각한 문제를 의미함. 개발자가 미리 예측하여 방지하여야 함

예외: 개발가자 구현한 로직에서 발생한 실수나 사용자의 영향에 의해 발생함. 오류와 달리 개발자가 미리 예측하여 방지할 수 있기에 상황에 맞는 예외 처리를 해야 함.  



## RuntimeException과 RE가 아닌 것의 차이는?

체크 예외와 언체크 예외의 차이점을 이야기함.  


## 커스텀한 예외 만드는 방법

```java
public class CustomException extends RuntimeException {

    // 1. 매개 변수가 없는 기본 생성자
    CustomException() {

    }

    // 2. 예외 발생 원인(예외 메시지)을 전달하기 위해 String 타입의 매개변수를 갖는 생성자
    CustomException(String message) {
        super(message); // RuntimeException 클래스의 생성자를 호출합니다.
    }
}
```
```java
throw new 예외();
throw new 예외("메시지");
```

```java
public static void main(String[] args) {
    try{
        test();
    } catch (CustomException e) {
        System.out.println("커스텀 예외 테스트");
    }
}

public static void test() throws CustomException {
    throw new CustomException("예외 테스트 입니다.");
}
```