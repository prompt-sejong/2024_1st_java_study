package WEEK02;

public class ArrayDeclaration {
    public static void main(String[] args) {
        // 값 목록으로 배열을 생성하는 방법입니다.
        int[] arr1 = {1, 2, 3, 4, 5};

        /* 값 목록으로 배열을 생성한 경우, 이후 중괄호를 이용한 배열 생성이 불가능합니다.
        int[] arr1_;
        arr1_ = {1, 2, 3, 4, 5}; -> 오류 발생.

        문제 해결 방법입니다.*/
        int[] arr1_;
        arr1_ = new int[]{1, 2, 3, 4, 5};

        // new 연산자를 이용하여 배열을 생성하는 방법입니다.
        int[] arr2 = new int[5];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 4;
        arr2[4] = 5;
    }
}