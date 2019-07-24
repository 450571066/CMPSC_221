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
 public class Movie
    {
        private String title;
        private String rating;
        private String genre;
        private String director;
        private String star;
       
        public Movie()
        {
            title = null;
            rating = null;
            genre = null;
            director = null;
            star = null;
        }
        public Movie(String Title, String Rating, String Genre,String Director, String Star)
        {
            title = Title;
            rating = Rating;
            genre = Genre;
            director = Director;
            star = Star;
        }
        /**
         * @param Title set up the title 
         */
        public void setTitle(String Title)
        {
                    if (Title == null)
            {
             System.out.println("Fatal Error setting title.");
             System.exit(0);
            }
            else
            title = Title;
        }
         /**
         * @param rating set up the rating 
         */
         public void setRating(String Rating)
        {
                    if (Rating == null)
            {
             System.out.println("Fatal Error setting rating.");
             System.exit(0);
            }
            else
            rating = Rating;
        }
          /**
         * @param genre set up the genre 
         */
         public void setGenre(String Genre)
        {
                    if (Genre == null)
            {
             System.out.println("Fatal Error setting genre.");
             System.exit(0);
            }
            else
            genre = Genre;
        }
          /**
         * @param director set up the director 
         */
         public void setDirector(String Director)
        {
                    if (Director == null)
            {
             System.out.println("Fatal Error setting director.");
             System.exit(0);
            }
            else
            director = Director;
        }
          /**
         * @param star set up the star 
         */
        public void setStar(String Star)
        {
                    if (Star == null)
            {
             System.out.println("Fatal Error setting star.");
             System.exit(0);
            }
            else
            star = Star;
        }
         /**
         * @return to let outside function access private variables. 
         */
        public String getTitle()
        {
            return title;
        }
         public String getRating()
        {
            return rating;
        }
         public String getGenre()
        {
            return genre;
        } 
         public String getDirector()
        {
            return director;
        }
         public String getStar()
        {
            return star;
        }
        /**
         * 
         * @param other argument of other movie
         * @return the result if two movies are equal
         */
        public boolean equals(Movie other)
        {
            return (title.equals(other.getTitle()) && rating.equals(other.getRating()) 
                    && genre.equals(other.getGenre()) && director.equals(other.getDirector()) 
                    && star.equals(other.getStar()));
        }
        /**
         * 
         * @return the standard output
         */
        public String toString()
        {
            return ("Title:     " + getTitle() + "\n" +
                    "Rating:    " + getRating() + "\n" +
                    "Genre:     " + getGenre() + "\n" +
                    "Director:  " + getDirector() + "\n" +
                    "Star:      " + getStar());
        }
       
    }
    
