package WEEK08.InterfaceCasting;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();

        vehicle.run();
        // vehicle.superRun(); 사용 불가

        // 강제 타입 변환
        Car car = (Car) vehicle;

        car.run();
        car.superRun();
    }
}
