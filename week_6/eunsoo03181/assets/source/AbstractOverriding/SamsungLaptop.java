package WEEK06.AbstractOverriding;

public class SamsungLaptop extends Laptop {
    SamsungLaptop(String brand, String deviceName, String CPU, String OS, int SSD) {
        super(brand, deviceName, CPU, OS, SSD);
    }

    @Override
    void addSSD() {
        System.out.println("SSD 512GB를 추가하셨습니다.");
        SSD += 512;
    }
}
