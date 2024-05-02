package WEEK06.AbstractOverriding;

public class LGLaptop extends Laptop {
    LGLaptop(String brand, String deviceName, String CPU, String OS, int SSD) {
        super(brand, deviceName, CPU, OS, SSD);
    }

    @Override
    void addSSD() {
        System.out.println("SSD 256GB를 추가하셨습니다.");
        SSD += 256;
    }
}
