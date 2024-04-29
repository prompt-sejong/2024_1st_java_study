package WEEK06.SuperOverride;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // tablet 객체 생성
        BatteryControlCenter oldTablet = new BatteryControlCenter();
        BetterBatteryControlCenter newTablet = new BetterBatteryControlCenter();

        System.out.println("배터리 관리 프로그램을 실행합니다.");
        while (true) {
            System.out.println("설정할 태블릿을 선택해주세요.");
            System.out.println("1. 구형 태블릿\n2. 신형 태블릿\n3. 종료");
            int tablet = sc.nextInt();
            if (tablet == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            while (true) {
                oldTablet.setBattery();
                newTablet.setBattery();

                System.out.println("모드를 선택해주세요.");
                if (tablet == 2) System.out.println("0. 배터리 사용 모드 설정");
                System.out.println("1. 배터리 사용");
                System.out.println("2. 배터리 충전");
                System.out.println("3. 배터리 상태");
                System.out.println("4. 태블릿 변경");
                int mode = sc.nextInt();

                if (mode == 4) {
                    System.out.println("태블릿 변경 화면으로 이동합니다.");
                    break;
                }


                if (tablet == 1) {
                    switch (mode) {
                        case 1:
                            oldTablet.useBattery();
                            break;

                        case 2:
                            oldTablet.chargeBattery();
                            break;

                        case 3:
                            oldTablet.statusQuoBattery();
                            break;

                        default:
                            System.out.println("오류 발생. 처음부터 다시 시도해주세요.");
                            break;
                    }
                }
                else {
                    switch (mode) {
                        case 0:
                            newTablet.batteryUsingMode();
                            break;

                        case 1:
                            newTablet.batteryCareMode();
                            newTablet.useBattery();
                            break;

                        case 2:
                            newTablet.fastChargeMode();
                            newTablet.chargeBattery();
                            break;

                        case 3:
                            newTablet.statusQuoBattery();
                            break;

                        default:
                            System.out.println("오류 발생. 처음부터 다시 시도해주세요.");
                            break;
                    }
                }
                System.out.println();
            }
        }


    }
}
