public class Zad_1 {

    public static void main(String[] args) {
        Bowl bowl = new Bowl(10);

        Cat[] cats = new Cat[]{
                new Cat("Барсик"),
                new Cat("Мурка"),
                new Cat("Васька")
        };

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        bowl.addFood(5);
    }
}

class Animal {
    private String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance <= getRunLimit()) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать так далеко.");
        }
    }

    public void swim(int distance) {
        if (distance <= getSwimLimit()) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть так далеко.");
        }
    }

    protected int getRunLimit() {
        return 0;
    }

    protected int getSwimLimit() {
        return 0;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    protected int getRunLimit() {
        return 500;
    }

    @Override
    protected int getSwimLimit() {
        return 10;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    protected int getRunLimit() {
        return 200;
    }

    @Override
    protected int getSwimLimit() {
        return 0;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= 15) {
            satiety = true;
            bowl.eatFood(15);
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void eatFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("В миске недостаточно еды.");
        }
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавлено " + amount + " еды.");
    }
}