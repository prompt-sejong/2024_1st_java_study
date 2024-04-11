## 프리미티브 타입 종류와 값의 범위 그리고 기본 값  
&nbsp;
**primitive type** : 원시 타입, 실제 데이터의 값을 저장하는 타입  
&nbsp;

원시 타입은 `스택 메모리`에 저장됨  
참조 타입은 `힙 메모리`에 저장됨   
&nbsp;
- - -  
### 프리미티브 타입 종류  
- **int**  (초기값: 0)  
`size`: 4 byte (32 bits)  
`range`: -2^(-31)~2^(31)-1  

- **long**  (초기값: 0.L)  
`size`: 8 byte (64 bits)  
`range`: -2^(63)~2^(63)-1 

- **double**  (초기값: 0.0)  
`size`: 8 byte (64 bits)    
`range`: -2^(-1074)~(2-2^(-52))*2^(1023)  

- **float**  (초기값: 0.0F)  
`size`: 4 byte (32 bits)      
`range`: -2^(-149)~(2-2^(-23))*2^(127)  
  
- **boolean**  (초기값: false)    
`size`: 1 byte (8 bits)  
`range`: true, false  
* 자바는 파이썬과 다르게 true, false 모두 소문자

- **byte**  (초기값: 0)  
`size`: 1 byte (8 bits)    
`range`: -128~127

- **short**  (초기값: 0)  
`size`: 2 byte (16 bits)    
`range`: -2^(-15)~2^(15)-1

- **char**  (초기값: '\u0000')  
`size`: 2 byte (16 bits)     
`range`: 0~2^(16)-1  
&nbsp;

- - -
&nbsp;
&nbsp;

## 프리미티브 타입과 레퍼런스 타입  
&nbsp;
&nbsp;

`primitive type`: 정수, 실수, 문자, 논리 리터럴 등의 실제 데이터 값을 저장하는 타입  
기본 자료형은 반드시 사용하기 전에 선언되어야 하고, 자료형의 길이는 운영체제에 독립적이고 변하지 않음.   

&nbsp;
`reference type`: 객체(Object)를 참조하여 주소를 저장하는 타입, 메모리 번지 값을 통해 객체를 참조함  
참조 타입은 Java에서 최상위 클래스인 Java.lang.Object 클래스를 상속하는 모든 클래스를 말함  
실제 객체는 힙(heap) 메모리에 저장됨. 참조 타입 변수는 스택 메모리에 실제 객체들의 주소를 저장하여 객체를 사용할 때마다 참조 변수에 저장된 객체의 주소를 불러와서 사용함.   

&nbsp;  
![](./assets/save_area.png)  
&nbsp;  


## 리터럴  
 &nbsp;
 ![](./assets/literal.jpeg)

리터럴은 데이터 값 그 자체를 말함. 변수에 넣는 변하지 않는 데이터를 의미함.   
**상수와의 차이점:** 상수에 넣는 데이터는 숫자 뿐만이 아니라 `객체, 구조체` 등도 가능함.  
리터럴은 메모리 공간 안에 저장되는 값임.  

 &nbsp;

## 변수 선언 및 초기화하는 방법  
&nbsp;

**멤버 변수 초기화** : 초기화를 하지 않아도 자동적으로 **변수의 자료형의 기본값** 으로 초기화됨.  
**지역변수 초기화** : 사용하기 전 반드시 초기화 필요함!  
&nbsp;  


>  **초기화 방법**  
> 1. 명시적 초기화
> 2. 생성자
> 3. 초기화 블록  

&nbsp;  

- - -
&nbsp;  


`1. 명시적 초기화`  
&nbsp;  

변수를 선언과 동시에 초기화하는 것.

```Java
int minji=2;
Student m=new Student();
```  
&nbsp;  




`2. 생성자`
&nbsp;  

생성자의 이름은 클래스 이름과 동일해야 함  
생성자는 다른 멤버함수와 다르게 리턴 타입이 없으며, 객체가 생성될 때 자동으로 한번 호출됨
생성자는 매개변수 조건에 따라서 여러개 작성할 수 있고 (오버로딩) 생성자가 없을 경우 컴파일러가 기본 생성자를 자동으로 생성함. 그러나 만약 생성자가 1개라도 작성되어 있으면 컴파일러는 기본 생성자를 자동으로 생성하지 않음. 

```java
public class Minji{
    String name;
    int age;
    int height;
    int weight;

    public Minji(){ }      //기본 생성자

    public Minji(String b, int a){   //매개변수를 가진 생성자
        this.age=a;
        this.name=b;
    }
}
```  
&nbsp;  

**사용 예시**
```java
public class HelloWorld {
	public static void main(String[] args) {
        Minji m1=new Minji();
        Minji m2=new('minji', 22);
    }
}
```  
&nbsp;  


`3. 초기화 블록`

**1. 클래스 초기화 블럭**
```java
class minji{
    static{
        /*클래스 초기화 블럭*/
    }
}
```
&nbsp;  

**2. 인스턴스 초기화 블럭**
```java
class minji{
    {
        /*인스턴스 초기화 블럭*/
    }
}
```  

인스턴스 초기화 블럭은 인스턴스를 생성할 때마다 수행됨   
ㄴ 모든 생성자에서 **공통**으로 수행할 코드를 넣어주는 것이 좋음!
&nbsp;  

클래스 초기화 블럭은 클래스가 메모리에 처음 로딩될 때 한번만 수행됨  





## 변수의 스코프와 라이프타임  
&nbsp;



## 타입 변환, 캐스팅 그리고 타입 프로모션  
&nbsp;


## 1차 및 2차 배열 선언하기  
&nbsp;


## 타입 추론, var  
&nbsp;


