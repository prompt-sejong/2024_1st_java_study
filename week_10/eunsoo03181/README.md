# Java 10주차


## 개요

Java에서 스레드(Thread)는 가상 머신(JVM: Java Virtual Machine)에 의해 통제됩니다. JVM은 여러 개의 스레드를 동시에 처리할 수 있고, 이를 통해 작업의 효율성을 높입니다.

---

## 프로세스와 스레드

프로세스(Process)란, 시스템(컴퓨터) 내에 실행 중인 프로그램을 의미합니다.

그리고, 스레드는 프로그램(프로세스) 내에서 실행되는 흐름의 단위를 의미합니다.

프로세스와 스레드는 흔히 은행으로 비유되는데, 프로세스를 한 지점의 은행이라고 한다면, 스레드는 그 안에 있는 고객 창구라고 할 수 있습니다.

프로세스 안에 스레드가 많다는 것은 고객 창구가 많아진다는 뜻이므로, 프로그램의 효율성이 증가합니다.

---

## Thread 클래스와 Runnable 인터페이스

Thread 클래스는 Java에서 멀티스레드를 구현할 수 있게 하는 클래스입니다. 클래스를 상속하거나 Runnable 인터페이스를 구현한다면 새로운 스레드를 만들 수 있습니다.

### Thread 클래스

Thread 클래스는 start() 메소드를 지원합니다. start() 메소드는 run() 메소드를 실행합니다. run() 메소드는 Runnable 인터페이스에 속한 추상 메소드이므로, 구현을 해야합니다.

```java
package WEEK10.Threading;

public class Threading extends Thread {
    int var;

    public Threading(int var) {
        this.var = var;
    }

    public void run() {
        System.out.println(this.var + "번 스레드 시작되었습니다.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        System.out.println(this.var + "번 스레드 종료되었습니다.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {  // 스레드를 생성하여 실행합니다.
            Thread threading = new Threading(i);
            threading.start();
        }
        System.out.println("main 메소드가 종료되었습니다.");
    }
}
```

```
main 메소드가 종료되었습니다.
1번 스레드 시작되었습니다.
7번 스레드 시작되었습니다.
9번 스레드 시작되었습니다.
3번 스레드 시작되었습니다.
2번 스레드 시작되었습니다.
6번 스레드 시작되었습니다.
4번 스레드 시작되었습니다.
5번 스레드 시작되었습니다.
0번 스레드 시작되었습니다.
8번 스레드 시작되었습니다.
0번 스레드 종료되었습니다.
7번 스레드 종료되었습니다.
4번 스레드 종료되었습니다.
5번 스레드 종료되었습니다.
8번 스레드 종료되었습니다.
6번 스레드 종료되었습니다.
9번 스레드 종료되었습니다.
2번 스레드 종료되었습니다.
3번 스레드 종료되었습니다.
1번 스레드 종료되었습니다.
```

실행할 때마다 출력 예시는 달라집니다.

실행을 하다보면, 이상한 점 두 가지를 찾을 수 있습니다.

첫 번째로, 우리가 흔히 아는 for문은 (위의 경우) 0에서 9까지 순서대로 진행이 됩니다. 또한, run() 메소드 안에는 시작과 종료가 같이 적혀 있습니다. 즉, 우리가 알고 있는 형태라면, 0번부터 9번 스레드까지시작과 종료가 번갈아가며 진행되어야 합니다.

두 번째로, main 메소드가 실행 중에 종료되었다는 것입니다. 프로그램의 순서와 상관없는 결과값이 출력되었습니다.

이는 스레드의 특징입니다. 각 스레드와 main 메소드는 모두 독립적으로 진행됩니다.

따라서, 위와 같이 main 메소드가 먼저 종료되고, 나머지 스레드들은 서로 독립적으로 실행된 것입니다.

### Runnable 인터페이스

Java에서는 클래스 간의 다중 상속을 지원하지 않기 때문에, Thread 클래스를 상속받은 클래스는 다른 클래스를 상속받을 수 없다는 단점이 있습니다. 그러나, Java는 인터페이스의 다중 상속을 허용하므로, Runnable 인터페이스를 사용하여 이 단점을 보완할 수 있습니다.

