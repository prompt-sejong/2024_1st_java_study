package WEEK06.Abstract;

public abstract class Phone {
    String model;
    String AP;
    int capacity;
    int price;

    Phone() { }

    Phone(String model, String AP, int capacity, int price) {
        this.model = model;
        this.AP = AP;
        this.capacity = capacity;
        this.price = price;
    }
}
