package WEEK06.ObjectClass;

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        // 둘이 같은 결과를 반환합니다.
        boolean result1 = obj1.equals(obj2);
        boolean result2 = (obj1 == obj2);

        System.out.println(result1 + " " + result2 + "\n");

        String s1 = "Hello";
        String s2 = "Hello";
        boolean result3 = s1.equals(s2);
        boolean result4 = (s1 == s2);
        System.out.println(result3 + " " + result4);
    }
}
