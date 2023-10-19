package astonaqa.lesson1;

public class LessonApp1 {
    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 3;
        int b = 5;
        if ((a + b) > 0) {
            System.out.println("Сумма положительная");
        } else if ((a + b) < 0) {
            System.out.println("Cумма отрицательная");
        } else System.out.println("Сумма равна 0");
    }

    private static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 3;
        int b = 5;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

}
