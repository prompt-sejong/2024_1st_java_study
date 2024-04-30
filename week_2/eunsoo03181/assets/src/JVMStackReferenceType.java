package WEEK02;

public class JVMStackReferenceType {
    public static void main(String[] args) {
        // 배열을 선언합니다. 배열은 래퍼런스 변수입니다.
        int[] arr = {1, 2, 3};
        /*
        arr의 실제 값인 1, 2, 3은 heap 영역에 저장됩니다.
        arr의 주솟값을 p라고 가정할 때, JVM 스택 영역에서 arr이 push됩니다.
        */

        // 배열을 빈 공간으로 초기화합니다.
        arr = null;
        /*
        기존 arr이 가리키고 있던 주솟값 p가 사라집니다.
        heap 영역에 있는 1, 2, 3을 참조하는 변수가 없으므로,
        가비지 컬렉터가 heap 영역에 있는 1, 2, 3을 자동으로 해제합니다.
        */

        // main 메서드 종료로, JVM 스택 영역에서 arr이 pop됩니다.
    }
}
