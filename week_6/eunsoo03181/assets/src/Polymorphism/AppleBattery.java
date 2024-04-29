package WEEK06.Polymorphism;

public class AppleBattery extends Battery {
    AppleBattery(int batteryChargeCycle, String brand) {
        super(batteryChargeCycle, brand);
    }

    @Override
    boolean batteryCharge() {
        batteryStatusCycle++;
        if (batteryChargeCycle > batteryStatusCycle) {
            System.out.println("배터리 성능: " + (((double)batteryChargeCycle - (double)batteryStatusCycle)/(double)batteryChargeCycle)*100 + "%\n충전 순환 횟수: " + batteryStatusCycle);
            return true;
        }
        else {
            System.out.println("기기가 더 많은 일을 해낼 수 있게, 근처 애플 공식 수리점으로 가 배터리를 교체해주세요.");
            return false;
        }
    }
}
