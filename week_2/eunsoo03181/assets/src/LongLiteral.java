package WEEK02;

public class LongLiteral {
    public static void main(String[] args) {
        // 변수 a는 int 범위 내에 있기 때문에, 다음과 같이 표기해도 오류가 발생하지 않습니다.
        long a = 20240124;
        // 변수 b는 int 범위 밖에 있기 때문에, 다음과 같이 리터럴 뒤에 L을 붙입니다.
        long b = 2345678901L;

        System.out.println("a = " + a + ", b = " + b);
    }
}