package WEEK09.ExceptionHandling;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            int[] a = new int[5];
            Class class1 = Class.forName("clazz");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위를 초과하였습니다.");
        } catch(ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
