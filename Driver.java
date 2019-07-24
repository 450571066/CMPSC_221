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
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.text.DecimalFormat;


/**
 *
 * @author Tianqi
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Creating inventory ...\n");
        ArrayList<item> inventory = new ArrayList<item>();
        item Add;
        int Number;
        String Name;
        String Category;
        double Price;
        int Quantity;
        String exception;
        Scanner inputStream = null;
        
        try
        {
            inputStream = new Scanner(new FileInputStream("resource/inventory.txt"));
           
            do
            { 
                Number = inputStream.nextInt();
                inputStream.nextLine();
                Name = inputStream.nextLine();
                Category = inputStream.nextLine();
                Price = inputStream.nextDouble();
                inputStream.nextLine();
                Quantity = inputStream.nextInt();
                inputStream.nextLine();
                Add = new item(Number, Name, Category, Price, Quantity);
                inventory.add(Add);
            }while(Number != 504); 
            
            inputStream.close();                                           //close the file
        }
        catch(FileNotFoundException e)
        {
           System.out.println("File inventory.txt was not found");
           System.out.println("or could not be opened.");
           System.exit(0);
        }
         catch(IOException e)
       {
           System.out.println("Error reading from inventory.txt.");
           System.exit(0);
       }
        

        int choice = 0;
        boolean judge = false;                                   //keep the loop until user create the shopping cart
        ArrayList<item> shoppingCart = new ArrayList<item>();    //create new Arraylist
        Scanner keyboard = new Scanner(System.in);
        boolean judge_4 = false;                                 //to judge if the item user chose to remove exist
        boolean checkOut = false;                                //keep the loop until user choose to check out
      
        
        do{
             System.out.println("/*******************************************"
                + "*****************************************************/ \n");
            System.out.println("Welcome to Barnes & Noble Online! \n");
            System.out.println("Choose an option. \n"
                + "1) Create empty shopping cart \n"
                + "2) Add item to shopping cart \n"
                + "3) Remove item from shopping cart \n"
                + "4) Check out \n");
            try{
            System.out.println("Your choice?");
            
            choice = keyboard.nextInt();
            
            if(choice > 4 || choice < 1)
                throw new Exception("out of range");
            switch (choice)
            {
                case 1:
                    judge = true;
                    System.out.println("/*******************************************"
                + "*****************************************************/ \n");
                    System.out.println("Shopping cart created! \n");

                    break;
                case 2:
                    if(judge == false)
                    {
                        System.out.println("/*******************************************"
                + "*****************************************************/ \n");
                        System.out.println("Please create a shopping cart!  \n");
                    }
                    else
                    {
                        
                         System.out.println("/*******************************************"
                         + "*****************************************************/ \n");
                        System.out.println("Choose a category. \n"
                                + "1) Books \n"
                                + "2) Home & Gifts \n"
                                + "3) Movies & TV \n"
                                + "4) Music \n");
                        System.out.println("Your choice?");
                        boolean judge_2 = false;
                        boolean judge_3 = false;
                        boolean exist = false;                     //to determin if this item exsit
                        boolean returnMain = false;                //return main if user choose 0
                        do{
                            try
                            {
                                choice = keyboard.nextInt();
                                if(choice > 4|| choice < 0)
                                    throw new Exception("out of range");
                                if(choice == 0 )
                                    break;
                                switch (choice)
                                {
                                    case 1:
                                    for ( int i = 0; i < inventory.size(); i++)
                                        {
                                            if(inventory.get(i).getCategory().equals("Books"))
                                            { System.out.printf("\n"+inventory.get(i).getNumber() + " %-50s",
                                                        inventory.get(i).getName());
                                              System.out.printf("$ " + inventory.get(i).getPrice());
                                            }
                                        }
                                        System.out.println("\n\nEnter the number of the item you wish to add. "
                                                + "\nYour choice?");
                  

                                        try
                                        {
                                           choice = keyboard.nextInt();
                                           
                                               for( int i = 0; i < inventory.size(); i++)
                                               {
                                                   if (inventory.get(i).getNumber() == choice)
                                                   {
                                                        exist = false;
                                                        if (!inventory.get(i).getCategory().equals("Books"))
                                                        {
                                                             throw new Exception("out of range");
                                                        }
                                                        System.out.println("Your choice \"" + inventory.get(i).getNumber() + " " +
                                                                inventory.get(i).getName() +
                                                                "\" has been added to the shopping cart. ");
                                                        for(int j = 0; j < shoppingCart.size(); j++)
                                                        {
                                                            if(inventory.get(i) == shoppingCart.get(j))
                                                            {
                                                                shoppingCart.get(j).setQuantity(shoppingCart.get(j).getQuantity() +1);
                                                                exist = true;
                                                            }
                                                        }
                                                        if(exist == false)
                                                            shoppingCart.add(inventory.get(i));
                                                        judge_3 = true;
                                                        judge_2 = true;
                                                   }
                                               }
                                               if( judge_3 == false)
                                               throw new Exception("out of range");
                                               for(int i = 0; i < shoppingCart.size();i++)
                                                 {
                                                    System.out.println(shoppingCart.get(i));
                                                 }                 
                                               returnMain = true;
                                               
                                        }
                                         catch(InputMismatchException e)                                  //catch the exception of non-integer
                                        {
    
                                             exception = keyboard.nextLine();
                                             System.out.println("For input string: \"" + exception +
                                                     "\" is not a valid format for an integer. Please re-enter your choice. ");
                                            
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println("Item #" + choice + " was not found in this inventory. ");
                                            judge_3 = false;
                                            returnMain = true;
                                        }
           
                                        break;
                                    
                                    case 2:
                                          for ( int i = 0; i < inventory.size(); i++)
                                        {
                                            if(inventory.get(i).getCategory().equals("Home & Gifts"))
                                            { System.out.printf("\n"+inventory.get(i).getNumber() + " %-50s",
                                                        inventory.get(i).getName());
                                              System.out.printf("$ " + inventory.get(i).getPrice());
                                            }
                                        }
                                        System.out.println("\n\nEnter the number of the item you wish to add. "
                                                + "\nYour choice?");

    
                                        try
                                        {
                                           choice = keyboard.nextInt();
                                           
                                                 for( int i = 0; i < inventory.size(); i++)
                                               {
                                                   if (inventory.get(i).getNumber() == choice)
                                                   {
                                                       if (!inventory.get(i).getCategory().equals("Home & Gifts"))
                                                        {
                                                             throw new Exception("out of range");
                                                        }
                                                       exist = false;
                                                        System.out.println("Your choice \"" + inventory.get(i).getNumber() + " " +
                                                                inventory.get(i).getName() +
                                                                "\" has been added to the shopping cart. ");
                                                        for(int j = 0; j < shoppingCart.size(); j++)
                                                        {
                                                             if(inventory.get(i) == shoppingCart.get(j))
                                                            {
                                                                shoppingCart.get(j).setQuantity(shoppingCart.get(j).getQuantity() +1);
                                                                exist = true;
                                                            }
                                                        }
                                                        if(exist == false)
                                                            shoppingCart.add(inventory.get(i));
                                                        judge_3 = true;
                                                        judge_2 = true;
                                                   }
                                               }
                                               if( judge_3 == false)
                                               throw new Exception("out of range");
                                               for(int i = 0; i < shoppingCart.size();i++)
                                                   {
                                                     System.out.println(shoppingCart.get(i));
                                                   }   
                                               returnMain = true;
                                        }
                                         catch(InputMismatchException e)                                  //catch the exception of non-integer
                                        {
    
                                             exception = keyboard.nextLine();
                                             System.out.println("For input string: \"" + exception +
                                                     "\" is not a valid format for an integer. Please re-enter your choice. ");
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println("Item #" + choice + " was not found in this inventory. ");
                                            judge_3 = false;
                                            returnMain = true;
                                        }
         
                                        break;
                                        
                                        
                                    case 3:
                                        for ( int i = 0; i < inventory.size(); i++)
                                        {
                                            if(inventory.get(i).getCategory().equals("Movies & TV"))
                                            { System.out.printf("\n"+inventory.get(i).getNumber() + " %-50s",
                                                        inventory.get(i).getName());
                                              System.out.printf("$ " + inventory.get(i).getPrice());
                                            }
                                        }
                                        System.out.println("\n\nEnter the number of the item you wish to add. "
                                                + "\nYour choice?");



                                        try
                                        {
                                           choice = keyboard.nextInt();
                                           
                                                for( int i = 0; i < inventory.size(); i++)
                                               {
                                                   if (inventory.get(i).getNumber() == choice)
                                                   {
                                                       if (!inventory.get(i).getCategory().equals("Movies & TV"))
                                                        {
                                                             throw new Exception("out of range");
                                                        }
                                                       exist = false;
                                                        System.out.println("Your choice \"" + inventory.get(i).getNumber() + " " +
                                                                inventory.get(i).getName() +
                                                                "\" has been added to the shopping cart. ");
                                                        for(int j = 0; j < shoppingCart.size(); j++)
                                                        {
                                                             if(inventory.get(i) == shoppingCart.get(j))
                                                            {
                                                                shoppingCart.get(j).setQuantity(shoppingCart.get(j).getQuantity() +1);
                                                                exist = true;
                                                                judge_2 = true;
                                                            }
                                                        }
                                                        if(exist == false)
                                                            shoppingCart.add(inventory.get(i));
                                                        judge_3 = true;
                                                        
                                                   }
                                               }
                                               if( judge_3 == false)
                                               throw new Exception("out of range");
                                               for(int i = 0; i < shoppingCart.size();i++)
                                                {
                                                   System.out.println(shoppingCart.get(i));
                                                }
                                               returnMain = true;
                                                                                   
                                        }
                                         catch(InputMismatchException e)                                  //catch the exception of non-integer
                                        {
    
                                             exception = keyboard.nextLine();
                                             System.out.println("For input string: \"" + exception +
                                                     "\" is not a valid format for an integer. Please re-enter your choice. ");
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println("Item #" + choice + " was not found in this inventory. ");
                                            judge_3 = false;
                                            returnMain = true;
                                        }
                 
                                        break;
                                    
                                      case 4:
                                          for ( int i = 0; i < inventory.size(); i++)
                                        {
                                            if(inventory.get(i).getCategory().equals("Music"))
                                            { System.out.printf("\n"+inventory.get(i).getNumber() + " %-50s",
                                                        inventory.get(i).getName());
                                              System.out.printf("$ " + inventory.get(i).getPrice());
                                            }
                                        }
                                        System.out.println("\n\nEnter the number of the item you wish to add. "
                                                + "\nYour choice?");

                                        try
                                        {
                                           choice = keyboard.nextInt();
                                           judge_3 = false;
                                                for( int i = 0; i < inventory.size(); i++)
                                               {
                                                   if (inventory.get(i).getNumber() == choice)
                                                   {
                                                       if (!inventory.get(i).getCategory().equals("Music"))
                                                        {
                                                             throw new Exception("out of range");
                                                        }
                                                       exist = false;
                                                       System.out.println("Your choice \"" + inventory.get(i).getNumber() + " " +
                                                                inventory.get(i).getName() +
                                                                "\" has been added to the shopping cart. ");
                                                        for(int j = 0; j < shoppingCart.size(); j++)
                                                        {
                                                            if(inventory.get(i) == shoppingCart.get(j))
                                                            {
                                                                shoppingCart.get(j).setQuantity(shoppingCart.get(j).getQuantity() +1);
                                                                exist = true;
                                                            }
                                                        }
                                                        if(exist == false)
                                                            shoppingCart.add(inventory.get(i));
                                                        judge_3 = true;
                                                        judge_2 = true;
                                                   }
                                               }
                                               if( judge_3 == false)
                                               throw new Exception("out of range");
                                               for(int i = 0; i < shoppingCart.size();i++)
                                                 {
                                                        System.out.println(shoppingCart.get(i));
                                                 }          
                                               returnMain = true;
                                        }
                                         catch(InputMismatchException e)                                  //catch the exception of non-integer
                                        {
    
                                             exception = keyboard.nextLine();
                                             System.out.println("For input string: \"" + exception +
                                                     "\" is not a valid format for an integer. Please re-enter your choice. ");
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println("Item #" + choice + " was not found in this inventory. ");
                                            
                                            returnMain = true;
                                        }
             
                                        break;  
                                }
                                
                                
                                
                                
                             }
                            catch(InputMismatchException e)                                  //catch the exception of non-integer
                                        {
    
                                             exception = keyboard.nextLine();
                                             System.out.println("For input string: \"" + exception +
                                                     "\" is not a valid format for an integer. Please re-enter your choice. ");
                                             System.out.println("Your choice?");
                                             returnMain = false;
                                        }
                            catch (Exception e)
                             {
                               System.out.println(choice + " is not a valid choice! Please enter a number from 1 to 4.");
                                System.out.println("Enter 0 to return to the main menu. \n");
                               System.out.println("Your choice?");
                               judge_2 = false;
                               returnMain = false;
                              }  
                        }while(returnMain == false);
                    }
                    break;
                    
                case 3:
                    if(judge == false)
                    {
                        System.out.println("/*******************************************"
                + "*****************************************************/ \n");
                        System.out.println("Please create a shopping cart!  \n");
                    }
                    else
                    {
                         System.out.println("/*******************************************"
                         + "*****************************************************/ \n");
                         System.out.println("Displaying the current contents of the shopping"
                                 + " cart ... ");
                         for ( int i = 0; i < shoppingCart.size(); i++)
                         {
                             System.out.println(shoppingCart.get(i));
                         }
                         System.out.println("Enter the number of the item you wish to remove. ");
                         System.out.println("Your choice?");
                         do
                         {
                         try{
                             choice = keyboard.nextInt();
                             for (int i = 0; i < shoppingCart.size(); i++)
                             {
                                 if(choice == shoppingCart.get(i).getNumber())
                                 {
                                     if (shoppingCart.get(i).getQuantity() > 1)
                                         shoppingCart.get(i).setQuantity(shoppingCart.get(i).
                                                 getQuantity()-1);
                                     else
                                     {
                                         shoppingCart.remove(shoppingCart.get(i));
                                     }
                                     judge_4 = true;
                                     System.out.println("\nItem # " + choice + 
                                             " has been removed from the shopping cart. ");
                                 }
                                 
                             }
                             if (judge_4 == false)
                                      throw new Exception("out of range");
                             System.out.println("\nDisplaying the current contents of the shopping cart ... ");
                             for ( int i = 0; i < shoppingCart.size(); i++)
                            {
                              System.out.println(shoppingCart.get(i));
                             }
                         }
                         catch(InputMismatchException e)                                  //catch the exception of non-integer
                            {
    
                                exception = keyboard.nextLine();
                                System.out.println("For input string: \"" + exception +
                              "\" is not a valid format for an integer. Please re-enter your choice. ");
                           }
                         catch (Exception e)
                             {
                               System.out.println(choice + " is not a valid choice! Please enter a number in your shopping cart");
                               System.out.println("Your choice?");
                               judge_4 = false;
                              }
                         }while(judge_4 == false);
                    }
                    break;
                    
                case 4:
                    checkOut = true;
                    break;
                default:
                    throw new Exception("out of range");
                 
                }
                
                    
            }
              catch(InputMismatchException e)                                  //catch the exception of non-integer
               {
    
                exception = keyboard.nextLine();
                System.out.println("For input string: \"" + exception +
                 "\" is not a valid format for an integer. Please re-enter your choice. ");
                }
             catch(Exception e)                                    //catch the expection of out of the range
            {
               System.out.println( choice + " is not a valid choice! Please enter a number from 1 to 4. ");
            }
            
        }while(checkOut == false);
    boolean judgeCheck = false;
    double total = 0;
    double totalAfterTax = 0.0;
    DecimalFormat df = new DecimalFormat("0.00");
   if(shoppingCart.isEmpty())
   {
       System.out.println("You bought nothing.");
   }
   else
   {
       System.out.println("\n/***************************************************"
                + "*********************************************/\n");
       System.out.println("ORDER SUMMARY: ");
       for (int i = 0; i < shoppingCart.size(); i++ )
       {
           System.out.println(shoppingCart.get(i));
           total = total + shoppingCart.get(i).getQuantity() * shoppingCart.get(i).getPrice();
       }
       totalAfterTax = total*1.06;
       System.out.println("\nOrder Total: $  " + df.format(totalAfterTax) + "  (6.0% tax included) ");
       System.out.println("\n/************************************************"
               + "************************************************/ \n");
       
       String CardName;
       String CardType;
       String ExpDate;
       String cardNumber = null;
       
       
       do{
       System.out.println("How do you wish to pay for your order? "
               + "\n(Enter 1 to charge to credit card on file or 2 to charge "
               + "to new credit card.): ");
       try{
           choice = keyboard.nextInt();
          
           if(choice > 2 || choice < 1)
                throw new Exception("out of range");
           if(choice == 1)
           {
               System.out.println("Payment summary: \n"
                       + "\nPayment amount: $ " + df.format(totalAfterTax) +
                       " charged to card on file ");
               judgeCheck = true;
           }
           else
           {
               System.out.println("Please enter your payment information: \n");
               keyboard.nextLine();
               System.out.println("Card holder name: ");
               CardName = keyboard.nextLine();
               System.out.println("Credit card type (e.g., MasterCard):");
               CardType = keyboard.nextLine();
               boolean NumberLength = false;
               boolean ifDigit = false;
               do{
                     try{
                          System.out.println("Credit card number (e.g., 5201345098756420): ");
                        //  CardNumber = keyboard.nextInt();
                         // copy = CardNumber;
                            cardNumber = keyboard.nextLine();
                            if(cardNumber.length() > 16)
                                throw new Exception("too much numbers");
                            else if(cardNumber.length() < 16)
                                throw new Exception("too less numbers");
                            else
                            {
                                NumberLength = true;
                               
                            }
                            char[] Cn = cardNumber.toCharArray();
                            for(int i = 0; i < 16; i ++)
                            {
                                if(!Character.isDigit(Cn[i]))
                                throw new Exception("must be all digit");
                            }
                          
                   }
                   catch(InputMismatchException e)                                  //catch the exception of non-integer
               {
                exception = keyboard.nextLine();
                System.out.println("For input string: \"" + exception +
                 "\" is not a valid format for an integer. Please re-enter your card number. ");
                NumberLength = false;
                }
                catch(Exception e)                                    //catch the expection of out of the range
            {
               System.out.println( "A valid card number contain 16 digits, please re-enter");
               System.out.println(e);
               NumberLength = false;
            }    
               }while(NumberLength == false);
               
                char[] CN = cardNumber.toCharArray();
               
               System.out.println("Expiration date (e.g., 10/2016): "); 
               ExpDate = keyboard.nextLine();
               System.out.println("\n/***************************************************"
                + "*********************************************/\n");
               System.out.println("Credit payment summary: \n"
                       + "\n Customer name:  " + CardName
                       + "\nPayment amount:  $  " + df.format(totalAfterTax)
                       + "\n     Card type:  " + CardType
                       + "\n   Card number:  " + "************" + 
                       CN[12] + CN[13] + CN[14] + CN[15] 
                       + "\n      Exp date:  " + ExpDate);
               judgeCheck = true;
           }
               
       }
        catch(InputMismatchException e)                                  //catch the exception of non-integer
               {
                exception = keyboard.nextLine();
                System.out.println("\nFor input string: \"" + exception +
                 "\" is not a valid format for an integer. Please re-enter your choice. \n");
                judgeCheck = false;
                }
        catch(Exception e)                                    //catch the expection of out of the range
            {
               System.out.println( "\n" +choice + " is not a valid payment option. "
                       + "\n Please enter 1 to charge to card on file or 2 to"
                       + " charge to new card. \n");
               judgeCheck = false;
            }
       }while(judgeCheck == false);
       
   }
        System.out.println("\n/***************************************************"
                + "*********************************************/\n");
        System.out.println("Thanks for shopping at Barnes & Noble Online. "
                + "\nPlease come back soon! ");
        System.out.println("\n/***************************************************"
                + "*********************************************/\n");
       
    }
    
}
