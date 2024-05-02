package WEEK04;
import java.util.Scanner;

public class WhileRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p;
        while(true) {
            System.out.println("5 + 5 = ?");
            System.out.println(">> ");
            p = sc.nextInt();

            if (p == 10) {
                System.out.println("정답입니다.");
                break;
            }
            System.out.println("오답입니다.");
        }

        do {
            System.out.println("일단 실행하고 반복할지는 나중에.");
        } while (false);
    }
}
