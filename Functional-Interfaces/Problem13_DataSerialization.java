
import java.io.*;

class UserData implements Serializable {
    String name;
    int age;
    UserData(String n, int a) { name = n; age = a; }
}

public class Problem13_DataSerialization {
    public static void main(String[] args) {
        UserData u = new UserData("Alice", 30);
        System.out.println("Serializable object created: " + u.name);
    }
}
