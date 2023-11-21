package astonaqa.lesson9;


import java.util.List;

public class ActionInCollection {
    public static long countOfHigh(List<String> collection) {
        return collection.stream()
                .filter(s -> s.equals("High"))
                .count();
    }

    public static String checkFirstWord(List<String> collection) {
        return collection.stream()
                .findFirst()
                .orElse("0");
    }

    public static String checkLastWord(List<String> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElse("0");
    }
    public static String[] sortedAddToArray(List<String> collection) {
        return collection.stream()
                .sorted()
                .toArray(String[]::new);
    }

}
