package WEEK06.Inheritance;
import java.util.Scanner;

// 부모 클래스
public class InheritanceBasic {
    protected int a;
    protected int b;

    void printA () {
        System.out.println(a);
    }

    void printB () {
        System.out.println(b);
    }
}

// 자식 클래스
class InheritanceBasic2 extends InheritanceBasic {
    Scanner sc = new Scanner(System.in);
    public int mode;
    private boolean power = true;

    void printUI() {
        System.out.println("모드를 선택해주세요.");
        System.out.println("1. A 출력");
        System.out.println("2. A 수정");
        System.out.println("3. B 출력");
        System.out.println("4. B 수정");
        System.out.println("5. 초기화");
        System.out.println("6. 종료");
        System.out.print(">> ");

        mode = sc.nextInt();
    }

    boolean getPower () {
        return power;
    }

    void modifyA (int a) {
        this.a = a;
    }

    void modifyB (int b) {
        this.b = b;
    }

    void controlCenter(int mode) {
        int newNum;
        switch (mode) {
            case 1:
                System.out.println("A의 값은 다음과 같습니다.");
                printA();
                break;

            case 2:
                System.out.print("수정할 값을 입력해주세요: ");
                newNum = sc.nextInt();
                modifyA(newNum);
                break;

            case 3:
                System.out.println("B의 값은 다음과 같습니다.");
                printB();
                break;

            case 4:
                System.out.print("수정할 값을 입력해주세요: ");
                newNum = sc.nextInt();
                modifyB(newNum);
                break;

            case 5:
                a = 0;
                b = 0;
                System.out.println("A와 B의 값이 초기화되었습니다.");
                break;

            case 6:
                power = false;
                System.out.println("시스템을 종료합니다.");
                break;

            default:
                System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
                break;
        }
    }
}
