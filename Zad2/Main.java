
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red", "Black");
        Rectangle rectangle = new Rectangle(4, 6, "Blue", "Green");
        Triangle triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        System.out.println("Круг:");
        System.out.println("Периметр : " + circle.getPerimeter());
        System.out.println("Область: " + circle.getArea());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());

        System.out.println("\nПрямоугольник:");
        System.out.println("Периметр : " + rectangle.getPerimeter());
        System.out.println("Область: " + rectangle.getArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());

        System.out.println("\nТреугольник:");
        System.out.println("Периметр : " + triangle.getPerimeter());
        System.out.println("Область: " + triangle.getArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}