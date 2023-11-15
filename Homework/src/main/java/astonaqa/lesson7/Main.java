package astonaqa.lesson7;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "72", "26", "11"},
                {"56", "14", "14", "51"},
                {"15", "23", "34", "134"},
                {"1343", "4", "9", "0"},

        };

        try {
            int result = MyArray.sumOfArray(arr);
            System.out.println("Summa " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Get error: " + e.getMessage());
        }
    }
}

