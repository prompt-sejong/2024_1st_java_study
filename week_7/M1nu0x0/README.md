- [1. package 키워드](#1-package-키워드)
- [2. import 키워드](#2-import-키워드)
- [3. 클래스패스](#3-클래스패스)
  - [3.1. 클래스패스 설정법](#31-클래스패스-설정법)
  - [3.2. CLASSPATH 환경변수](#32-classpath-환경변수)
  - [3.3. -classpath 옵션](#33--classpath-옵션)
- [4. 접근지시자](#4-접근지시자)

# 1. package 키워드
package 키워드는 해당 클래스가 어떤 패키지에 존재하는지를 명시해준다.
```
src
- App.java
- Coffee/
-- Blending.java
-- Espresso/
--- Extracting.java
--- ...
-- HandDrip/
--- Extracting.java
--- ...
```
위와 같은 패키지가 있다고 할 때 아래는 `package` 키워드를 사용한 예시이다.
```java
// Coffee/Blending.java
package Coffee;

public class Blending { ... }
```
```java
// Coffee/Espresso/Extracting.java
package Coffee.Espresso;

public class Extracting { ... }
```

# 2. import 키워드
다른 클래스나 메인 함수에서 패키지의 클래스들을 가져오려면 `import` 키워드를 사용해서 패키지를 불러와야한다. 다음은 그 예시이다.
```java
import Coffee.*;
// import Coffee.Blending

public class ImportTest {
    public static void main(String[] args) { ... }
}
```
하나만 가져와도 되고, 해당 패키지의 하위 클래스와 서브패키지를 모두 불러올 수 있다.

# 3. 클래스패스
클래스 패스는 자바가 클래스를 사용하려고 할 때 JVM이 사용하는 `parameter`로 클래스나 패키지를 찾을 때의 기준 경로이다.

## 3.1. 클래스패스 설정법
클래스 패스 설정 방법이 두가지가 있다. 환경변수로써 설정하는 방법이 있고, -classpath 옵션으로 설정하는 방법이 있다.

## 3.2. CLASSPATH 환경변수
다음은 `CLASSPATH` 환경변수 설정 방법이다. 시스템 변수 설정에 들어가서 시스템 변수 새로 만들기를 선택한 후에 다음과 같이 적으면 클래스 패스 환경변수가 설정된다. 다만 중요한 것은 JAVA_HOME이 먼저 설정되어 있어야 한다.
```
이름: CLASSPATH, 값: %JAVA_HOME%\lib
```

`CLASSPATH`는 `JAVA_HOME`과 더불어 환경변수로 설정하는 설정이다. 다만 현대의 jdk는 `빌드툴`을 사용하여 의존성 관리와 빌드를 함으로 수동으로 `CLASSPATH`를 잡을 필요가 없다.

빌드툴
1. Ant : 빌드
2. Maven : 라이브러리 관리 및 빌드
3. Gradle : 라이브러리 관리 및 빌드

여담.
`JAVA_HOME`을 환경변수에 설정하고, `Path`에 `%JAVA_HOME%\bin`을 추가하면 `java`나 `javac`등과 같은 명령어를 사용할 수 있다.

## 3.3. -classpath 옵션
jdk를 이용할 때 명시적으로 클래스 패스를 추가할 수도 있는데, classpath 옵션을 사용하면 된다. 예시는 `javac`로 들었지만 다른 jdk 명령어도 된다.
```console
javac -classpath .;./Packages;C:\java App.java
```
`.`은 현재 디렉토리이다.

# 4. 접근지시자
2주 차에서도 다뤘지만, 한 번 더 적어보자.
| Modifier              | Class | Package | Subclass | World |
| --------------------- | ----- | ------- | -------- | ----- |
| public                | Yes   | Yes     | Yes      | Yes   |
| protected             | Yes   | Yes     | Yes      | No    |
| Default (no modifier) | Yes   | Yes     | No       | No    |
| private               | Yes   | No      | No       | No    |

2주 차와는 다른 점이 있는데, Class 열을 추가했다.
- Class
  - 동일한 클래스 내부
  - public, protected, default, private
- Package
  - 동일한 패키지 내부
  - public, protected, default
- Subclass
  - 상속받은 클래스
  - public, protected
- World
  - 이외의 모든 공간
  - public