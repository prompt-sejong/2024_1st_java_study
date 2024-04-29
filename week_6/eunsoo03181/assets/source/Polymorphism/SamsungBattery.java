package WEEK06.Polymorphism;

public class SamsungBattery extends Battery {
    SamsungBattery(int batteryChargeCycle, String brand) {
        super(batteryChargeCycle, brand);
    }

    @Override
    boolean batteryCharge() {
        batteryStatusCycle++;
        if (batteryChargeCycle > batteryStatusCycle) {
            System.out.println("남은 충전 싸이클: " + (batteryChargeCycle - batteryStatusCycle) + "회");
            return true;
        }
        else {
            System.out.println("배터리에 이상이 발견되었습니다. 가까운 대리점으로 가 배터리를 교체해주십시오.");
            return false;
        }
    }
}
