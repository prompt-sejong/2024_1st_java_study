package WEEK05;
import java.util.Scanner;

public class AccessModifierUsing {
    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        Scanner sc = new Scanner(System.in);
        int mode = 0;
        while (true) {
            System.out.print("모드를 선택해주세요.\n1. 실행\n2. 값 수정\n3. 종료\n");
            mode = sc.nextInt();

            switch (mode) {
                case 1:
                    System.out.print("두 값의 합은 ");
                    am.printResult();
                    System.out.println("입니다.");
                    break;
                case 2:
                    System.out.print("첫 번째 값을 입력해주세요: ");
                    int a = sc.nextInt();
                    System.out.print("두 번째 값을 입력해주세요: ");
                    int b = sc.nextInt();
                    am.modifyInputs(a, b);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.\n");
            }
            System.out.println();
        }
    }
}
