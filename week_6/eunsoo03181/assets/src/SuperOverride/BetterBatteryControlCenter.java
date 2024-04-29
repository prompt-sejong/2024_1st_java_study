package WEEK06.SuperOverride;

public class BetterBatteryControlCenter extends BatteryControlCenter {
    boolean fastCharge = true;
    boolean batteryCare = false;
    int batteryMode = 1;

    // 배터리 사용 상태
    String batteryUsingStatus () {
        switch (batteryMode) {
            case 1:
                return "저전력";

            case 2:
                return "최적화";

            case 3:
                return "고성능";

            case 4:
                return "최고 성능";

            default:
                batteryMode = 2;
                return "최적화";
        }
    }

    // 배터리 사용 모드
    void batteryUsingMode () {
        System.out.println("배터리 사용 모드를 선택해주세요.");
        System.out.println("현재 사용 모드: " + batteryUsingStatus());
        System.out.println("1. 저전력\n2. 최적화 \n3. 고성능\n4. 최고 성능");
        batteryMode = sc.nextInt();
        System.out.println(batteryUsingStatus() + "으로 설정되었습니다.");
    }

    // 고속 충전 모드
    void fastChargeMode () {
        if (battery >= 80 && fastCharge) {
            System.out.println("배터리 보호를 위해, 고속 충전을 중단합니다.");
            fastCharge = false;
        }
        if (battery < 80 && !fastCharge) {
            System.out.println("빠른 충전을 위해, 고속 충전을 시작합니다.");
            fastCharge = true;
        }
    }

    // 배터리 절약 모드
    void batteryCareMode () {
        if (battery <= 20 && !batteryCare) {
            System.out.println("배터리가 부족하여 배터리 절약 모드가 활성화됩니다.");
            batteryCare = true;
        }
        if (battery > 30 && batteryCare) {
            System.out.println("배터리가 충분히 충전되어, 배터리 절약 모드가 비활성화됩니다.");
        }
    }

    @Override // 배터리 고속 충전
    void chargeBattery() {
        if (!fastCharge) {
            super.chargeBattery();
        }
        else {
            System.out.println("고속 충전 중입니다.");
            battery += 3;
        }
    }

    @Override // 배터리 사용량 조율
    void useBattery() {
        if (batteryMode == 1) {
            super.useBattery();
        }
        else if (batteryMode == 2) {
            if (battery >= 2) {
                System.out.println("배터리를 사용하였습니다.");
                battery -= 2;
            }
            else {
                System.out.println("배터리가 부족합니다. 충전이 필요합니다.");
            }
        }
        else if (batteryMode == 3) {
            if (battery >= 3) {
                System.out.println("배터리를 사용하였습니다.");
                battery -= 3;
            }
            else {
                System.out.println("배터리가 부족합니다. 충전이 필요합니다.");
            }
        }
        else {
            if (battery >= 4) {
                System.out.println("배터리를 사용하였습니다.");
                battery -= 4;
            }
            else {
                System.out.println("배터리가 부족합니다. 충전이 필요합니다.");
            }
        }
    }
}
