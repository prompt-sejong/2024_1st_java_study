package WEEK06.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine();

        for (int i=0; i<15; i++) {
            int batteryDead = machine.run();

            switch(batteryDead) {
                case 1:
                    machine.battery1 = new AppleBattery(500, "Apple");
                    break;

                case 2:
                    machine.battery2 = new SamsungBattery(400, "Samsung");
                    break;

                case 3:
                    machine.battery3 = new AppleBattery(550, "ApplePro");
                    break;

                case 4:
                    machine.battery4 = new SamsungBattery(1100, "SamsungUltra");
                    break;
            }
            System.out.println("----------------------------");
        }
    }
}
