package WEEK06.Override;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름을 입력해주세요: ");
        double input = sc.nextDouble();

        // 객체를 선언합니다.
        BetterCircle bc = new BetterCircle(input);

        // 오버라이드된 메소드가 호출됩니다.
        System.out.println(bc.getArea());
    }
}
