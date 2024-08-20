public class Cat3 {
    private boolean isFull;

    public Cat3() {
        isFull = false;
    }

    public void eat(Bowl3 bowl) {
        if (bowl.hasEnoughFood(1)) {
            isFull = true;
            bowl.eatFood(1);
        }
    }

    public boolean isFull() {
        return isFull;
    }
}
