package astonaqa.lesson9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //zadanie 1
        List<Integer> numbers = EvenNumbers.randomNumbers(10);

        int evenCount = (int) EvenNumbers.countEvenNumbers(numbers);
        System.out.println("numbers: " + numbers);
        System.out.println("Even numbers count: " + evenCount);
        //zadanie 2
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");

        long highCount = ActionInCollection.countOfHigh(collection);
        System.out.println("'High' count: " + highCount);

        String firstWord = ActionInCollection.checkFirstWord(collection);
        System.out.println("First word: " + firstWord);

        String lastWord = ActionInCollection.checkLastWord(collection);
        System.out.println("Last Word: " + lastWord);

        //zadanie 3
        //i am add method sortedAddToArray to ActionInCollection class for economy
        String[] sortedArray = ActionInCollection.sortedAddToArray(collection);
        System.out.println(Arrays.toString(sortedArray));
        //zadanie 5
        List<String> userLogins = LoginsChecker.processLogins();
        LoginsChecker.printLoginsF(userLogins);
        //zadanie 4 in "universitet" class

    }

}



