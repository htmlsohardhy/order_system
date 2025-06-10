//import java.util.*;

public class menuItem{
    private int id;
    private String name;
    private int price;
    


    public menuItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId(){return id;}

    public String getName(){return name;}

    public int  getPrice(){return price;}

    public void setName(String name){this.name=name;}

    public void setPrice(int price){this.price=price;}


    //新增一筆資料的字串處理 ex. 5, 燒桃 ,$10000K
    private static menuItem addItem(String item){
        String[] data = item.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        int price = Integer.parseInt(data[2]);

        return new menuItem(id, name, price);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price;
    }
}