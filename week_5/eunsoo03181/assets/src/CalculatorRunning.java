package WEEK05;
import java.util.Scanner;

public class CalculatorRunning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator c1 = new Calculator();
        while (c1.isActivated) {
            System.out.print("첫 번째 정수를 입력해주세요: ");
            c1.input1 = sc.nextInt();
            System.out.print("두 번째 정수를 입력해주세요: ");
            c1.input2 = sc.nextInt();
            System.out.print("원하는 모드를 선택해주세요.\n1. 더하기\n2. 빼기\n3. 곱하기\n4. 종료\n");
            int mode = sc.nextInt();

            switch (mode) {
                case 1:
                    System.out.println("두 값을 더한 값은 " + c1.getPlus() + "입니다.");
                    break;

                case 2:
                    System.out.println("두 값을 뺀 값은 " + c1.getMinus() + "입니다.");
                    break;

                case 3:
                    System.out.println("두 값을 곱한 값은 " + c1.getMulti() + "입니다.");
                    break;

                case 4:
                    System.out.println("계산기를 종료합니다.");
                    c1.powerOff();
                    break;

                default:
                    System.out.println("잘못된 값을 입력했습니다. 처음부터 다시 시도해주십시요.");
            }
        }
    }
}
