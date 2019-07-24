package movie;

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

         public class AwardWinningMovie extends Movie
        {
            
            private String awardTitle;
            private int awardYear;
            public AwardWinningMovie()
            {
                super(null,null,null,null,null);
                awardTitle = null;
                awardYear = 0;
             }
            
            public AwardWinningMovie(String Title, String Rating, String Genre, 
                    String Director, String Star, String AwardTitle, int AwardYear)
            {
                super(Title, Rating, Genre, Director, Star);
                if(!AwardTitle.equals(null) && AwardYear >= 0)
                {
                    awardTitle = AwardTitle;
                    awardYear = AwardYear;
                }
                else
                {
                     System.out.println(
                       "Fatal Error: creating an illegal Award winning movie.");
                     System.exit(0);
                }
            }
            /**
             * 
             * @param otherObject set up AwardWinningMovie by using other AwardWinningMovie
             */
            public AwardWinningMovie(AwardWinningMovie otherObject)
            {
                super(otherObject.getTitle(), otherObject.getRating(), otherObject.getGenre(),
                        otherObject.getDirector(), otherObject.getStar());
                awardTitle = otherObject.awardTitle;
                awardYear = otherObject.awardYear;
            }
            
            public void setAwardTitle(String AwardTitle)
            {
                if(!AwardTitle.equals(null))
                    awardTitle = AwardTitle;
                else
                {
                    System.out.println("Fatal Error: Empty award title.");
                    System.exit(0);
                }
            }
              public void setAwardYear(int AwardYear)
            {
                if(AwardYear != 0)
                    awardYear = AwardYear;
                else
                {
                    System.out.println("Fatal Error: Empty award year.");
                    System.exit(0);
                }
            }
              /**
               * 
               * @return the value and let outside function to access private variables
               */
              public String getAwardTitle()
              {
                  return awardTitle;
            
               }
              public int getAwardYear()
              {
                  return awardYear;
              }
              
              public boolean equals(AwardWinningMovie other)
              {
                  return(getTitle().equals(other.getTitle()) && getRating().equals(other.getRating()) 
                    && getGenre().equals(other.getGenre()) && getDirector().equals(other.getDirector()) 
                    && getStar().equals(other.getStar())&&awardTitle.equals(other.getAwardTitle()) && 
                          (awardYear == other.getAwardYear()));
              }
              
              public String toString()
              {
                  return("Title:     " + getTitle() + "\n" +
                    "Rating:    " + getRating() + "\n" +
                    "Genre:     " + getGenre() + "\n" +
                    "Director:  " + getDirector() + "\n" +
                    "Star:      " + getStar()+ "\n" +
                    "Award:     " + awardTitle + 
                          " , " + awardYear);
              }
        }

