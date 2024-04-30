package WEEK02;

public class StringArrayReference {
    public static void main(String[] args) {
        String[] str_arr = new String[3];
        str_arr[0] = "Hello, World!";
        str_arr[1] = "Hello, World!";
        str_arr[2] = new String("Hello, World!");

        // '=='는 같은 객체를 참조하면 true 아니면 false를 출력합니다.
        System.out.println(str_arr[0] == str_arr[1]);
        System.out.println(str_arr[0] == str_arr[2]);

        // equals() 메소드는 두 문자열이 동일할 경우 true, 아니면 false를 출력합니다.
        System.out.println(str_arr[0].equals(str_arr[2]));
    }
}