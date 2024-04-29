package WEEK06.Abstract;

public class Main {
    public static void main(String[] args) {
        // 오류: Phone phone = new Phone();
        BrandPhone galaxyS = new BrandPhone("Galaxy S 24 Ultra", "SnapDragon 8 Gen 3 for Galaxy", 256, 1299);
        BrandPhone iPhone = new BrandPhone("iPhone 15 Pro Max", "A17 Pro", 256, 1199);
    }
}
