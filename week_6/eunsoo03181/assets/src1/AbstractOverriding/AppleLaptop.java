package WEEK06.AbstractOverriding;

public class AppleLaptop extends Laptop {
    AppleLaptop(String brand, String deviceName, String CPU, String OS, int SSD) {
        super(brand, deviceName, CPU, OS, SSD);
    }

    @Override
    void addSSD() {
        System.out.println("처음 구매한 스토리지를 늘릴 수 없습니다.");
    }
}
