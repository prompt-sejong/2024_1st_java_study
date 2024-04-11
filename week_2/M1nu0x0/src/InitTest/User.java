package InitTest;

public class User {
    private String name; // Reference Type
    private int id; // Primitive Type

    // Default Constructor
    public User() {
    }

    // Constructor Overload
    public User(String name) {
        this.name = name;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // simple getter
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
