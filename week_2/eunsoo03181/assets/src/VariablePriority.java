package WEEK02;

public class VariablePriority {
    static int var1 = 5;
    public static void main(String[] args) {
        int var1 = 10;

        // 지역 변수가 우선적으로 호출됩니다.
        System.out.println(var1);

        // 클래스 변수를 호출하고 싶다면 다음과 같이 호출합니다.
        System.out.println(VariablePriority.var1);
    }
}