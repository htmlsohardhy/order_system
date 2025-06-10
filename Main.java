import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        fileDealer dealer = new fileDealer();
        String[][] foodData = dealer.readFoodData("foodList.txt");



        Scanner sc = new Scanner(System.in);
        System.out.println("歡迎使用點餐機 請輸入數字選擇功能");
        System.out.println("===============================\n");
        System.out.println("1.查看菜單\t\t" + "2.新增品項\n");
        System.out.println("3.修改品項\t\t" + "4.刪除品項\n" );
        System.out.println("===============================");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:

        }

        for (String[] row : foodData) {
            System.out.println("食物：" + row[0] + "，價格：" + row[1]);
        }

    }
}
