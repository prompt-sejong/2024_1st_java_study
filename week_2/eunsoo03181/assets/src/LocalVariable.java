package WEEK02;

public class LocalVariable {
    public static void main(String[] args) {
        if (true) {
            int i = 2;
        }
        // 출력할 i가 이미 유효 범위를 벗어났으므로 오류가 발생합니다.
        // System.out,println(i);
    }
}