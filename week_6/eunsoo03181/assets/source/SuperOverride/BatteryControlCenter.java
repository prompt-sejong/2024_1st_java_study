package WEEK06.SuperOverride;
import java.util.Scanner;

public class BatteryControlCenter {
    Scanner sc = new Scanner(System.in);
    protected int battery = 100;
    protected boolean power = true;

    void setBattery () {
        if (battery > 100) {
            battery = 100;
        }
        if (battery < 0) {
            battery = 0;
        }
    }

    void useBattery() {
        if (power) {
            System.out.println("배터리를 사용하였습니다.");
            battery--;
        }
        else {
            System.out.println("배터리가 부족합니다. 충전이 필요합니다.");
        }
    }

    void chargeBattery() {
        if (battery >= 100) {
            System.out.println("배터리가 완충 상태입니다.");
        }
        else {
            System.out.println("배터리 충전 중입니다.");
            battery++;
        }
    }

    void statusQuoBattery() {
        System.out.println("현재 배터리는 " + battery + "%입니다.");
    }
}
