package annotations;

class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
