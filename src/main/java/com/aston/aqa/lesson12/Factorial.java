package com.aston.aqa.lesson12;

public class Factorial {
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;

    }
}
