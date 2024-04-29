package WEEK06.AbstractOverriding;

public abstract class Laptop {
    String brand;
    String deviceName;
    String CPU;
    String OS;
    int SSD;

    Laptop(String brand, String deviceName, String CPU, String OS, int SSD) {
        this.brand = brand;
        this.deviceName = deviceName;
        this.CPU = CPU;
        this.OS = OS;
        this.SSD = SSD;
    }

    void printAll() {
        System.out.println("========기본 사양========");
        System.out.println("제작: " + brand);
        System.out.println("모델: " + deviceName);
        System.out.println("프로세서: " + CPU);
        System.out.println("운영체제: " + OS);
        System.out.println("용량: " + SSD);
        System.out.println("=======================");
    }

    abstract void addSSD();
}
