package WEEK06.Casting;

public class Main {
    public static void main(String[] args) {
        // Child의 생성자는 Parent 생성자를 호출하는 함수인 super()가 있기 때문에, 부모 클래스가 우선적으로 생성됩니다.
        Parent parent = new Child();

        System.out.println();
        parent.method1();
        parent.method2();
        //오류: parent.method3();

        // Child 클래스로 자동 타입 변환된 것을 다시 강제 타입 변환합니다.
        Child child = (Child) parent;
        System.out.println();
        child.method1();
        child.method2();
        child.method3();
    }
}
