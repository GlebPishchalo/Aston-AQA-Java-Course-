package astonaqa.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //zadanie-1
        String[] words = {"dog", "cat", "cow", "dog", "cat", "cow", "man", "woman", "child", "child", "child"};
        ArrayOfWords arrOfWord = new ArrayOfWords();
        arrOfWord.processWords(words );

        //zadanie-2
        PhoneBook phoneBook = new PhoneBook();


        phoneBook.add("Ustsinau", "4565453");
        phoneBook.add("Petrov", "3535353");
        phoneBook.add("Petrov", "3424244");


        System.out.println("Ustsinau: " + phoneBook.get("Ustsinau"));
        System.out.println("Petrov: " + phoneBook.get("Petrov"));
        }

    }

