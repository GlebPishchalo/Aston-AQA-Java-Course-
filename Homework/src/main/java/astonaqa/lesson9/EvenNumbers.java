package astonaqa.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EvenNumbers {


    public static List<Integer> randomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();

        int a = 20;

        for (int i = 0; i < count; i++) {
            int random = (int) (Math.random() * a);
            numbers.add(random);
        }

        return numbers;
    }

    public static long countEvenNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(num -> num % 2 == 0)
                .count();
    }


}


