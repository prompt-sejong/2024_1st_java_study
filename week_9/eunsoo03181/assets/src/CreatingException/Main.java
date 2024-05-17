package WEEK09.CreatingException;

public class Main {
    public static void main(String[] args) {
        try {
            throw new NonExistException();
        } catch(NonExistException e) {
            System.out.println("해당 사용자가 없습니다.");
        } finally {
                System.out.println("프로그램을 종료합니다.");
        }
    }
}
