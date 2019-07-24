/*
Author: Tianqi Liu
E-mail: tzl60@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 4/24/2018
File: Movie_try.java
Purpose: Java application that implements a simple sci-fi trivia game
 with a GUI
Compiler/IDE: Java SE Development Kit 8u151/NetBeans IDE 8.2
Operating
system: MS Windows 10
Reference(s): Java 8 API - Oracle Documentation
 (http://docs.oracle.com/javase/8/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/ 
package movie_try;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Tianqi
 */
public class Movie_try extends JFrame implements ActionListener {
    
    public static final int WIDTH = 750;
    public static final int HEIGHT = 250;
    ArrayList<Question> questionList = new ArrayList<Question>();
    JButton checkButton = new JButton("Submit");
    JLabel printQuestion = new JLabel("");
    JLabel printCheck = new JLabel("Click to check answer: ");
    JLabel printScore = new JLabel("");
    String defaultAnswer = "Your answer?";
    JTextField input = new JTextField(defaultAnswer);
    JPanel blank_1 = new JPanel();
    JPanel blank_2 = new JPanel();
    JPanel blank_3 = new JPanel();
    JPanel blank_4 = new JPanel();
    int scoreCounter = 0;
    boolean answerCorrect = false;
    String userAnswer;
    int countNum = 0;
    int rightNum = 1;
    
    /*
    main function
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Movie_try movie=new Movie_try();        //call the constructor
        movie.setVisible(true);                 //set visible to true
        
    }
    /*
    constructor
    */
    public Movie_try()
    {
     Question presetQuestion;
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
     for(int i = 0; i < 10; i++)
     {
         presetQuestion = new Question(questions[i], answers[i], i%3 + 1);
         questionList.add(presetQuestion);
     }                                                                                          //set question arraylist
        
    setLayout(new GridLayout(9,1));                                                             //set layout mode
    setSize(WIDTH, HEIGHT);                                                                     //set size
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                             //set close button to exit
 
    printQuestion.setText("Question " + rightNum + ": " + questionList.get(countNum).getQuestion());
    setTitle("SiFi Trivia Game");
    printScore.setText("");
    checkButton.addActionListener(this);                                                                           
        
    add(printScore);
    add(blank_1);
    add(printQuestion);
    add(blank_2);
    add(input);
    add(blank_3);
    add(printCheck);
    add(blank_4);
    add(checkButton);                                                                           //construct a visible frame
    
    }
    
    @Override
     public void actionPerformed(ActionEvent e){
         if(countNum < 9){
        
          userAnswer = input.getText().trim();
          input.setText(defaultAnswer);                                                        //re-set default text
          if(userAnswer.equalsIgnoreCase(questionList.get(countNum).getAnswer()))
          {
              scoreCounter += questionList.get(countNum).getPointValue();
              answerCorrect = true;

          }
          else
          {
              answerCorrect = false;
          }
        
                                                                                                //change the words in JLables
            if(answerCorrect)
                 printScore.setText("This is correct! Your score is " + scoreCounter);
            else
                printScore.setText("Wrong. The right answer is " +  questionList.get(countNum).getAnswer() +". Your score is " + scoreCounter);
            countNum ++;
            rightNum ++;
            printQuestion.setText("Question " + rightNum + ": " + questionList.get(countNum).getQuestion());
       
        }
         else{                                                                                  //afer all questions are done, only show score and thanks
       printScore.setVisible(false);
       printQuestion.setText("All questions are done, thanks for playing! Your score is " + scoreCounter);
       printCheck.setVisible(false);
       input.setVisible(false);
       checkButton.setVisible(false);
         }
         
         
     }
}
