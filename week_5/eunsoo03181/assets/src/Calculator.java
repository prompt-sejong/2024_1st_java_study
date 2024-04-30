package WEEK05;

public class Calculator {
    int input1;
    int input2;
    boolean isActivated = true;

    Calculator() { }

    Calculator(int input1) {
        this.input1 = input1;
    }

    Calculator(int input1, int input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    void powerOff() {
        isActivated = false;
    }

    int getPlus() {
        return input1 + input2;
    }

    int getMinus() {
        return input1 - input2;
    }

    int getMulti() {
        return input1 * input2;
    }
}
