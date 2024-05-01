package DataStructure.TimeComplexity;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int result1 = GetTotal.getSum1(input);
        int result2 = GetTotal.getSum2(input);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
    }
}
