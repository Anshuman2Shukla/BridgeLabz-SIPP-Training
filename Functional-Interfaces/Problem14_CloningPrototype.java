
class Prototype implements Cloneable {
    int value;
    Prototype(int v) { value = v; }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Problem14_CloningPrototype {
    public static void main(String[] args) throws Exception {
        Prototype p1 = new Prototype(10);
        Prototype p2 = (Prototype)p1.clone();
        System.out.println("Original: " + p1.value + ", Clone: " + p2.value);
    }
}
