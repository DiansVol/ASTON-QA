public class Z3 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Рекс", 5);
        Dog dog2 = new Dog("Шарик", 3);
        Cat cat1 = new Cat("Мурка", 2);
        Cat cat2 = new Cat("Барсик", 1);

        System.out.println("Создано " + Animal.getCount() + " животных.");
        System.out.println("Создано " + Dog.getCount() + " собак.");
        System.out.println("Создано " + Cat.getCount() + " котов.");
    }
}

class Animal {
    private String name;
    private int age;
    private static int count = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Dog extends Animal {
    private static int count = 0;

    public Dog(String name, int age) {
        super(name, age);
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class Cat extends Animal {
    private static int count = 0;

    public Cat(String name, int age) {
        super(name, age);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
