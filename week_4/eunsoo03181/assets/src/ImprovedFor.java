package WEEK04;

public class ImprovedFor {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i * 2;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}
