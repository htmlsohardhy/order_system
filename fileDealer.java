import java.io.*;
import java.util.*;

public class fileDealer {
    public String[][] readFoodData(String filePath) {
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    dataList.add(new String[]{parts[0].trim(), parts[1].trim()});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList.toArray(new String[0][0]);
    }
}
