
public class Dop{

    public static class Cat {
        private String name;
        private boolean isFull;

        public Cat(String name) {
            this.name = name;
            this.isFull = false;
        }

        public String getName() {
            return name;
        }

        public boolean isFull() {
            return isFull;
        }

        public void eat(FoodBowl bowl) {
            if (bowl.getFoodAmount() >= 1 && !isFull) {
                bowl.eat(1);
                isFull = true;
            }
        }
    }

    public static class FoodBowl {
        private int foodAmount;

        public FoodBowl(int initialFoodAmount) {
            this.foodAmount = initialFoodAmount;
        }

        public int getFoodAmount() {
            return foodAmount;
        }

        public void addFood(int foodAmount) {
            this.foodAmount += foodAmount;
        }

        public void eat(int foodAmount) {
            if (this.foodAmount >= foodAmount) {
                this.foodAmount -= foodAmount;
            }
        }
    }

    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Пушок")
        };

        FoodBowl foodBowl = new FoodBowl(10);

        for (Cat cat : cats) {
            cat.eat(foodBowl);
        }

        System.out.println("Информация о сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        foodBowl.addFood(5);
        System.out.println("В миске теперь " + foodBowl.getFoodAmount() + " еды.");
    }
}