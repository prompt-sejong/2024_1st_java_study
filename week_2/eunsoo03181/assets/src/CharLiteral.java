package WEEK02;

public class CharLiteral {
    public static void main(String[] args) {
        // char은 정수인 유니코드를 저장하는 변수입니다. 10진수 또는 16진수 형태로도 저장할 수 있습니다.

        // 작은따옴표 사이에 문자를 넣어 표시할 수 있습니다.
        char var1 = 'A';
        char var2 = 65;
        char var3 = 0x0041;

        System.out.println("var1 = " + var1 + ", var2 = " + var2 + ", var3 = " + var3);
    }
}