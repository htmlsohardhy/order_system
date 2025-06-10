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






}