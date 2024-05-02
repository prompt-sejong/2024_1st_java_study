package WEEK03;

public class UnaryOperator {
    public static void main(String[] args) {
        int var1 = 3;
        boolean isTrue = true;
        // 부호 연산자는 피연산자의 부호를 유지하거나 변경합니다.
        int var2 = +var1;
        int var3 = -var1;
        System.out.println("var2 = " + var2 + " ,var3 = " + var3);

        // 증감 연산자는 변수의 값을 1 증감시킵니다.
        int var4 = var1++ + 10;
        int var5 = ++var2 + 10; // var1의 값이 변동이 생기기 때문에, 동일한 값인 var2로 대체합니다.
        System.out.println("var4 = " + var4 + ", var5 = " + var5);

        // 논리 부정 연산자는 true를 false로, false를 true로 변경합니다.
        boolean isFalse = !isTrue;
        System.out.println("isFalse = " + isFalse);
    }
}
