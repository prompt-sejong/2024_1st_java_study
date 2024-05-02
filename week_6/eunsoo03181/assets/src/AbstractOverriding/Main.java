package WEEK06.AbstractOverriding;

public class Main {
    public static void main(String[] args) {
        // 일반적인 호출 방식입니다.
        AppleLaptop al = new AppleLaptop("Apple", "MacBook Pro", "M3 Pro", "MacOS", 512);
        LGLaptop ll = new LGLaptop("LG", "LG gram pro", "Intel Ultra 7 155H", "Windows 11 Home", 256);
        SamsungLaptop sl = new SamsungLaptop("Samsung", "Galaxy Book 4 Pro", "Intel Ultra 5 125H", "Windows 11 Education", 512);

        al.addSSD();
        ll.addSSD();
        sl.addSSD();

        System.out.println();
        // 자동 타입 변환을 이용한 호출 방식입니다.
        Laptop laptop = null;
        laptop = new AppleLaptop("Apple", "MacBook Pro", "M3 Pro", "MacOS", 512);
        laptop.addSSD();
        laptop = new LGLaptop("LG", "LG gram pro", "Intel Ultra 7 155H", "Windows 11 Home", 256);
        laptop.addSSD();

        System.out.println();
        // 메소드의 다형성을 이용한 호출 방식입니다.
        extraSSD(new LGLaptop("LG", "LG gram pro", "Intel Ultra 7 155H", "Windows 11 Home", 256));
        extraSSD(new SamsungLaptop("Samsung", "Galaxy Book 4 Pro", "Intel Ultra 5 125H", "Windows 11 Education", 512));
    }

    public static void extraSSD(Laptop laptop) {
        laptop.addSSD();
    }
}
