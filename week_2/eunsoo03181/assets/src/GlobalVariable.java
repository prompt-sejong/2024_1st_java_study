package WEEK02;

public class GlobalVariable {
    // 클래스 변수를 선언합니다.
    public static int class_var;

    // 인스턴스 변수를 선언합니다.
    int instance_var;

    public static void main(String[] args) {
        // 객체를 생성합니다.
        GlobalVariable obj = new GlobalVariable();

        // 지역 변수를 선언합니다.
        int local_var = 0;

        // 값을 출력합니다.
        System.out.println("class_var = " + class_var);
        System.out.println("instance_var = " + obj.instance_var);
        System.out.println("local_var = " + local_var);
    }
}