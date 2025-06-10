import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class fileDealer{
    List<Food> foodList = new ArrayList<>();

    public void readFoodData(String filePath){

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split(",");

                if(parts.length == 2){
                    String name = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());
                    foodList.add(new Food(name, price));
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void saveToFile(String filePath) {
        try(BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            for(Food food : foodList){
                bw.write(food.toString());
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addFood(String name, int price) {
        foodList.add(new Food(name, price));
    }

    public boolean updatePrice(String name, int newPrice) {
        for (Food food : foodList) {
            if(food.getName().equalsIgnoreCase(name)){
                food.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFood(String name) {
        Iterator<Food> iterator = foodList.iterator();
        boolean removed = false;

        while (iterator.hasNext()){
            Food food = iterator.next();
            if(food.getName().equalsIgnoreCase(name)){
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public void printAll(){
        for (Food food : foodList) {
            System.out.println("品項：" + food.getName() + "，價格：" + food.getPrice());
        }
    }

    public void searchFood(String keyword){
        boolean found = false;
        System.out.println("=== 搜尋結果 ===");

        for (Food food : foodList){
            if (food.getName().toLowerCase().contains(keyword)) {//不區分大小寫搜尋
                System.out.println("品項：" + food.getName() + "，價格：" + food.getPrice());
                found = true;
            }
        }

        if (!found){
            System.out.println("找不到符合的食物");
        }
    }
}
