package astonaqa.lesson6;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {
                {1, 1, 2},
                {2, 2, 2},
                {3, 3, 3}
        };

        AppData appData = new AppData(header, data);

        appData.save("data12.csv");

        AppData loadedData = new AppData(header, data);
        loadedData.load("data12.csv");
    }
}
