package WEEK08.UsingInterface;

public class ImplementClass implements MyInterface {
    private double p;

    ImplementClass(double p) {
        this.p = p;
    }

    public void changeInput(double r) {
        p = r;
    }

    public double multipleRoot2() {
        System.out.println("계산 결과를 출력합니다.");
        return p * ROOT2;
    }
}
