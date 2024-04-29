package WEEK06.InstanceOf;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();
        if (parent instanceof Child) {
            Child child = (Child) parent;
        }
    }
}
