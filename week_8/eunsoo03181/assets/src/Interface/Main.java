package WEEK08.Interface;

public class Main {
    public static void main(String[] args) {
        UsingInterface ui = new UsingInterface();
        ConstantField cf = ui;
        AbstractMethod am = ui;

        // 방법2
        // ConstantField cf;
        // cf = new UsingInterface();
    }
}
