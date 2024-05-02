package WEEK06.Promotion;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Person person = student;

        Person person1 = new Student();

        student.age = 22;
        System.out.println(person.age);

        // 오류: Student student1 = new Person();
    }
}
