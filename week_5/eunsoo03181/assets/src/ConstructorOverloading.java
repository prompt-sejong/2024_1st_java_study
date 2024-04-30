package WEEK05;

public class ConstructorOverloading {
    String deviceName = "LG V40";
    int price = 35000;
    int stock = 80000;

    ConstructorOverloading() { }

    ConstructorOverloading(String deviceName) {
        this.deviceName = deviceName;
    }

    ConstructorOverloading(String deviceName, int price) {
        this.deviceName = deviceName;
        this.price = price;
    }

    ConstructorOverloading(String deviceName, int price, int stock) {
        this.deviceName = deviceName;
        this.price = price;
        this.stock = stock;
    }
}
