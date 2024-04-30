package WEEK05;

public class TotalCalc {
    int sum1(int[] values) {
        int sum = 0;
        for (int i: values) sum += i;
        return sum;
    }
    int sum2 (int ... values) {
        int sum = 0;
        for (int i : values) sum += i;
        return sum;
    }
}
