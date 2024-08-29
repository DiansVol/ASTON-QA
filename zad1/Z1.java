public class Z1 {

    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        Cat barsik = new Cat("Барсик");

        bobik.run(150);
        bobik.swim(50);

        barsik.run(100);
        barsik.swim(10);
    }
}

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        if (distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (distance > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}