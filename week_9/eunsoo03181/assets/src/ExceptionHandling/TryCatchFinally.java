package WEEK09.ExceptionHandling;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[5] = 5;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위를 초과하였습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
