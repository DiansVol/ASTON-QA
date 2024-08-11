import java.awt.Color;

public class Zad2 {

    public static void main(String[] args) {
        Circle circle = new Circle(5, Color.RED, Color.BLUE);
        Rectangle rectangle = new Rectangle(4, 6, Color.GREEN, Color.BLACK);
        Triangle triangle = new Triangle(3, 4, 5, Color.YELLOW, Color.ORANGE);

        System.out.println("Круг:");
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());
        System.out.println();

        System.out.println("Прямоугольник:");
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());
        System.out.println();

        System.out.println("Треугольник:");
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}

interface Shape {
    double getPerimeter();
    double getArea();
    Color getFillColor();
    Color getBorderColor();
}

class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2;  Math.PI  radius;
    }

    @Override
    public double getArea() {
        return Math.PI;  radius  radius;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2;  (width + height);
    }

    @Override
    public double getArea() {
        return width  height;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double side1, double side2, double side3, Color fillColor, Color borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s(s-side1)(s-side2)(s-side3));
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }
}