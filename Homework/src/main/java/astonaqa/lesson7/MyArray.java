package astonaqa.lesson7;

public class MyArray {
    public static int sumOfArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int rows = 4;
        int cols = 4;
        int sum = 0;
        if (arr.length != rows  || arr[0].length != cols) {
            throw new MyArraySizeException("Wrong array. Rows or cols not 4");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong data in [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
