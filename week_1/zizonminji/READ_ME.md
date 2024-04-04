## JVM이란 무엇인가
Java Virtual Machine 
java는 OS에 종속적이지 않음

보통의 프로그램/프로세스들은 OS가 실행시킴
==> 그러면 Java는 무엇이 실행시킬까?

OS 위에서 java를 실행시킬 것이 필요함
==> OS에 종속받지 않고, CPU가 Java를 인식할 수 있게 하는 가상 컴퓨터

![JVM-architecture](./asset/jvm-architecture.png)

java 소스코드 (*.java 파일)은 CPU가 인식하지 못함
==> 기계어로 컴파일 해주어야 함

가상머신(VM)을 거쳐서 OS에 도달함
맨 처음에 가상머신(VM)도 바로 인식할 수 없음
source code (.java file) => [java compiler] => java byte code(.class file) => [JVM] => [OS] => execution!

![java-execution](./asset/java-execution.jpg)

## 컴파일 하는 방법

Java Compiler에 의해서 .java 파일이 .class (byte code)로 바뀜
JDK의 `./bin/javac.exe` 파일이 Java Compiler
`javac [java 소스코드 파일 이름].java` 를 실행하면 컴파일됨
==> .class 파일이 생성됨

## 실행하는 방법

<example!>
java source code file name: minji
cmd> javac minji.java  // compiler execution, class file create 
cmd> java minji        // type class file name, and execute 

## 바이트 코드란 무엇인가
**VM에서 돌아가는 실행 프로그램을** 위한 이진 표현법
자바에서의 byte code는 JVM이 이해할 수 있는 언어로 변환된 java source code를 의미함 (not binary code)

java compiler에 의해서 변환된 코드의 명령어 크기가 1바이트라서 자바 바이트 코드라고 불림

어떤 OS든 상관 없이 호환되는 JVM이 있다면 바이트코드로 컴파일 된 파일은 어디서든 실행할 수 있음
JVM이 플랫폼 환경에 맞추어 바이트 코드에서 기계어로 변환 => 플랫폼 환경에 따라 다시 컴파일 하지 않아도 됨


## JIT 컴파일러란 무엇이며 어떻게 동작하는지
JIT(just-in-time) Compiler는 Java Runtime Environment의 필수적인 부분임
런타임 또는 자바 어플리케이션의 성능 최적화를 담당함

자바 어플리케이션 속도: 바이트 코드 -> 기계어 코드 변환 방식에 따라서 달라짐

![java-jit](./asset/java-jit.png)

javac compiler를 통해서 소스 코드를 바이트 코드로 컴파일함
JVM은 런타임에 바이트 코드를 로드하고 인터프리터를 사용하여 기계 바이너리 코드로 변환함
자바 바이트 코드 해석 => 기본 어플리케이션에 비해서 성능이 저하됨
JIT 컴파일러는 바이트 코드를 "just-in-time" 적절한 시간에 실행될 수 있는 native machine code로 컴파일하여 성능을 높임 


## JVM 구성 요소


## JDK와 JRE의 차이



### 참고 자료
https://people-analysis.tistory.com/246
https://doozi0316.tistory.com/entry/1%EC%A3%BC%EC%B0%A8-JVM%EC%9D%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EB%A9%B0-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%8B%A4%ED%96%89%ED%95%98%EB%8A%94-%EA%B2%83%EC%9D%B8%EA%B0%80