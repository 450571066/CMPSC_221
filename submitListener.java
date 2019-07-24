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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tianqi
 */
 public class submitListener implements ActionListener
    {
        boolean judge;
        public void actionPerformed(ActionEvent e)
        {
            judge = true;
        }
        public boolean getJudge()
        {
            return judge;
        }
        public void setJudge()
        {
            judge = false;
        }
    }
