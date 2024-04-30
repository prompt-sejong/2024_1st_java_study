package WEEK02;

public class OperatorPromotion {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a/b);
        System.out.println((double)a/b);

        byte c = 3 + 3;

        // 정수형 변수끼리의 계산은 모두 int이므로, 오류가 발생합니다: byte d = c + c;
    }
}