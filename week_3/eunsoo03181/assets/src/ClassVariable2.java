// 편의를 위하여, WEEK03 패키지에 포함시켰습니다. 실제로 이 코드는 WEEK02에 사용됩니다.
package WEEK03;

import WEEK02.GlobalVariable;

public class ClassVariable2 {
    public static void main(String[] args) {
        // 클래스를 import한 경우, 패키지가 달라도 클래스 변수를 호출할 수 있습니다.
        System.out.println(GlobalVariable.class_var);
    }
}