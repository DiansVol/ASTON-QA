public class Main3 {
    public static void main(String[] args) {
        // Создаем миску с едой
        Bowl3 bowl = new Bowl3(10);

        Cat3[] cats = new Cat3[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat3();
        }


        for (Cat3 cat : cats) {
            cat.eat(bowl);
        }


        for (Cat3 cat : cats) {
            System.out.println("Кот сыт: " + cat.isFull());
        }
    }
}