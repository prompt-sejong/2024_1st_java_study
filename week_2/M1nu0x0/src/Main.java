import InitTest.User;

public class Main {
    public static void main(String[] args) throws Exception {
        User user1 = new User();
        System.out.println(user1.getId());      // 출력: 0
        System.out.println(user1.getName());    // 출력: null
    }
}
