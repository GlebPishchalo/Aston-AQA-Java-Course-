package astonaqa.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginsChecker {
    public static List<String> processLogins() {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Write logins:");

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            logins.add(input);
        }

        scanner.close();

        return logins;
    }

    public static void printLoginsF(List<String> logins) {
        logins.stream()
                .filter(login -> login.startsWith("f"))
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
