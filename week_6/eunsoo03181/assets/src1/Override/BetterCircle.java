package WEEK06.Override;

public class BetterCircle extends CircleCal {
    BetterCircle(double r) {
        super(r);
    }

    @Override // 어노테이션
    double getArea() {
        System.out.println("자식 클래스에서 오버라이드된 메소드입니다.");
        return r*r*Math.PI;
    }
}
