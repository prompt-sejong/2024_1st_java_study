# 2. 순환

## 개요

순환(Recursion)이란, 알고리즘이나 함수(메소드)가 자신을 호출하여 문제를 해결하는 프로그래밍 기법입니다. 순환은 독특한 개념적인 프레임 워크를 제공하며, 자료구조를 다루는 프로그램에 적합합니다.

---

## 재귀 함수

재귀 함수(Recursion Function)은 자기 자신을 호출하는 함수입니다. 재귀 함수는 자신을 반복적으로 호출함으로써, 원하는 결과를 도출해낼 수 있습니다.

그러나, 재귀 함수는 여러번 호출하기에 시간 복잡도가 크다는 단점이 있습니다. 보통, 중복되는 계산을 줄이기 위해, 메모이제이션(memoization)을 이용합니다. 메모이제이션은, 한 번 계산한 결과를 메모리에 저장하였다가 꺼내써 중복 계산을 방지하는 방식입니다.

---

## 거듭제곱 계산

p의 n제곱을 구하는 방법은 p를 n번 곱하여 값을 반환하는 것입니다. Java에서는 pow() 메소드가 제공되지만, 순환을 이용하여 값을 구할 수 있습니다.

```Java
package DataStructure.Recursion;

public class GetPower {
    public static double getPower(double p, int n) {
        Main.cnt++;
        if (n==0) return 1;
        else return p*getPower(p, n-1);
    }
}
```

재귀를 이용할 경우 시간 복잡도는 O(n)입니다. 일반적으로 pow() 메소드의 시간 복잡도가 O(log n)인 것을 비교했을 때, 거듭제곱 계산은 pow() 메소드를 이용하는 것이 효율 측면에서는 좋습니다.

---

## 하노이 탑

하노이 탑은 3개의 기둥에 적당한 개수의 원반을 쌓아 놓고 다른 쪽으로 옮기는 게임입니다. 하노이 탑은 한 번에 하나의 원반만 옮길 수 있고, 큰 원반을 작은 원반 위에 놓을 수 없다는 규칙이 있습니다.

하노이 탑의 기본적인 원리는 n개의 원반 중, 크기가 가장 큰 원반을 제외한 n-1개의 원반을 목표 기둥이 아닌 곳으로 옮기고, 이후, n개의 원반을 목표 기둥으로 옮기는 작업을 반복하는 것입니다.

순환을 통해, 다음과 같이 하노이탑을 구현할 수 있습니다.

```Java
package DataStructure.Recursion;

public class HanoiTower {
    int n = 3; // 탑의 원반 개수
    int fromRod = 1; // 시작 기둥
    int toRod = 3; // 목표 기둥
    int auxRod = 2; // 보조 기둥



    public static void solveHanoi(int n, int fromRod, int toRod, int auxRod) {
        Main.cnt++;
        if (n == 1) {
            System.out.println("1번 원반을 " + fromRod + "번 기둥에서 " + toRod + "번 기둥으로 옮깁니다.");
            return;
        }

        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println(n + "번 원반을 " + fromRod + "번 기둥에서 " + toRod + "번 기둥으로 옮깁니다.");
        solveHanoi(n - 1, auxRod, toRod, fromRod);
        }
}
```

순환을 이용할 경우 시간 복잡도는 O(2^n)입니다. 하노이 탑은 구현할 때마다 3개의 하위 문제로 분할되기 때문입니다.

---

## 피보나치 수열

```Java
package DataStructure.Recursion;

public class FibonacciSequence {
    public static int fibonacci(int n) {
        Main.cnt++;
        if (n==1) return 0;
        else if (n==2) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }
}
```

순환을 이용할 경우 시간 복잡도는 O(2^n)이므로, 위의 코드는 상당히 비효율적인 코딩입니다. 각 메소드가 독특한 값을 가지는 하노이 탑과 달리, 피보나치 수열은 항상 같은 값을 가지기 때문에, 메모이제이션을 통해, 시간 복잡도를 줄일 수 있습니다.

```Java
package DataStructure.Recursion;
import java.util.HashMap;

public class FibonacciSequenceMemo {
    private static HashMap<Integer, Integer> fibo = new HashMap<>();

    public static int fibonacci(int n) {
        Main.cnt++;
        if (n <= 0) return 0;
        else if (n == 1) return 0;
        else if (n == 2) return 1;
        else if (fibo.containsKey(n)) return fibo.get(n);
        else {
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            fibo.put(n, result);
            return result;
        }
    }
}
```

HashMap은 값을 저장하는 자료구조라고 볼 수 있습니다. HashMap은 key 테이블과 value 테이블을 가집니다.

put(key, value)는 key 테이블에 key를 저장하고, 이에 대응하는 value를 value 테이블에 저장하는 역할을 합니다.

containsKey(key)는 해당 key의 이름을 가진 key가 있는지 확인하고, 있다면 true 없으면 false를 반환합니다.

get(key)는 해당 key에 대응하는 value를 반환합니다.

위의 프로그램을 실행할 경우, 시간 복잡도를 O(n)으로 줄일 수 있습니다.

```Java
package DataStructure.Recursion;
import static java.lang.Math.pow;

public class Main {
    public static int cnt = 0; // 연산 횟수

    public static void main(String[] args) {
        System.out.println("===== 거듭제곱 구하기 =====");
        System.out.println(GetPower.getPower(2,10) + "(연산 횟수: " + cnt + ")");
        System.out.println(pow(2,10));
        System.out.println();

        System.out.println("======= 하노이 탑 ======="); cnt = 0;
        HanoiTower.solveHanoi(7, 1, 3, 2);
        System.out.println("(연산 횟수: " + cnt + ")\n");

        System.out.println("======= 피보나치 수열 ======="); cnt = 0;
        for (int i = 1; i<=10; i++) System.out.print(FibonacciSequence.fibonacci(i) + " ");
        System.out.println();
        System.out.println("(연산 횟수: " + cnt + ")\n");

        System.out.println("== 메모이제이션 피보나치 수열 =="); cnt = 0;
        for (int i=1; i<=10; i++) System.out.print(FibonacciSequenceMemo.fibonacci(i) + " ");
        System.out.println("(연산 횟수: " + cnt + ")\n");
    }
}
```
