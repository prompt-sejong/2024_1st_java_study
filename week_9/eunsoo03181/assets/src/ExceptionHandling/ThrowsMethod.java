package WEEK09.ExceptionHandling;

public class ThrowsMethod {
    public static void method() throws Exception {
        System.out.println("오류를 떠넘깁니다.");
    }

    public static void main(String[] args) {
        try {
            method();
        } catch(Exception e) {
            System.out.println("알 수 없는 문제가 발생하였습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}


