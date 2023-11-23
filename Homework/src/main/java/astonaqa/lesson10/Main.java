package astonaqa.lesson10;

public class Main {
        public static void main(String[] args) {
            Box<Apple> appleBox1 = new Box<>();
            appleBox1.addFruit(new Apple());
            appleBox1.addFruit(new Apple());
            appleBox1.addFruit(new Apple());

            Box<Orange> orangeBox = new Box<>();
            orangeBox.addFruit(new Orange());
            orangeBox.addFruit(new Orange());

            Box<Apple> appleBox2 = new Box<>();
            appleBox2.addFruit(new Apple());

            System.out.println("box with apple weight- " + appleBox1.getWeight());
            System.out.println("box with orange weight- " + orangeBox.getWeight());

            System.out.println("Compare box- " + appleBox1.compare(orangeBox));

            try {
                appleBox1.transferFruits(appleBox2);
            } catch (IllegalArgumentException e) {
                System.out.println("Error message: " + e.getMessage());
            }

            System.out.println("box with apple weight after transferFruits: " + appleBox1.getWeight());
            System.out.println("box №2 with apple weight after transferFruits: " + appleBox2.getWeight());
        }

}
