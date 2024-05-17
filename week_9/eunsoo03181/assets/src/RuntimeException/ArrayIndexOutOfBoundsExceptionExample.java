package WEEK09.RuntimeException;

public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i=0; i<6; i++) arr[i] = i;
    }
}
