package WEEK04;
import java.util.Scanner;

public class SwitchCondition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        switch(p) {
            case 1:
                System.out.println("소수도 합성수도 아닌 자연수");
                break;

            case 2:
                System.out.println("가장 작은 소수이자, 소수 중 유일한 짝수");
                break;

            case 3:
                System.out.println("홀수 중 가장 작은 소수");
                break;

            case 4:
                System.out.println("가장 작은 합성수");
                break;

            default:
                System.out.println("평범한 숫자");
                break;
        }
    }
}