```java
package WEEK10.Threading;

public class ThreadingInterface implements Runnable {
    int var;

    public ThreadingInterface(int var) {
        this.var = var;
    }

    @Override
    public void run() {
        System.out.println(this.var + "번 스레드 시작되었습니다.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        System.out.println(this.var + "번 스레드 종료되었습니다.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {  // 스레드를 생성하여 실행합니다.
            Thread threading = new Thread(new ThreadingInterface(i));
            threading.start();
        }
        System.out.println("main 메소드가 종료되었습니다.");
    }
}
```

run 메소드를 굳이 구현할 필요가 없는 Thread 클래스와 달리, Runnable 인터페이스는 run() 메소드를 반드시 구현해야 합니다.

---

## 스레드의 상태

스레드의 상태는 getState() 메소드를 통해 확인할 수 있고, 6개의 상태를 가지고 있습니다.

| 상태 | 열거 상수 | 설 |
| --- | --- | --- |
| 객체 생성 | NEW | 쓰레드 객체가 생성, 아직 start() 메소드가 호출되지 않은 상태 |
| 실행 대기 | RUNNABLE | 실행 상태로 언제든지 갈 수 있는 상태 |
|  | WAITING | 다른 쓰레드가 통지할 때까지 기다리는 상태 |
| 일시 정지 | TIME_WAITING | 주어진 시간 동안 기다리는 상태 |
|  | BLOCKED | 사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태 |
| 종료 | TERMINATED | 실행을 마친 상태 |

---

## 스레드의 우선순위

Java에서 스레드 생성시 우선순위가 할당되는데, 우선순위는 JVM에서 제공하거나 사용자가 명시할 수 있습니다.

스레드의 우선 순위는 각 스레드가 우선 순위를 갖는 개념으로, 1과 10 사이의 자연수로 순위를 표현합니다. 

또한, Java는 철저히 우선순위에 의해 스레드를 실행되는 것이 아닌, JVM에게 추천하는 것이므로, 우선순위가 높다고 반드시 먼저 실행되는 것은 아닙니다.

기본적으로 Thread 클래스에는 다음과 같이 상수(static final)가 정의되어 있습니다.

```java
public static int NORM_PRIORITY = 5;
public static int MIN_PRIORITY = 1;
public static int MAX_PRIORITY = 10;
```

setPriority 메소드를 통해 우선순위를 수정할 수 있고, getPriority 메소드로 해당 우선순위를 받을 수 있습니다.

```java
package WEEK10.Threading;

public class ThreadPriority extends Thread {
    int var;

    public ThreadPriority(int var) {
        this.var = var;
    }

    public void run() {
        System.out.println(this.var + "번 스레드 시작되었습니다. 우선순위: " + this.getPriority());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println(this.var + "번 스레드 종료되었습니다. 우선순위: " + this.getPriority());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {  // 스레드를 생성하여 실행합니다.
            Thread threading = new ThreadPriority(i);
            threading.setPriority(i+1);
            threading.start();
        }
        System.out.println("main 메소드가 종료되었습니다.");
    }
}
```

---

## Main 스레드

Java는 다중 스레드 프로그래밍을 지원합니다. Java는 시작과 동시에 하나의 스레드가 즉시 동작하게 되는데, 이를 메인 스레드(Main thread)라고 합니다.

메인 스레드는 다음과 같은 특징을 가집니다.

- 메인 스레드로부터 다른 자식 스레드(Child thread)가 생성된다.
- 다양한 종료 작업을 수행하므로, 마지막으로 실행 종료되는 스레드이다.

```java
package WEEK10.MainThread;

public class MainExample extends Thread {

    public MainExample() { }

    public void run() {
        System.out.println("newThread 메소드 시작 - 새로운 스레드에서 실행됩니다.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("newThread 메소드 종료 - 새로운 스레드에서 실행됩니다.");
    }

    public static void main(String[] args) {
        System.out.println("메인 메소드 시작 - 메인 스레드에서 실행됩니다.");

        // 새로운 스레드 생성 및 시작
        Thread newThread = new MainExample();
        newThread.start();

        System.out.println("메인 메소드 종료 - 메인 스레드에서 실행됩니다.");
    }
}
```

