/**
Author:Tianqi Liu
E-mail: tzl60@psu.edu 
Course: CMPSC 221 
Assignment: Programming Assignment 3 
Due date: 4/2/2018 
File: Driver.java, item.java
Purpose: Creating an online shop 
         let user create shopping cart ,add and remove items from it
         final let user check out with new card or in file card
Compiler/IDE: Java SE Development Kit 8u151/NetBeans IDE 8.2 Operating 
system: MS Windows 10 
Reference(s):Java 8 API - Oracle Documentation
            (http://docs.oracle.com/javase/8/docs/api/)
            (Include ALL additional references (Web page, etc.) here.)
             Demo program: ArrayListDemo.java
             Savitch, 6th Edition: Chapters 2, 14 
               
*/
package driver;

/**
 *
 * @author Tianqi
 */
public class item {
    private int number;
    private String name;
    private String category;
    private double price;
    private int quantity = 1;
    /**
     * this is a constructor for 5 attributes
     * @param Number
     * @param Name
     * @param Category
     * @param Price
     * @param Quantity 
     */
    public item (int Number, String Name, String Category, double Price, int Quantity)
    {
        number = Number;
        name = Name;
        category = Category;
        price = Price;
        quantity = Quantity;
    }
    public void setNumber(int Number)
    {
        number = Number;
    }
    public void setName(String Name)
    {
        name = Name;
    }
    public void setCategory(String Category)
    {
        category = Category;
    }
    public void setPrice(double Price)
    {
        price = Price;
    }
    public void setQuantity(int Quantity)
    {
        quantity = Quantity;
    }
    public int getNumber()
    {
        return number;
    }
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    /**
     * overload
     */
    public String toString()
    {
        String Number = "Number";
        String Name = "Name";
        String Category = "Category";
        String Price = "Price";
        String Quantity = "Quantity";
        
        
        return ("\nNumber:    " +  number + "\nName:      " + name +
                "\nCategory:  " + category + "\nPrice:     $  " + price +
                "\nQuantity:  " + quantity );
    }
    
}
