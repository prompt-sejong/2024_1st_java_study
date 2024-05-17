package WEEK09.ExceptionHandling;

public class TryCatchFinally2 {
    public static void main(String[] args) {
        try {
            // SuperOverride.Main 클래스는 WEEK06 패키지 내에 있습니다.
            Class class_ = Class.forName("WEEK09.SuperOverride.Main");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
