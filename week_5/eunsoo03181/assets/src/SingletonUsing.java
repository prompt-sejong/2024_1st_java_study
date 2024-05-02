package WEEK05;

public class SingletonUsing {
    // 컴파일 에러 Singleton st1 = new Singleton();
    public static void main(String[] args) {
        Singleton st1 = Singleton.getInstance();
        Singleton st2 = Singleton.getInstance();

        if (st1 == st2) {
            System.out.println("st1과 st2는 동일한 객체입니다.");
        }
        else {
            System.out.println("st1과 st2는 다른 객체입니다.");
        }
    }
}
