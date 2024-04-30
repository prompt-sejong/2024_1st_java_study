package WEEK05;

public class ThisConstructor {
    String name;
    int age;
    String bloodType;

    ThisConstructor(String name, int age, String bloodType) {
        // this.name : 필드, name : 매개변수
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }
}
