package astonaqa.lesson6;

import java.io.*;
import java.util.Arrays;

class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String fileName) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("Homework/src/main/resources/" + fileName))) {
            writer.println(String.join(";", header));
            for (int[] row : data) {
                writer.println(Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((s1, s2) -> s1 + ";" + s2)
                        .orElse(""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Homework/src/main/resources/" + fileName))) {

            header = reader.readLine().split(";");

            long rowCount = reader.lines().count();
            data = new int[(int) rowCount][header.length];

            reader.close();
            BufferedReader datareader = new BufferedReader(new FileReader("Homework/src/main/resources/" + fileName));
            datareader.readLine();

            int rowIndex = 0;
            String line;
            while ((line = datareader.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    data[rowIndex][i] = Integer.parseInt(values[i]);
                }
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}