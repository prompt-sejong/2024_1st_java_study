package WEEK02;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        // 2개의 행과 3개의 열로 구성된 2차원 배열을 생성합니다.
        int[][] multi_arr = new int[3][4];

        // 배열의 길이를 출력합니다.
        System.out.println(multi_arr.length);
        System.out.println(multi_arr[0].length);
        System.out.println(multi_arr[1].length);
        System.out.println(multi_arr[2].length);
    }
}