package WEEK04;
import java.util.Scanner;

public class IfCondition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        if (p % 2 == 0) {
            System.out.println("입력한 수는 짝수입니다.");
        } else {
            System.out.println("입력한 수는 홀수입니다.");
        }
    }
}
