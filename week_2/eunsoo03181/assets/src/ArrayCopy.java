package WEEK02;

public class ArrayCopy {
    public static void main(String[] args) {
        String[] oldArray = { "A", "B", "C" };
        String[] newArray = new String[5];
        // 변수를 복사합니다. 각각의 매개변수는 원본 배열, 복사할 항목의 시작 인덱스, 새로운 배열, 붙여놓을 항목의 시작 인덱스, 복사할 개수를 의미합니다.
        System.arraycopy(oldArray,0,newArray,0,oldArray.length);

        for (int i = 0; i< newArray.length; i++) {
            System.out.print(newArray[i] + ", ");
        }
    }
}