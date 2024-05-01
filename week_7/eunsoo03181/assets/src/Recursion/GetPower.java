package DataStructure.Recursion;

public class GetPower {
    public static double getPower(double p, int n) {
        Main.cnt++;
        if (n==0) return 1;
        else return p*getPower(p, n-1);
    }
}
