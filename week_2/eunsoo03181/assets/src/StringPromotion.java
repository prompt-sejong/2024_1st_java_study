package WEEK02;

public class StringPromotion {
    public static void main(String[] args) {
        String str = "Hello, World!";

        // 문자열은 다른 자료형과의 합은, 다른 자료형을 문자열로 변환합니다.
        System.out.println(str + 5 + 5);

        // (5 + 5)가 연산의 우선순위이므로, 우선 계산 후 문자열로 변환됩니다.
        System.out.println(str + (5 + 5));

        // 곱셈은 덧셈보다 연산에서 우선순위를 가지므로, 우선 계산 후 문자열로 변환됩니다.
        System.out.println(str + 5 * 5);

        // 문자열과의 연산보다 정수들의 덧셈이 우선순위를 가지므로, 우선 계산 후 문자열로 변환됩니다.
        System.out.println(5 + 5 + str);
    }
}