이름이 비슷하여, main 메소드와 main 스레드가 혼동될 수 있는데, main 메소드는 실행 진입점이므로, main 스레드가 main 메소드를 내부에서 실행합니다. 또한, main 스레드 내에 위와 같이 스레드를 추가하였다면, main 스레드 내에서 해당 스레드가 실행되게 됩니다.

---

## 동기화

같은 계좌로 연동된 두 개의 카드를 사용한다고 가정할 때, 한 카드에서 돈을 사용하면 다른 카드에서도 마찬가지로 해당 금액만큼 돈이 빠져있을 것입니다.

멀티스레딩의 경우도 마찬가지로, 동시에 일을 처리하고 있는 것이기 때문에 만약 한 스레드에서 변경한 값이 다른 스레드에서 반영되지 않았다면 문제가 발생할 수 있습니다.

동기화는 위의 문제점을 해결해줄 수 있습니다.

```java
public class SynchronizationExample {
    private static int sharedResource = 0;

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    incrementSharedResource();
                    System.out.println(Thread.currentThread().getName() + " - Shared Resource: " + sharedResource);
                    decrementSharedResource();
                }
            }
        };

        // 여러 스레드 생성
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // 스레드 시작
        thread1.start();
        thread2.start();
    }

    // 공유 자원 증가 메소드
    private synchronized static void incrementSharedResource() {
        sharedResource++;
    }

    // 공유 자원 감소 메소드
    private synchronized static void decrementSharedResource() {
        sharedResource--;
    }
}
```

위와 같이 동기화를 통해, 한쪽에서 값을 변경하여도 다른 스레드도 그 값이 반영됩니다.

다만, 동기화는 모든 스레드를 간섭하는 작업이므로 필요 이상으로 동기화를 할 경우 프로그램이 무거워질 수 있습니다.

---

## 데드락

데드락(Deadlock)은 멀티스레드나 멀티프로세스 환경에서 발생하는 동기화 문제 중 하나로, 두 개 이상의 스레드나 프로세스가 서로 필요한 자원을 얻기 위해 대기하면서 무한히 기다리는 상황을 의미합니다. 이러한 상황에서는 더 이상 어떤 스레드나 프로세스도 진행할 수 없게 되어 시스템이 lock 상태에 빠지게 됩니다.

다음 4개의 상황이 모두 충족될 경우, 데드락에 걸리게 됩니다.

1. **상호 배제 (Mutual Exclusion)**: 리소스(자원)는 한 번에 하나의 프로세스나 스레드에 의해서만 사용
2. **점유와 대기 (Hold and Wait)**: 프로세스나 스레드가 최소한 하나의 리소스를 점유한 상태에서 다른 프로세스나 스레드에 의해 사용되는 리소스를 대기
3. **비선점 (No Preemption)**: 다른 프로세스나 스레드가 이미 점유한 리소스를 선점할 수 없음. 리소스는 해당 프로세스나 스레드가 명시적으로 해제할 때까지 해당 프로세스나 스레드에 의해서만 해제
4. **순환 대기 (Circular Wait)**: 두 개 이상의 프로세스나 스레드가 서로가 점유한 리소스를 대기하는 상황이 순환적으로 발생.

데드락은 프로그램이 무한 루프에 빠지거나, 응답 없음 상태에 빠지는 등의 심각한 문제를 일으킬 수 있으므로, 데드락이 발생하지 않게 프로그래밍을 설계하여야 합니다.

자바에서 데드락을 피하는 방법에는 다음과 같습니다.

1. **자원의 순서화 (Resource Ordering)**: 스레드가 여러 자원을 요청할 때, 일정한 순서로 자원을 요청.
2. **시간 제한 (Timeout)**: 자원을 얻지 못한 상태가 일정 시간을 초과하면 자원을 다시 반환하고 다시 시도.
3. **자원 해제 (Resource Release)**: 자원을 더 이상 사용하지 않을 때는 반드시 해제.
