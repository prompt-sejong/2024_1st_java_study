- JVM이란 무엇인가
Java Virtual Machine 
java는 OS에 종속적이지 않음

보통의 프로그램/프로세스들은 OS가 실행시킴
==> 그러면 Java는 무엇이 실행시킬까?

OS 위에서 java를 실행시킬 것이 필요함
==> OS에 종속받지 않고, CPU가 Java를 인식할 수 있게 하는 가상 컴퓨터

![JVM-architecture](week_1\zizonminji\assets\jvm-architecture.png)

java 소스코드 (*.java 파일)은 CPU가 인식하지 못함
==> 기계어로 컴파일 해주어야 함

가상머신을 거쳐서 OS에 도달함
맨 처음에 가상머신도 바로 인식할 수 없음
source code (.java file) => [java compiler] => java byte code(.class file) => [JVM] => [OS] => execution!

![java-execution](week_1\zizonminji\assets\java-execution.jpg)

- 컴파일 하는 방법





- 실행하는 방법

- 바이트 코드란 무엇인가

- JIT 컴파일러란 무엇이며 어떻게 동작하는지

- JVM 구성 요소 

- JDK와 JRE의 차이