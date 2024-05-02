package WEEK02;

public class ReferenceOperator {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = arr1;

        System.out.println(arr1 == arr2);

        arr1[0] = "A";
        arr1[1] = "B";
        arr1[2] = "C";

        // arr1과 arr2의 참조하는 값이 같으므로, arr1이 수정될 경우, arr2도 함께 수정됩니다.
        System.out.println(arr2[0] + arr2[1] + arr2[2]);
    }
}