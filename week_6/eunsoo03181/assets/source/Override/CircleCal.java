package WEEK06.Override;

public class CircleCal {
    double r;

    CircleCal(double r) {
        this.r = r;
    }

    double getArea () {
        System.out.println("부모 클래스에서의 기존 메소드입니다.");
        return r*r*3.141592;
    }
}