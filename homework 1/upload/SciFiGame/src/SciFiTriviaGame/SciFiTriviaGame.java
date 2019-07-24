
package SciFiTriviaGame;
import javax.swing.JOptionPane; //Program uses class JOptionPane for message dialog 
import java.util.Random;    // Program uses class random for random numbers


/**
Author:Tianqi Liu
E-mail: tzl60@psu.edu 
Course: CMPSC 221 
Assignment: Programming Assignment 1 
Due date: 2/6/2018 
File: SciFiTriviaGame.java 
Purpose: Java application that implements a simple sci-fi trivia game 
Compiler/IDE: Java SE Development Kit 8u151/NetBeans IDE 8.2 Operating 
system: MS Windows 10 
Reference(s): Java 8 API - Oracle Documentation 
             (http://docs.oracle.com/javase/8/docs/api/);  
              http://blog.csdn.net/c1481118216/article/details/51921521
              https://jingyan.baidu.com/article/0aa223754e77c188cc0d6491.html
              Demo program:
                           * SimpleStringMethodDemo 
                           * DialogBoxDemoWithSwitch
                           * MiniSciFiTriviaGame_v2
                           * MiniSciFiTriviaGame
               Savitch, 6th Edition: Chapters 1 – 4 (basics), Chapter 6 (arrays)
               Deitel & Deitel, 9th Edition: Chapter 3, Section 8 (dialog boxes) 
*/ 
 
public class SciFiTriviaGame 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
          // Define variable, object   
    Question test = new Question();
        int number = 10;
        String Number = "Number";
        System.out.printf ("%-11s:  " + "%-25d\n" , Number, number );
    

    
    String [] questions = {
             "'Star Wars: The Force Awakens' opened on what date in December 2015?",
             "What is the name of the ship used by Doctor Who to travel through space and time?",
             "What Stargate SG-1 cast member previously starred in the TV series MacGyver?",
             "Who played Number One in the first pilot for the original Star Trek series?",
             "In what U.S. state is Warehouse 13 located?",
             "What is the answer to the ultimate question of life, the universe, and everything? \n (in number)",
             "Is Overwatch an FPS game?",
             "By the end of 2017, there are how many Star Wars movies?",
             "What is the capital of China?",
             "Which team is the champion of Super Bowl in 2018?"
            };
    String [] answers ={"18", "Tardis", "Richard Dean Anderson", "Majel Barrett", "South Dakota","42","Yes","9","Beijing","Philadelphia Eagles"};
  
  
    String defaultMessage = "Changed your mind? Come play again soon!";
    String showChoice = "\nDo you want to play again (Y/N)? ";
    String defaultGoodbye = "\nThanks for playing this game!!";
    String playAgain;
   
    Object[] options = {"Y","N"}; 
    Random rnd = new Random();
    int randomNumber;
    JOptionPane.showMessageDialog(null, "Welcome to trivia game!!","Trivia game", JOptionPane.INFORMATION_MESSAGE);
    boolean judge = true;
    do{
      randomNumber = rnd.nextInt(10);    // Random number from 0 to 9
      
      test.setText(questions[randomNumber]);
      test.setAnswer(answers[randomNumber]);
     // test.displayQuestion();
      
    
       String userResponse;
       String message = null;
       String defaultResponse = "Your answer?";
       
      userResponse = JOptionPane.showInputDialog(null,questions[randomNumber], defaultResponse);
      
      if (userResponse == null || userResponse.equals(defaultResponse))
           message = "Changed your mind? Come play again soon!";
      else if (!userResponse.equals(defaultResponse))
      {
        if(test.checkAnswer(userResponse))
           message = "You are correct!   :-)";
        else 
           message = "Sorry, but you are wrong.   :-(";
      }
    // Display the message
       JOptionPane.showMessageDialog(null, message,"Trivia game", JOptionPane.INFORMATION_MESSAGE);
            do{
            playAgain = (String) JOptionPane.showInputDialog(null, "\nDo you want to play again (Y/N)?", "Trivia game",
                              JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
            
            if (playAgain == null)
            {
                judge = false;
                JOptionPane.showMessageDialog(null, "If you want to quit, please choose N and click yes : )  ","Trivia game", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                judge = true;
                
            
            }while(judge == false);
            
        } while(playAgain.equalsIgnoreCase("Y"));
    
    JOptionPane.showMessageDialog(null, defaultGoodbye,"Trivia game", JOptionPane.INFORMATION_MESSAGE);

    }
    
    
    
    static class Question
    {
     private String Text;
     private String CorrectResponse;
     public boolean Response;
     
     
     /**
      * A default constructor to initialize the question and answer 
     */
     public Question()
     {
      Text = null;
      CorrectResponse = null;
      Response = false;
      }
     
     /**
      * A “set” method to assign text to the question
     */
     public void setText(String text)
      {
        Text = text;
       }
     
       /**
      *  A “set” method to assign the correct response to the question answer 
     */
      public void setAnswer(String correctResponse)
      {
        CorrectResponse = correctResponse;  
      }
      
       /** A method to check if the user’s response is correct or incorrect
        *  @return    true is the response was correct, false otherwise
      */
       public boolean checkAnswer (String response)
      {
        response = response.toUpperCase().trim();  
        CorrectResponse = CorrectResponse.toUpperCase().trim();
        // Convert string to uppercase (if appropriate)
        //Strip out leading and trailing spaces (if appropriate)
        return response.equalsIgnoreCase(CorrectResponse);
      }
     
     
     /**
      *  A method to display the question to the user 
      *  Let user input his or her answer
      *  And tell him or her if the answer was right
      */
      public void displayQuestion()
     {
       String userResponse;
       String message = null;
       String defaultResponse = "Your answer?";
       
      userResponse = JOptionPane.showInputDialog(Text, defaultResponse);
     
      if (userResponse == null || userResponse.equals(defaultResponse))
           message = "Changed your mind? Come play again soon!";
      else if (!userResponse.equals(defaultResponse))
      {
        if(checkAnswer(userResponse))
           message = "You are correct! :-)";
        else 
           message = "Sorry, but you are wrong. :-(";
      }
    // Display the message
    
        JOptionPane.showMessageDialog(null, message);
     }
    
    }
}
