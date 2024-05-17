package WEEK09.ExceptionHandling;

public class CatchSequence {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 유효 범위를 초과하였습니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 문제가 발생하였습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
