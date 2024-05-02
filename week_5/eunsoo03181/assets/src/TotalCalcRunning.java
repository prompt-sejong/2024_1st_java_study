package WEEK05;

public class TotalCalcRunning {
    public static void main(String[] args) {
        TotalCalc tc = new TotalCalc();

        int[] values1 = {1, 2, 3};
        int[] values2 = {1, 2, 3, 4, 5};

        System.out.println("sum1의 values1 결과: " + tc.sum1(values1));
        System.out.println("sum2의 values1 결과: " + tc.sum2(values1));
        System.out.println("sum1의 values2 결과: " + tc.sum1(values2));
        System.out.println("sum2의 values2 결과: " + tc.sum2(values2));
    }
}
