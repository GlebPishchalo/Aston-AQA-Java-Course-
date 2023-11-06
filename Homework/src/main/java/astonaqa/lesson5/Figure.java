package astonaqa.lesson5;

public interface Figure {
    double area();
    String getFillColor();
    String getBorderColor();

    default double perimeter() {
        System.out.println("Метод calculatePerimeter не реализован.");
        return 0.0;
    }
}
