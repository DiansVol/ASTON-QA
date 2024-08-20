public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Green", "Blue");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Brown");

        System.out.println("Круг:");
        printShapeInfo(circle);

        System.out.println("\nПрямоугольник:");
        printShapeInfo(rectangle);

        System.out.println("\nТреугольник:");
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Периметр: " + shape.getPerimeter());
        System.out.println("Площадь: " + shape.getArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
    }
}