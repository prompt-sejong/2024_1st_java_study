# 1. 자료구조와 시간 복잡도

## 개요

자료구조(Data Structure)란, 개발자가 데이터를 효율적으로 사용할 수 있도록 정리하는 방법을 의미합니다. 자료구조로는 배열, 리스트, 트리, 그래프 등이 있으며, 상황에 따라 이들의 효율이 다를 수 있으므로, 자료구조의 장단점을 파악하고 상황에 맞는 최적의 자료구조를 사용할 수 있어야 합니다.
<br/>

---

## 추상 자료형

추상 자료형(ADT: Abstract Data Type)란, 자료들과 그 자료들에 대한 연산들을 명기한 것으로, 구현 방법을 직접 명시하지 않으므로 자료구조와 차이를 보입니다. 이는 자료형과 조작을 표현한 것이기 때문에, 데이터의 실제 표현과 구현이 정해지지 않은 것입니다. Java에서는 인터페이스(Interface) 또는 클래스(Class)로 구현됩니다.
<br/>

---

## 시간 복잡도

시간 복잡도란, 프로그램에서 입력값과 연산 수행간의 상관 관계를 나타내는 척도입니다. 그 중 Big-O 계산법은 코드에서 최악의 결과일 때를 상정하여 시간 복잡도를 계산합니다.

Big-O 표기는, 다음과 같은 모습을 하며, 가장 영향력이 큰 문자만 적습니다. 예를 들어, 시간 복잡도가 O(2n! + 5n)인 경우, O(n!)으로 표기합니다.
<br/>

**상수 시간 - O(1)**

프로그램을 실행할 때 오로지 한 작업만 실행합니다.


**로그 시간 - O(log n)**

프로그램을 실행할 때, 필요한 연산이 특정 원인에 따라 감소합니다. 이때, log n은 상용로그가 아닌 밑이 2인 log입니다.

**직선 시간 - O(n)**

프로그램을 실행할 때, 단계의 수와 입력값이 1:1입니다. 실생활에서 예를 든다면, 101동에 사는 친구집의 ‘호 수’를 찾기 위해서는 최악의 경우 N번동안 집을 찾아야 합니다. 이를 O(n)으로 나타낼 수 있습니다.

**선형로그 시간 - O(n log n)**

퀵 정렬과 같은 방식이 위와 같은 방식을 따릅니다.

**다차 시간 - O(n^c)**

프로그램을 실행할 때, 단계의 수와 입력값이 c제곱에 비례합니다. 실생활에서 예를 든다면, 1단지에 사는 친구의 집에 가기 위해서는 N번동안 친구가 사는 동을 찾아야 하고, N번동안 친구가 사는 호를 찾아야 합니다. 즉, N^2의 실행 횟수가 발생하므로, O(n^2)이 됩니다.

**지수 시간 - O(2^n)**

c^n은 2^log₂c^n이기 때문에, 주로 2^n으로 표기합니다. 재귀함수의 호출시 자주 가지게 되는 시간 복잡도입니다.

**계승 시간 - O(n!)**

매우 비효율적인 코드로, n팩토리얼을 구하는 함수를, 재귀 함수로 만들 경우 구현할 수 있습니다.

유의할 것은 시간 복잡도가 작은 것이 반드시 좋은 코딩이라고 보장할 수 없다는 점입니다. 시간 복잡도가 작을수록 프로그램의 실행이 빨라지고 정확해지지만 코드의 가독성과 유지 보수성이 훼손될 수 있어 실제로 코드를 설계할 때는 시간 복잡도 뿐만 아니라 가독성과 유지 보수성을 고려하는 것을 권장합니다.

```Java
package DataStructure.TimeComplexity;

public class GetTotal {

    static int cnt;

    public static int getSum1(int n) {
        int result = 0;
        cnt = 0;
        System.out.println("=== getSum1 함수 연산 시작 ===");
        for (int i=1; i<=n; i++) {
            cnt++;
            System.out.println(cnt + "번째 연산.");
            result += i;
        }
        System.out.println("=== getSum1 함수 연산 종료 ===\n");
        return result;
    }

    public static int getSum2(int n) {
        cnt = 0;
        cnt++;
        System.out.println("=== getSum2 함수 연산 시작 ===");
        System.out.println(cnt + "번째 연산.");
        System.out.println("=== getSum2 함수 연산 종료 ===\n");
        return n*(n+1)/2;
    }
}
```
```Java
package DataStructure.TimeComplexity;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int result1 = GetTotal.getSum1(input);
        int result2 = GetTotal.getSum2(input);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
    }
}
```

getTotal 클래스 안에는 두 개의 메소드가 있으며, 둘 다 주어진 변수 input에 대하여 1부터 input까지의 합을 시행하는 중 연산 횟수를 출력하고, 그 정답 반환합니다. 둘은 같은 값을 반환하지만, getSum1은 input번의 연산을, getSum2는 1번의 연산을 합니다. 즉, getSum1의 시간 복잡도는 O(n), getSum2의 시간 복잡도는 O(1)임을 알 수 있습니다.

둘 중 효율적인 코드는 getSum2이지만, 코드를 처음 본 사람이라면, getSum1의 가독성과 직관성이 더 높을 것입니다. 위의 코드는 단순하여, 큰 차이가 없을 수도 있지만, 가독성과 직관성은 유지 보수성에 이어지므로, 이들을 모두 고려하여 프로그램을 설계할 필요가 있습니다.
