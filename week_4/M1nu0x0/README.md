- [1. 자바가 제공하는 제어문에는 무엇이 있을까?](#1-자바가-제공하는-제어문에는-무엇이-있을까)
- [2. 조건문](#2-조건문)
  - [2.1. if](#21-if)
  - [2.2. if else](#22-if-else)
  - [2.3. switch](#23-switch)
- [3. 반복문](#3-반복문)
  - [3.1. for](#31-for)
  - [3.2. while](#32-while)
  - [3.3. do whlie](#33-do-whlie)
- [4. 번외; 문자열 포맷팅](#4-번외-문자열-포맷팅)
  - [4.1. String.format()](#41-stringformat)
  - [4.2. String.join()](#42-stringjoin)
  - [4.3. String.valueOf()](#43-stringvalueof)
  - [4.4. String.copyValueOf()](#44-stringcopyvalueof)

# 1. 자바가 제공하는 제어문에는 무엇이 있을까?
제어문이란, 프로그램의 흐름을 변경할 수 있는 문법이다. 자바의 인터프리터는 위에서 아래로 프로그램을 읽어나간다. 따라서 제어문은 인터프리터가 어디를 읽게 할지 명령을 내리는 구문인 것이다.

[제어문](https://raccoonjy.tistory.com/10)에는 두 가지 종류가 있다.
- 조건문 (if, if else, switch)
- 반복문 (for, while, do while)

# 2. 조건문
## 2.1. if
java에서의 if 문법은 다음과 같다.
```java
if (조건문) {
    // do something
}
```
예시를 살펴보자.
```java
public class IfExample {
    public static void main(String args[]) {
        int score = 100;

        if (score >= 80) {
            System.out.println("Pass");     // Pass
        }

        System.out.println("Your Score: " + score); // Your Score: 100
    }
}
```

## 2.2. if else
java에서의 if else 문법은 다음과 같다.
```java
if (조건문) {
    // do something
}
else if (조건문) {
    // do something
}
else {
    // do something
}
```
예시를 살펴보자.
```java
public class GradeExample {
    public static void main(String args[]) {
        int score = 50;
        char grade;

        System.out.print("Grade: ");
        if (score >= 90) {
            grade = 'A';
        }
        else if (score >= 80) {
            grade = 'B';
        }
        else if (score >= 70) {
            grade = 'C';
        }
        else if (score >= 60) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }

        System.out.println(grade);  // F
    }
}
```

## 2.3. switch
switch문은 저번주에 다뤘지만 한 번 더 써보겠다. 기본 문법은 두 가지가 있는데, -> 연산자를 활용한 switch문은 java13 이상부터 사용할 수 있다.
```java
switch (수식) { // 수식은 int, 문자(char, string)
    case value1:
        // do something
        break;
    case value2:
        // do something
        // break;    // break를 만날 때까지 쭉 실행
    case value3:
        // do something
        break;
    default:
        // do something
        break;
}
```
switch 문을 적을 때는 break를 잘 달아야한다. 이는 `OR` 연산처럼 사용할 수가 있는데, 다음과 같이 적으면 value2와 value3일 때 시행된다.
```java
case value2:
case value3:
    // do something
    break;
```
다음은 새로운 switch 문법이다.
```java
switch (수식) {
    case value1 -> System.out.println("Do Something");
    case value2, value3 -> System.out.println("Do Something");
    default -> System.out.println("Do Something");
}
```
조금은 더 간결해진 모습이다. if else의 예시를 switch문으로 바꿔보자.
```java
public class SwitchGradeExample {
    public static void main(String args[]) {
        int score = 70;
        char grade;

        System.out.print("Grade: ");
        switch (score / 10) {
            case 9 -> grade = 'A';
            case 8 -> grade = 'B';
            case 7 -> grade = 'C';
            case 6 -> grade = 'D';
            default -> grade = 'F';
        }

        System.out.println(grade);  // A
    }
}
```

# 3. 반복문
## 3.1. for
for문은 초기식, 조건식, 증감식을 for문에 넣을 수 있어서 코드를 보면 언제 이 반복문을 탈출하는지 확인하기가 쉽다. 일단 문법부터 살펴보자.
```java
for (초기식; 조건식; 증감식) {
    // do something
}
```
for문은 특이하게 안에 들어가는 인자들을 다 채울 필요가 없다. 다음과 같이 초기화를 for문 바깥에서 해도 된다. 이는 i의 `lifetime` 때문인데, i를 for문 안에서 초기화 시켰다면 for문을 탈출 할 때 i의 `lifetime`이 끝난다. 하지만 바깥에서 초기화하면 for문을 탈출해도 i가 유지된다.
```java
int i=0;

for (; i<10; i++) {
    // do something
}
```
조건식도 뺄 수 있다. 다음과 같이 탈출 조건을 따로 적어주는 대신 기본적으로 10번 반복한다는 의미의 코드이다.
```java
boolean isLoop = true;

for (int i=0; ; i++) {
    if (!isLoop) {
        break;
    }
    // do something
}
```
증감식은 뺄 수도, 다르게 쓸 수도 있다.
```java
for (int i=10; i>0; i--) {
    // do something
}

for (int i=0; i<10; ) {
    // do something
    i += 2;
}
```
당연히 모두 빼먹을 수 있다. 다만 이 경우는 while을 쓰는 것이 가독성에 더 좋다.
```java
for (;;) {
    // do something
}
```
구구단 출력을 예시로 for문 활용을 살펴보자.
```java
public class TimesTable {
    public static void main(String args[]) {
        String format = "%d * %d = %d%n";

        for (int i=2; i<10; i++) {
            for (int j=1; j<10; j++) {
                // System.out.println(String.format(format, i, j, i*j));
                System.out.format(format, i, j, i*j);
            }
            System.out.println();
        }
    }
}
```
정수 뒤집기도 활용할 수 있다.
```java
public class ReverseInt {
    public static void main(String args[]) {
        int num = 1234;

        for (; num!=0; num/=10) {   // c언어처럼 num을 넣으면 안된다.
            System.out.print(num%10);
        }

        System.out.println();
    }
}
```
java는 int형을 boolean으로 취급하지 않기 때문에 논리형으로 넣어주어야 한다는 점을 유의하자.

## 3.2. while
우선 기본 문법부터 살펴보자.
```java
while (조건식) {
    // do something
}
```
while문은 위에 적었던 `boolean` 변수 `ifLoop`를 조건식에 넣는 등, 조건식이 참인 경우에만 돌아가게 설계되었다. 우선 예시 먼저 보자.
```java
public class WhileTest {
    public static void main(String args[]) {
        int num = 13;

        while (--num > 0) {
            System.out.println("Count Down: " + num);
        }
    }
}
```
혹은 원하는 값이 나올 때까지 `while문`을 돌게 만들 수도 있다. 활용 방안은 무궁무진하다.

## 3.3. do whlie
`while문`과의 차이점이라면 `while문`은 조건식을 먼저 확인하고 블록을 실행하지만, `do while문`은 우선 실행을 하고 조건식을 확인한다. 문법은 다음과 같다.
```java
do {
    // do something
} while (조건식);
```
`do while`은 조건식이 거짓이면 바로 탈출한다.

# 4. 번외; [문자열 포맷팅](https://adjh54.tistory.com/178)
위에서 구구단을 출력할 때 보지 못했던 것을 봤을 것이다. 이는 문자열 포맷팅인 것인데 우선 String에 관한 함수부터 알아보자.

| 함수                 | descriptions                                | 사용법                                                                        |
| -------------------- | ------------------------------------------- | ----------------------------------------------------------------------------- |
| String.format()      | 문자열 포맷팅                               | 지정된 형식 문자열에 따라 인수를 받아 포맷팅 된 함수 반환                     |
| String.join()        | 문자열 리스트를 결합                        | 지정된 구분자를 기준으로 입력받은 문자열 리스트를 결합한 문자열 반환          |
| String.valueOf()     | 객체를 문자열로 변환                        | 입력값으로 숫자, 문자, 논리형, 문자열 및 기타 객체를 인수로 받아서 사용       |
| String.copyValueOf() | 문자열 일부를 복사하여 새로운 문자열을 생성 | 복사할 문자열과 시작 위치, 복사할 문자의 개수를 입력받아 새로운 문자열을 반환 |

## 4.1. String.format()
```java
public static String format(String format, Object... args)
```

| Type   | Param  | descriptions                                        |
| ------ | ------ | --------------------------------------------------- |
| String | format | 서식화할 문자열. %d 등 포맷 지정자를 사용할 수 있음 |
| Object | args   | 포맷 지정자에 맞춰서 대응 시킬 값                   |

| 포맷 지정자 | descriptions    |
| ----------- | --------------- |
| %s          | 문자열          |
| %d          | 10진수 정수     |
| %f          | 부동소수점 실수 |
| %c          | 문자            |
| %b          | boolean         |
| %n          | 개행            |

아까 위의 예시처럼 사용할 수도 있다.
```java
public class FormatTest {
    public static void main(String args[]) {
        String result = "id: %08d, name: %s";
        int id=1234;
        String name="asdf";
        // do something

        // 아래 세 메소드의 출력이 같음
        System.out.format(result, id, name);
        System.out.printf(result, id, name);
        System.out.println(String.format(result, id, name));
    }
}
```
[출력구문 추가 정보](https://keep-cool.tistory.com/15), [포맷팅 추가 정보](https://plas.tistory.com/18)

## 4.2. String.join()
```java
public static String join(CharSequence delimiter, CharSequence... elemetns)
```

| Type         | Param     | descriptions                      |
| ------------ | --------- | --------------------------------- |
| CharSequence | delimiter | 문자열을 결합할 때 사용할 구분자. |
| CharSequence | elements  | 결합할 문자열을 담은 배열         |

다음 코드는 예시이다.
```java
public class JoinTest {
    public static void main(String args[]) {
        String arr[] = {"kim", "park", "lee"};
        String result = String.join(", ", arr); // char면 안됨

        System.out.println(result); // kim, park, lee
    }
}
```

## 4.3. String.valueOf()
```java
public static String valueOf(boolean b)
public static String valueOf(char c)
public static String valueOf(char[] data)
public static String valueOf(double d)
public static String valueOf(float f)
public static String valueOf(int i)
public static String valueOf(long l)
public static String valueOf(Object obj)
```

| Type    | Param | descriptions      |
| ------- | ----- | ----------------- |
| boolean | b     | boolean 타입의 값 |
| char    | c     | char 타입의 값    |
| char[]  | data  | char[] 타입의 값  |
| double  | d     | double 타입의 값  |
| float   | f     | float 타입의 값   |
| int     | i     | int 타입의 값     |
| long    | l     | long 타입의 값    |
| Object  | obj   | Object 타입의 값  |

다음 예시를 보자.
```java
public class ValueOfTest {
    public static void main(String args[]) {
        int num = 1234;
        String str = String.valueOf(num);

        System.out.println(str); // 10
    }
}
```

## 4.4. String.copyValueOf()
```java
public static String copyValueOf(char[] data)
public static String copyValueOf(char[] data, int offset, int count)
```

| Type   | Param  | descriptions                |
| ------ | ------ | --------------------------- |
| char[] | data   | char[] 타입의 배열          |
| int    | offset | 변환할 문자열의 시작 인덱스 |
| int    | count  | 변환할 문자열의 길이        |

다음 예시를 보자.
```java
public class CopyValueOfTest {
    public static void main(String args[]) {
        String hello = "Hello";
        char[] arr = hello.toCharArray();
        // char[] arr = {'H', 'e', 'l', 'l', 'o'};
        // 0_1_2_3_4_5
        // _H_e_l_l_o_

        String str1 = String.copyValueOf(arr);
        System.out.println(str1);   // Hello
        
        String str2 = String.copyValueof(arr, 1, 3);    // 1부터 4까지
        System.out.println(str2);   // ell
    }
}
```