package WEEK06.Polymorphism;

public class Machine {

    // 필드를 생성합니다.
    Battery battery1 = new Battery(15, "bundle");
    Battery battery2 = new Battery(15, "bundle");
    Battery battery3 = new Battery(13, "bundle");
    Battery battery4 = new Battery(15, "bundle");

    int run() {
        int errorBat = 0;

        if (!battery1.batteryCharge()) {
            errorBat = 1;
        }
        if (!battery2.batteryCharge()) {
            errorBat = 2;
        }
        if (!battery3.batteryCharge()) {
            errorBat = 3;
        }
        if (!battery4.batteryCharge()) {
            errorBat = 4;
        }
        return errorBat;
    }
}
