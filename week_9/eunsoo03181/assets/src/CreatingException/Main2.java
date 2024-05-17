package WEEK09.CreatingException;

public class Main2 {
    public static void main(String[] args) {
        try {
            throw new CannotCreateException(null);
        } catch(CannotCreateException e) {

        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
