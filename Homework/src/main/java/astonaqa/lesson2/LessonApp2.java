package astonaqa.lesson2;

import java.util.Random;
import java.util.Scanner;

public class LessonApp2 {
    private static boolean isCheckRange(int a, int b) {
        int sum = a + b;
        if ((sum >= 10) && (sum <= 20)) {
            return true;
        } else return false;
    }

    private static void isCheckNumb(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    private static boolean isCheckNumber(int a) {
         return a < 0;
    }

    private static void isRepeat(String a, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(a);
        }
    }

    private static boolean isCheckYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        } else return false;
    }

    private static void isArrayReplacement(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;

            System.out.print(arr[i] + " ");
        }
    }

    private static void isFillArray(int arr2[]) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
            System.out.print(arr2[i] + " ");
        }

    }

    private static void arrayAction(int arr3[]) {
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
            System.out.print(arr3[i] + " ");

        }
    }

    private static void arrayDiagonals(int table[][]) {
        int counter = 0;
        System.out.println(" ");
        System.out.println("Заполненный массив: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = counter;
                System.out.print(table[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Измененный массив: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == j)) {
                    table[i][j] = 1;
                }
                table[i][5 - i - 1] = 1;
                System.out.print(table[i][j] + " ");


            }
            System.out.println();
        }
    }

    private static int[] arrWork(int len, int initialValue) {
        int[] arr5 = new int[len];
        for (int i = 0; i < len; i++) {
            arr5[i] = initialValue;
        }
        return arr5;
    }


    public static void main(String[] args) {
        //1 zadanie
        boolean result = isCheckRange(6, 6);
        System.out.println("Результат метода " + result);

        //2 zadanie
        isCheckNumb(3);

        //3 zadanie
        boolean result2 = isCheckNumber(-5);
        System.out.println("Отрицательное число? " + result2);

        //4 zadanie
        isRepeat("Hi!", 5);

        //5 zadanie

        boolean result3 = isCheckYear(2024);
        System.out.println("Высокосный год? " + result3);

        //6 zadanie
        int[] arr = new int[8];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNumber = random.nextInt(2);
            arr[i] = randomNumber;
        }
        System.out.println("Массив до: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println(" ");
        System.out.println("Массив после: ");
        isArrayReplacement(arr);

        //7 zadanie
        int[] arr2 = new int[100];
        System.out.println(" ");
        System.out.println("Заполненный массив: ");
        isFillArray(arr2);

        //8-9 zadanie
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(" ");
        System.out.println("Измененный массив: ");
        arrayAction(arr3);

        //10 zadanie

        int[][] table = new int[5][5];
        arrayDiagonals(table);
        //11 zadanie
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();
        System.out.print("Введите число, которым заполним массив: ");
        int initialValue = scanner.nextInt();
        System.out.println("Полученный массив:");
        int[] arrayRes=arrWork(len, initialValue);
        for (int value:
             arrayRes) {
            System.out.print(value+" ");

        }

    }

}
