package WEEK08.Interface;

public class UsingInterface implements AbstractMethod, ConstantField {

    public void printPI() {
        System.out.println(ConstantField.PI);
    }

    public void printMAX_SPEED() {
        System.out.println(ConstantField.MAX_SPEED);
    }

    public double getArea(double r) {
        return r*r*ConstantField.PI;
    }
}
