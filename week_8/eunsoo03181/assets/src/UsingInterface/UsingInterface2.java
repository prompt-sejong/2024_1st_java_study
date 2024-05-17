package WEEK08.UsingInterface;

public class UsingInterface2 {
    MyInterface mi = new ImplementClass(3.141);

    // 생성자의 매개변수로 사용됩니다.
    UsingInterface2(MyInterface mi) {
        this.mi = mi;
        System.out.println("생성자가 호출되었습니다. 이어서 mi.multipleRoot2()값이 호출됩니다. " + mi.multipleRoot2());
    }
}
