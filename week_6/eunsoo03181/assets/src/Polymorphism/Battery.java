package WEEK06.Polymorphism;

public class Battery {
    int batteryChargeCycle;
    int batteryStatusCycle;
    String brand;

    Battery(int batteryChargeCycle, String brand) {
        this.batteryChargeCycle = batteryChargeCycle;
        this.brand = brand;
    }

    boolean batteryCharge() {
        batteryStatusCycle++;
        if (batteryChargeCycle > batteryStatusCycle) {
            System.out.println("배터리 충전 싸이클 남은 횟수: " + (batteryChargeCycle - batteryStatusCycle));
            return true;
        }
        else {
            System.out.println("배터리 최대 충전 싸이클 도달. 더 이상 충전 불가.");
            return false;
        }
    }
}
