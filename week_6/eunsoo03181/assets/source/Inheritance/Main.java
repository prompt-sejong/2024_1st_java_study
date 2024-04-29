package WEEK06.Inheritance;

public class Main {
    public static void main(String[] args) {
        InheritanceBasic2 it = new InheritanceBasic2();
        while (it.getPower()) {
            it.printUI();
            it.controlCenter(it.mode);
        }
    }
}
