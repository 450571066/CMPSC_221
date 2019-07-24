package movie;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
Author:Tianqi Liu
E-mail: tzl60@psu.edu 
Course: CMPSC 221 
Assignment: Programming Assignment 2 
Due date: 2/27/2018 
File: movieProject.java, Movie.java, AwardWinningMovie.java
Purpose: Java application that implements a simple movie introductions,
         user could display them alphabetically by default or by genre 
Compiler/IDE: Java SE Development Kit 8u151/NetBeans IDE 8.2 Operating 
system: MS Windows 10 
Reference(s): Java 8 API - Oracle Documentation 
              Demo program: HourlyEmployee.java
              Savitch, 6th Edition: Chapters 1 – 7, 9 
               
*/ 
public class movieProject 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       System.out.println("EXPERIMENTAL AWARD-WINNING MOVIE DATABASE*\n-----------------------------------------\n"
               + "       (*Funded in part by IMDb.com\n");
       Scanner keyboard = new Scanner(System.in);
       int toNumber;
       String choice;
       AwardWinningMovie[] obj = new AwardWinningMovie[10];
       obj[0] = new AwardWinningMovie("The Queen ", "PG-13 ", "Biography ",
               "Stephen Frears", "Helen Mirren", "Oscar for Best Performance by an Actress in a Leading Role", 2007);
       obj[1] = new AwardWinningMovie("Driving Miss Daisy","PG","Drama",
                "Bruce Beresford","Morgan Freeman","Golden Globe for Best Performance by an Actor in a Motion Picture - Comedy or Musical",1990);
       obj[2] = new AwardWinningMovie("Forrest Gump","PG-13","Drama",
                " Robert Zemeckis","Tom Hanks","Academy Awards, USA",1995);
       obj[3] = new AwardWinningMovie("Raiders of the Lost Ark","PG","Action",
                "Steven Spielberg","Harrison Ford","Saturn Award for Best Actor",1982);
       obj[4] = new AwardWinningMovie("X-Men","PG-13","Action", 
                "Bryan Singer","Hugh Jackman","Saturn Award for Best Actor",2001);
       obj[5] = new AwardWinningMovie("Star Trek Into Darkness","PG-13","Sci-Fi",
                "J.J. Abrams","Chris Pine","ASCAP Award for Top Box Office Films",2014);
       obj[6] = new AwardWinningMovie("La La Land","PG-13","Comedy",
                " Damien Chazelle"," Ryan Gosling","Academy Awards, USA ",2017);
       obj[7] = new AwardWinningMovie("Sophie's Choice","R","Drama",
                " Alan J. Pakula"," Meryl Streep","Best Actress in a Leading Role",1983);
       obj[8] = new AwardWinningMovie("Contact","PG","Drama"," Robert Zemeckis",
                " Jodie Foster","Best Sound Oscar",1998);
       obj[9] = new AwardWinningMovie("Titanic","PG-13","Drama",
                "James Cameron"," Leonardo DiCaprio","Oscar-Best Art Direction-Set Decoration",1998);

                                                                                     //initialize ten AwardWinningMovies
       AwardWinningMovie Change;
    
       for (int i = 0; i < 9; i++)
       {
           for(int j = 1; j < 10; j++)
           {
                if ((obj[i].getTitle()).compareToIgnoreCase(obj[j].getTitle()) < 0)
                {
                      Change = obj[i];
                      obj[i] = obj[j];
                      obj[j] = Change;
                }
           }
       }
       Change = obj[0];
       for (int i = 0; i < 9; i ++)
       {
            obj[i] = obj[i+1];
       }
       obj[9] = Change;
       
       Change = obj[7];
       obj[7] = obj[8];
       obj[8] = Change;
                                                                    //adjust the order of objects
                                                                               
       int [] Number = {1 ,2 ,3, 4, 5, 6, 7, 8, 9, 10};
       
       
       
       
       //extra credit
       System.out.println("Do you want to search by one of the AwardWinningMovie attributes? (Y for yes and others for no)  ");
       String want = keyboard.nextLine();
       boolean judgeForSearch = false;
       int year;
       String keyWord;
       
       while(want.equalsIgnoreCase("y"))
       {
           year = 0;
           keyWord = null;
           
           try{
           System.out.println("Please enter the attributes you wand to search: (1 for Title, 2 for Rating, 3 for Genre, 4 for Director,"
                   + " 5 for Star, 6 for Award title or 7 for Award year)");
           int search = keyboard.nextInt();
           
           if(search == 7)
           {
               System.out.println("Please enter the year you want to search: ");
               year = keyboard.nextInt();
               for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getAwardYear() == year)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
               keyboard.nextLine();
           } 
           else
           {
           System.out.println("Please enter the key word you want to search: ");
           keyboard.nextLine();
           keyWord = keyboard.nextLine();
           System.out.println("These are the results: \n");
           
           switch(search)
           {
               case 1:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getTitle().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               case 2:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getRating().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               case 3:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getGenre().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               case 4:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getDirector().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               case 5:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getStar().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               case 6:
                   for(int i = 0; i < 10; i++)
                   {
                       if(obj[i].getAwardTitle().indexOf(keyWord) > -1)
                       {
                           System.out.println(obj[i].toString());
                           System.out.println();
                           judgeForSearch = true;
                       }
                   }
                   break;
               default:
                   System.out.println("You entered a wrong number!");
                   break;
                }
           }
           
           }
           catch(InputMismatchException e)                                  //catch the exception of non-integer
           {
               System.out.println("You entered a non-integer");
               System.out.println(e.toString());
           }


           if (judgeForSearch == false)
               System.out.println("Sorry, there is no such thing\n");
           
           System.out.println("Do you want to search again? (y for yes and others for no)");
           want = keyboard.nextLine(); 
           
       }
       
       
       
       
           boolean runTotal = true;
           boolean judge = false;
           String userChoose = null;
       do{
       
       
       System.out.println(" Movie titles are displayed alphabetically by default.\n "
               + "To display them alphabetically by genre, type G at the prompt.\n"
               + " Otherwise, simply press <Enter>.\n "
               + "\n  Your preference? ");
       userChoose = keyboard.nextLine();
       
      char judge_2;
      
      if(userChoose.isEmpty())
      {
          int userChooseInInt = 0;
          judge = false;
          System.out.println("Selected award-winning movies: ");
          for (int i = 0; i < 10; i++)
              System.out.println( Number[i] + ") " + obj[i].getTitle());
          System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                  + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
         do{
          System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
          
          do{
             userChooseInInt = -1;                              //initialize the variable every time before use it
          try{
              userChooseInInt = keyboard.nextInt();
              if(userChooseInInt > 10 || userChooseInInt < 1)
                  throw new Exception("out of range");
              judge = true;
          }
          catch(InputMismatchException e)                       //catch the exception of non-integer
          {
              keyboard.nextLine();
              System.out.println("Movie choice must be an integer. Please try again.");
              System.out.println(e.toString());
              System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
              judge = false;
          }
          catch(Exception e)                                    //catch the expection of out of the range
          {
              keyboard.nextLine();
              System.out.println("Please only enter an integer from 1-10");
              System.out.println(e.toString());
              System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
             judge = false;
          }
      }while(judge == false);
          
          System.out.println(obj[userChooseInInt - 1].toString());
          
          System.out.println("\nInquire about another movie (Y/N)? ");
          
          keyboard.nextLine();
          do{                                               //prevent user enter other things
              choice = null;
              judge = false;
              try{
                  
                  choice = keyboard.nextLine();
                  
                  if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                  {
         
                    throw new Exception("do not match");
                  }
                  judge = true;
              }
              catch(Exception e)
              {
                 //keyboard.nextLine();
                  System.out.println("Please only enter y or n.");
                  System.out.println("\nInquire about another movie (Y/N)? ");
              }
          }while(judge == false);
           System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                  + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
          
          }while(choice.equalsIgnoreCase("Y"));                 //don't stop if user choose yes
         runTotal = true;
        }
      
      
      //user choose genre sort
      else if(userChoose.equalsIgnoreCase("G"))
      {
          int userChooseInInt = 0;
          judge = false;   
          AwardWinningMovie[] toMovie = new AwardWinningMovie[10];
           
          toMovie[0] = obj[4];
          toMovie[1] = obj[9];
          toMovie[2] = obj[7];
          toMovie[3] = obj[3];
          toMovie[4] = obj[0];
          toMovie[5] = obj[1];
          toMovie[6] = obj[2];
          toMovie[7] = obj[5];
          toMovie[8] = obj[8];
          toMovie[9] = obj[6];
          
          Number[0] = 5;
          Number[1] = 10;
          Number[2] = 8;
          Number[3] = 4;
          Number[4] = 1;
          Number[5] = 2;
          Number[6] = 3;
          Number[7] = 6;
          Number[8] = 9;
          Number[9] = 7;
          
                          // sort by genre
          
          System.out.println(" Selected award-winning movies by genre: ");
          String Midpoint = null;
          for(int i = 0; i < 10 ; i ++)
          {
              if(!toMovie[i].getGenre().equalsIgnoreCase(Midpoint))
              {
                  Midpoint = toMovie[i].getGenre();
                  System.out.println(toMovie[i].getGenre() );
              }
              System.out.println("\t" + Number[i] + ") " + toMovie[i].getTitle());
          }
          System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                  + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
          
            do{
          System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
          
          do{
              userChooseInInt = -1;
          try{
              userChooseInInt = keyboard.nextInt();
                
              if(userChooseInInt > 10 || userChooseInInt < 1)
                  throw new Exception("out of range");
              judge = true;
          }
          catch(InputMismatchException e)               //catch the exception of non-integer
          {
              keyboard.nextLine();
              System.out.println("Movie choice must be an integer. Please try again.");
              System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
              judge = false;
             
          }
          catch(Exception e)                            //catch the exception out of range
          {
              keyboard.nextLine();
              System.out.println("Please only enter an integer from 1-10");
              System.out.println("Please enter the number of the movie "
                  + "you would like to know more about: ");
              judge = false;

          }
      }while(judge == false);
          
          System.out.println(obj[userChooseInInt-1].toString());
          
           System.out.println("\nInquire about another movie (Y/N)? ");
          
          choice = null;
          judge = false;
          keyboard.nextLine();
          do{
              try{
                  
                  choice = keyboard.nextLine();
                  if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                  {
                      throw new Exception("do not match");
                  }
                  judge = true;
              }
              catch(Exception e)
              {
                  System.out.println("Please only enter y or n.");
                  System.out.println("\nInquire about another movie (Y/N)? ");
              }
          }while(judge == false);
           System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                  + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
          
          }while(choice.equalsIgnoreCase("Y"));
          runTotal = true;
      }
      else
      {
          System.out.println("You entered a wrong choice, please try it again.\n");
          runTotal = false;
      }
      }while(runTotal == false);
          
     
      System.out.println("Thanks for using our experimental database! ");
      
      
      }

}

   