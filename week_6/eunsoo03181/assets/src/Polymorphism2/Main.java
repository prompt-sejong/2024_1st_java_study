package WEEK06.Polymorphism2;

public class Main {
    public static void main(String[] args) {
        // 객체를 매개변수로 지정할 수 있습니다.
        Driver driver = new Driver();
        Vehicle vehicle = new Vehicle();
        driver.drive(vehicle);

        // 자식 객체를 매개변수로 지정할 수 있으며, 재정의된 메소드를 반영합니다.
        Bus bus = new Bus();
        Vehicle vehicle2 = bus;
        driver.drive(vehicle2);
    }
}
