package WEEK05;

public class AccessModifier {
    private int input1;
    private int input2;

    protected AccessModifier() { }

    public void modifyInputs(int input1, int input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    private int returnResult() {
        return input1 + input2;
    }

    public void printResult() {
        System.out.print(returnResult());
    }
}
