package astonaqa.lesson5;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Bobik");
        Cat catMurka = new Cat("Murka");
        Cat catBarsik = new Cat("Barsik");

        dogBobik.run(150);
        dogBobik.swim(5);

        catMurka.run(250);
        catMurka.swim(2);

        catBarsik.run(100);
        catBarsik.swim(1);
        System.out.println();
        System.out.println("Create dogs: " + Dog.getDogCount());
        System.out.println("Create cats: " + Cat.getCatCount());
        System.out.println("Create Animals: " + Animals.getAnimalCount());

        Plate plate = new Plate(0);
        System.out.println();
        System.out.println("Plate is:");
        plate.info();


        plate.addFood(30);
        plate.info();

        Cat[] cats = {
                catMurka,
                catBarsik
        };
        System.out.println();
        System.out.println("Cat eat from plate:");
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        System.out.println("Cat is:");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": full - " + cat.isFull());
        }

        System.out.println("Plate after eating:");
        plate.info();
        System.out.println();
        //Zadanie 2
        Figure circle = new Circle(5.0, "Blue", "Black");
        Figure rectangle = new Rectangle(4.0, 6.0, "Red", "Green");
        Figure triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Brown");

        System.out.println("Circle: P = " + circle.perimeter() + ", S = " + circle.area() +
                ", Fill color = " + circle.getFillColor() + ", Border color = " + circle.getBorderColor());
        System.out.println("Rectangle: P = " + rectangle.perimeter() + ", S = " + rectangle.area() +
                ", Fill color = " + rectangle.getFillColor() + ", Border color = " + rectangle.getBorderColor());
        System.out.println("Triangle: P = " + triangle.perimeter() + ", S = " + triangle.area() +
                ", Fill color = " + triangle.getFillColor() + ", Border color = " + triangle.getBorderColor());
    }
}
