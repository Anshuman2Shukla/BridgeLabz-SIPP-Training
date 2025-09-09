package reflection;

public class Student {
    private String name;
    private int id;

    public Student() { }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String toString() { return "Student{name='"+name+"', id="+id+"}"; }
}
