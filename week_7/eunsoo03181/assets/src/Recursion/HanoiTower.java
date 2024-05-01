package DataStructure.Recursion;

public class HanoiTower {
    int n = 3; // 탑의 원반 개수
    int fromRod = 1; // 시작 기둥
    int toRod = 3; // 목표 기둥
    int auxRod = 2; // 보조 기둥



    public static void solveHanoi(int n, int fromRod, int toRod, int auxRod) {
        Main.cnt++;
        if (n == 1) {
            System.out.println("1번 원반을 " + fromRod + "번 기둥에서 " + toRod + "번 기둥으로 옮깁니다.");
            return;
        }

        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println(n + "번 원반을 " + fromRod + "번 기둥에서 " + toRod + "번 기둥으로 옮깁니다.");
        solveHanoi(n - 1, auxRod, toRod, fromRod);
        }
}
