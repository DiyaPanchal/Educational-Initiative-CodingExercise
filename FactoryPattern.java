interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Dog says: Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Cat says: Meow!");
    }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("Cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return null;
    }
}

public class FactoryPattern{
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("Dog");
        dog.speak();

        Animal cat = AnimalFactory.getAnimal("Cat");
        cat.speak();
    }
}
