package WEEK02;

public class ReferenceLiteral {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "Hello, World!";
        System.out.println("str1과 str2는 같은 값을 참조합니까? " + (str1 == str2));

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("arr1과 arr2는 같은 값을 참조합니까? " + (arr1 == arr2));
    }
}