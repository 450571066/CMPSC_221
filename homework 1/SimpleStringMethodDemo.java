// Program SimpleStringMethodDemo.java

package simplestringmethoddemo;

/** This class implements a simple Java application and
 *  demonstrates several String methods (Savitch 1.3).
 *
 * @author Wanda Kunkle
 * @version 1.0
 */
public class SimpleStringMethodDemo {

    /** This method begins execution of the Java application.
     * 
     * @param args      An array containing the command line arguments.
     */
    public static void main(String[] args) {
        
        // Create some String objects
        String firstName = "George", middleName = "Walton", lastName = "Lucas";
        
        // Concatenate to create full name
        String fullName = firstName + " " + middleName + " " + lastName;
        
        // Display program purpose
        System.out.println("String Method Demo:");
        
        // Display label
        System.out.println("\nStar Wars Creator:");
        // Display full name in uppercase letters
        System.out.println(fullName.toUpperCase());
        
        // Store social security (SS) number as String
        String socialSecurityString = " 123456789 ";
        // Trim leading and trailing spaces
        socialSecurityString = socialSecurityString.trim();
        // Locate position of digit that is fourth from last by subtracting
        // four from String length
        int startOfLastFour = socialSecurityString.length() - 4;
        // Retrieve last four digits
        String lastFourDigits = socialSecurityString.substring(startOfLastFour);
        
        // Display label
        System.out.println("\nSS Number:");
        // Display SS number with first five digits masked out
        System.out.println("*****" + lastFourDigits);
        
        // Display blank line
        System.out.println();      
    }
    
}
