package WEEK05;

public class GetterSetter {
    // 객체 외부에서 접근할 수 없도록, private으로 필드를 선언합니다.
    private double width;
    private double length;

    // 생성자 (기본 생성자가 자동 생성됩니다.)

    // getter 메소드
    public double getInput() {
        return width * length;
    }

    // setter 메소드
    public void setInput(double width, double length) {
        if (width < 0) this.width = 0;
        else this.width = width;
        if (length < 0) this.length = 0;
        else this.length = length;
        return;
    }
}
