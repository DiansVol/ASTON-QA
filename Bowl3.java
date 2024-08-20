public class Bowl3 {
    private int foodAmount;

    public Bowl3(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }

    public boolean hasEnoughFood(int amount) {
        return foodAmount >= amount;
    }

    public void eatFood(int amount) {
        if (hasEnoughFood(amount)) {
            foodAmount -= amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}