package WEEK02;

public class StringCast {
    public static void main(String[] args) {
        String str = "1";

        // 문자열을 정수로 변환합니다.
        int strToInt = Integer.parseInt(str);

        int inte = 2;

        // 정수를 문자열로 변환합니다.
        String intToStr = String.valueOf(inte);

        // intToStr은 문자열이기 때문에, 3이 아닌, 12가 출력됩니다.
        System.out.println(strToInt + intToStr);
    }
}