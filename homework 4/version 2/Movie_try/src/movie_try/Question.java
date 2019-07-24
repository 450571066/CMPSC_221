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


/**
 *
 * @author Tianqi
 */
public class Question {
    public String question;
    public String answer;
    public int pointValue;
                                    //constructor
    public Question(String Question, String Answer, int PointValue)
    {
        question = Question;
        answer = Answer;
        pointValue = PointValue;
    }
    
    public void setQustion(String Question)
    {
        question = Question;
    }
    
    public void setAnswer(String Answer)
    {
        answer = Answer;
    }
    
    public void setPointValue(int PointValue)
    {
        pointValue = PointValue;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public int getPointValue()
    {
        return pointValue;
    }
}
