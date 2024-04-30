package WEEK03;

public class BitOperator {
    public static void main(String[] args) {
        int a = 0b1010; // 10진수로 10입니다.
        int b = 0b1100; // 10진수로 12입니다.
        System.out.println("a & b = " + (a & b));
        System.out.println("a | b = " + (a | b));
        System.out.println("a ^ b = " + (a ^ b));
        System.out.println("~a = " + (~a));
    }
}
