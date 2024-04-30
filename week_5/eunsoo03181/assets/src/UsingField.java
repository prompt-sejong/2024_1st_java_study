package WEEK05;

public class UsingField {
    public static void main(String[] args) {
        FieldClass a = new FieldClass();
        System.out.println(a.code);
        if (a.isAbolished) System.out.println("이 학교는 폐교되었습니다.");
        else System.out.println("이 학교는 운영 중입니다.");

        a.isAbolished = true;
        if (a.isAbolished) System.out.println("이 학교는 폐교되었습니다.");
        else System.out.println("이 학교는 운영 중입니다.");
    }
}
