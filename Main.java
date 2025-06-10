import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        fileDealer dealer = new fileDealer();
        String[][] foodData = dealer.readFoodData("foodList.txt");

        for (String[] row : foodData) {
            System.out.println("食物：" + row[0] + "，價格：" + row[1]);
        }
    }
}
