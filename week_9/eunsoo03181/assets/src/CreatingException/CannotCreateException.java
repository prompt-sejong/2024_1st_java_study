package WEEK09.CreatingException;

public class CannotCreateException extends Exception {
    public CannotCreateException(String message) {
        super(message);
        System.out.println("해당 이름으로 계정을 생성할 수 없습니다.");
    }
}
