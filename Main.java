import java.util.*;

public class Main{
    public static void main(String[] args) {
        fileDealer dealer = new fileDealer();
        String path = "foodList.txt";
        dealer.readFoodData(path);
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        while(isRunning){
            System.out.println("歡迎使用點餐機 請輸入數字選擇功能");
            System.out.println("===============================");
            System.out.println("1.查看菜單\t\t" + "2.新增品項\n");
            System.out.println("3.修改品項\t\t" + "4.刪除品項\n" );
            System.out.println("5.搜尋品項\t\t" + "6. 離開系統");
            System.out.println("===============================");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();// 清除換行字元
            } else {
                System.out.println("請輸入數字！");
                sc.nextLine();// 清除錯誤輸入
                continue;// 回到迴圈開頭
            }
            switch(choice) {
                case 1: {//印出全部
                    dealer.printAll();
                    System.out.print("\n");
                    break;
                }
                case 2: {//新增
                    System.out.print("請輸入食物名稱：");
                    String name = sc.nextLine();
                    System.out.print("請輸入食物價格：");
                    int price = sc.nextInt();
                    sc.nextLine();
                    dealer.addFood(name, price);
                    dealer.saveToFile(path);
                    System.out.println("新增完成\n");
                    break;
                }
                case 3: {//修改
                    System.out.print("請輸入要修改的食物名稱：");
                    String name = sc.nextLine();
                    System.out.print("請輸入新的價格：");
                    int newPrice = sc.nextInt();
                    sc.nextLine();
                    if (dealer.updatePrice(name, newPrice)) {
                        dealer.saveToFile(path);
                        System.out.println("修改成功\n");
                    } else {
                        System.out.println("找不到該食物名稱\n");
                    }
                    break;
                }
                case 4: {//刪除
                    System.out.print("請輸入要刪除的食物名稱：");
                    String name = sc.nextLine();
                    if (dealer.deleteFood(name)) {
                        dealer.saveToFile(path);
                        System.out.println("刪除成功\n");
                    } else {
                        System.out.println("找不到該食物名稱\n");
                    }
                    break;
                }
                case 5: {
                    System.out.print("請輸入關鍵字：");
                    String keyword = sc.nextLine();
                    dealer.searchFood(keyword);
                    break;
                }
                case 6: {//結束程式
                    isRunning = false;
                    System.out.println("感謝使用本程式");
                    break;
                }
                default: {
                    System.out.println("無此選項，請重新輸入");
                }
            }
        }
        sc.close();
    }
}
