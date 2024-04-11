## 프리미티브 타입 종류와 값의 범위 그리고 기본 값  
&nbsp;
**primitice type** : 원시 타입, 실제 데이터의 값을 저장하는 타입  
&nbsp;

&nbsp;

프리미티브 타입은 `스택 메모리`에 저장됨  
레퍼런스 타입은 `힙 메모리`에 저장됨   
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

primitive type: 정수, 실수, 문자, 논리 리터럴 등의 실제 데이터 값을 저장하는 타입  
기본 자료형은 반드시 사용하기 전에 선언되어야 하고, 자료형의 길이는 운영체제에 독립적이고 변하지 않음.   

&nbsp;
reference type: 객체(Object)를 참조하여 주소를 저장하는 타입, 메모리 번지 값을 통해 객체를 참조함  
참조 타입은 Java에서 최상위 클래스인 Java.lang.Object 클래스를 상속하는 모든 클래스를 말함  
실제 객체는 힙(heap) 메모리에 저장됨. 참조 타입 변수는 스택 메모리에 실제 객체들의 주소를 저장하여 객체를 사용할 때마다 참조 변수에 저장된 객체의 주소를 불러와서 사용함.   

&nbsp;  
![](./assets/save_area.png)  
&nbsp;  


## 리터럴  
 &nbsp;

리터럴은 데이터 값 그 자체를 말함. 변수에 넣는 변하지 않는 데이터를 의미함.   



## 변수 선언 및 초기화하는 방법  
&nbsp;

## 변수의 스코프와 라이프타임  
&nbsp;

## 타입 변환, 캐스팅 그리고 타입 프로모션  
&nbsp;

## 1차 및 2차 배열 선언하기  
&nbsp;

## 타입 추론, var  
&nbsp;
