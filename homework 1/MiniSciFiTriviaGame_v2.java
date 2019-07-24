// MiniSciFiTriviaGame_v2.java

package miniscifitriviagame_v2;

import java.util.Scanner;   // Program uses class Scanner for input

/** This class implements version 2 of the mini Sci-Fi trivia game.
 *  It demonstrates topics from Chapters 1, 2, and 3.
 *
 * @author Wanda Kunkle
 * @version 1.1
 */
public class MiniSciFiTriviaGame_v2 {

    // Maximum number of questions
    private static final int MAX_QUESTIONS = 5;

    /** This method begins execution of the Java application.
     *
     * @param args      An array containing the command line arguments
     */
    public static void main(String[] args) {

        // Create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        // Create String objects
        String divider =
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        // Array to store questions
        String[] questions =
            {"'Star Wars: The Force Awakens' opened on what date in December 2015?",
             "What is the name of the ship used by Doctor Who to travel through space and time?",
             "What Stargate SG-1 cast member previously starred in the TV series MacGyver?",
             "Who played Number One in the first pilot for the original Star Trek series?",
             "In what U.S. state is Warehouse 13 located?"};

        // Array to store answers
        String[] answers =
            {"18", "Tardis", "Richard Dean Anderson", "Majel Barrett", "South Dakota"};

        String userAnswer, response;

        do {
            System.out.print(divider);

            // Welcome user; prompt for and obtain choice
            System.out.print("\nWelcome to the Mini Sci-Fi TV and Movie Trivia Game!\n");
            System.out.print("\nChoose 1 for \"Star Wars\", 2 for \"Doctor Who\","
                + " 3 for \"Stargate SG-1\",\n       4 for \"Star Trek\","
                + " 5 for \"Warehouse 13\".");
            System.out.print("\nYour choice? ");

            int choice = input.nextInt();

            // Get rid of end-of-line character ('\n'); otherwise, the
            // user will not have an opportunity to enter his/her answer
            String endOfLineCharacter = input.nextLine();

            System.out.print(divider);

            // Classify user's choice and proceed accordingly
            switch(choice)
            {
                case 1: case 2: case 3: case 4: case 5:
                    // Display question and prompt for answer
                    System.out.print("\n" + questions[choice - 1]);
                    System.out. print("\nYour answer? ");
                    userAnswer = input.nextLine();
                    // Check answer and respond accordingly
                    if (userAnswer.equalsIgnoreCase(answers[choice - 1]))
                        System.out.print("\nYou are correct!\n");
                    else
                        System.out.print("\nNice try, but no.\n");
                    break;
                default:
                    System.out.println("\nNo such choice! "
                        + "Did you not note that this is a MINI trivia game?!?");
            } // End switch

            System.out.print("\nDo you want to play again (Y/N)? ");
            response = input.nextLine();

        } while(response.equalsIgnoreCase("Y"));

        System.out.print(divider);

        System.out.print("\nThanks for playing the Mini Sci-Fi TV and Movie Trivia Game!\nCome again soon!\n");

        System.out.print(divider + "\n");

    } // End main

} // End class
