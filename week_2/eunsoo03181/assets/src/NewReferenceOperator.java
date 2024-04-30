package WEEK02;

public class NewReferenceOperator {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = new String("Hello, World!");
        System.out.println("str1과 str2는 같은 값을 참조합니까? " + (str1 == str2));
    }
}