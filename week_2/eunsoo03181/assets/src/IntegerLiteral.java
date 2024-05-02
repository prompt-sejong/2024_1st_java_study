package WEEK02;

public class IntegerLiteral {
    public static void main(String[] args) {

        // 2진수: 0b 또는 0B로 시작하고, 0과 1로 구성됩니다.
        int var1 = 0b1001;

        // 8진수: 0으로 시작하고, 0~7 숫자로 구성됩니다.
        int var2 = 0224;

        // 10진수: 소수점이 없는 0~9 숫자로 구성됩니다.
        int var3 = 1315;

        // 16진수: 0x 또는 0X로 시작하고, 0~9 숫자와, A, B, C, D, E, F 또는 a, b, c, d, e, f로 구성됩니다.
        int var4 = 0xB3;

        // 네 개의 변수를 출력합니다.
        System.out.printf("%d %d %d %d", var1, var2, var3, var4);
    }
}