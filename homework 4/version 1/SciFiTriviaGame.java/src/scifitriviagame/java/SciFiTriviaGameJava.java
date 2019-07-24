/*
Author: Tianqi Liu
E-mail: tzl60@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due date: 4/24/2018
File: SciFiTriviaGame.java
Purpose: Java application that implements a simple sci-fi trivia game
 with a GUI
Compiler/IDE: Java SE Development Kit 8u151/NetBeans IDE 8.2
Operating
system: MS Windows 10
Reference(s): Java 8 API - Oracle Documentation
 (http://docs.oracle.com/javase/8/docs/api/);
(Include ALL additional references (Web page, etc.) here.)
*/ 
package scifitriviagame.java;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.GridLayout;


/**
 *
 * @author Tianqi
 */
public class SciFiTriviaGameJava {

    public static final int WIDTH = 750;
    public static final int HEIGHT = 250;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
     ArrayList<Question> questionList = new ArrayList<Question>();
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
     }
                                                                                    //pre-set the questions to question array list
    JFrame firstWindow = new JFrame();
    
    firstWindow.setLayout(new GridLayout(9,1));
    firstWindow.setSize(WIDTH, HEIGHT);                                             //set size
    firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    firstWindow.setVisible(true);
    firstWindow.setTitle("SiFi Trivia Game");
    JButton checkButton = new JButton("Submit");
    submitListener buttonEar = new submitListener();
    checkButton.addActionListener(buttonEar);
    JLabel printQuestion = new JLabel("");
    JLabel printCheck = new JLabel("Click to check answer: ");
    JLabel printScore = new JLabel("");
    String defaultAnswer = "Your answer?";                                          //pre-set all lables and button 
    JTextField input = new JTextField(defaultAnswer);
    JPanel blank_1 = new JPanel();
    JPanel blank_2 = new JPanel();
    JPanel blank_3 = new JPanel();
    JPanel blank_4 = new JPanel();
    int scoreCounter = 0;
    boolean answerCorrect = false;
    String userAnswer;
    
    firstWindow.add(printScore);
    firstWindow.add(blank_1);
    firstWindow.add(printQuestion);
    firstWindow.add(blank_2);
    firstWindow.add(input);
    firstWindow.add(blank_3);
    firstWindow.add(printCheck);
    firstWindow.add(blank_4);
    firstWindow.add(checkButton);                                                   //set a visible frame
    
    int rightnum;
    for(int i = 0; i < 10; i ++)
    { 
        rightnum = i + 1;
        printQuestion.setText("Question " + rightnum + ": " + questionList.get(i).getQuestion());
        do{
               
        }while(!buttonEar.getJudge());                                              //only stop when click on "submit"
        
          userAnswer = input.getText().trim();
          input.setText(defaultAnswer);
          if(userAnswer.equalsIgnoreCase(questionList.get(i).getAnswer()))
          {
              scoreCounter += questionList.get(i).getPointValue();                  //count for score if correct
              answerCorrect = true;  
          }
          else
          {
              answerCorrect = false;        
          }
        
       
            if(answerCorrect)
                 printScore.setText("This is correct! Your score is " + scoreCounter);
            else
                printScore.setText("Wrong. The correct answer is " + questionList.get(i).getAnswer() +". Your score is " + scoreCounter);
            
            buttonEar.setJudge();
    }
                                                                                    //after all questions are done, only show the score and thanks
       printScore.setVisible(false);
       printQuestion.setText("All questions are done, Thanks for playing! your score is " + scoreCounter);
       printCheck.setVisible(false);
       input.setVisible(false);
       checkButton.setVisible(false);

    }
    
  

    
    }
    
   
    
    

