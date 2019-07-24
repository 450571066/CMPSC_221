// DialogBoxDemoWithSwitch.java (Chapters 3 & 5)

package dialogboxdemowithswitch;

import javax.swing.JOptionPane;

/** This class demos basic input with a dialog box as well
 *  as the enhanced version of the "switch" statement.
 *
 * @author wmk12 and D. & D.
 * @version 5
 */
public class DialogBoxDemoWithSwitch {

    /** This method begins execution of the Java application (method description)
     * 
     * @param args      An array containing the command line arguments
     */
    public static void main(String[] args) {
        
        // Declare/define objects
        String message;
        String defaultMessage = "Changed your mind? Come play again soon!";
        String question =
            "What is the answer to the ultimate question of life, the universe, and everything?";
        String defaultResponse = "Your answer?";
        
        // Prompt user to enter answer
        String userResponse =
            JOptionPane.showInputDialog(question, defaultResponse);
      
        // Check if the user clicked Cancel (returns null) or chose to accept
        // the default response; "equals" is used here to compare two strings
        // for equality
        // Reference for Strings: Chapter 16 of D. & D.
        if (userResponse == null || userResponse.equals(defaultResponse))
            JOptionPane.showMessageDialog(null, defaultMessage);
        // The user entered a valid response
        else if (!userResponse.equals(defaultResponse))
        {
            // Convert string to uppercase (if appropriate);
            // Strip out leading and trailing spaces (if appropriate)
            // Reference: Chapter 16 of D. & D.
            userResponse = userResponse.toUpperCase().trim();
        
            // Check answer
            switch(userResponse)
            {
                case "42":
                case "FORTY-TWO":
                case "FORTY TWO":    
                    message = "You are correct!";
                    break;
                default:
                    message = "Sorry, but no.  :-(";
            } // end switch
         
            // Display the message
            JOptionPane.showMessageDialog(null, message);
        }
        
    }
    
}
