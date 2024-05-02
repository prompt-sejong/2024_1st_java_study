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
