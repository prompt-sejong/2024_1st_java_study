package WEEK06.ObjectClass;

public class Overriding {
    String str1;
    String str2;

    Overriding(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public String toString() {
        return str1 + ", " + str2;
    }
}
