package WEEK04;
import java.util.Scanner;

public class ElseIfCondition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        if (p > 0) {
            System.out.println("입력한 수는 양수입니다.");
        } else if (p == 0) {
            System.out.println("입력한 수는 0입니다.");
        } else {
            System.out.println("입력한 수는 음수입니다.");
        }
    }
}
