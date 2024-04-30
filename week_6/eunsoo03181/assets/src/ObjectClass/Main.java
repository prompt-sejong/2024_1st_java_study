package WEEK06.ObjectClass;

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        // 둘이 같은 결과를 반환합니다.
        boolean result1 = obj1.equals(obj2);
        boolean result2 = (obj1 == obj2);

        System.out.println(result1 + " " + result2 + "\n");

        // String 클래스는, equals() 메소드를 오버라이딩합니다.
        String s1 = "Hello";
        String s2 = "Hello";
        boolean result3 = s1.equals(s2);
        boolean result4 = (s1 == s2);
        System.out.println(result3 + " " + result4);
        System.out.println();

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());

        // String 클래스는, toString() 메소드를 오버라이딩합니다.
        String str1 = "Hello, World!";
        System.out.println(str1.toString());

        Overriding ov = new Overriding("Hello", "World!");
        String str2 = ov.toString();
        System.out.println(str2);
    }
}
