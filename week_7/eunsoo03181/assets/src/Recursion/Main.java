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
