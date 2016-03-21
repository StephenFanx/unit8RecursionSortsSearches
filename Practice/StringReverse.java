

/**
 * Write a description of class StringReverse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringReverse
{
    /** description of instance variable x (add comment for each instance variable) */


    /**
     * Default constructor for objects of class StringReverse
     */
    public static String reverse(String text)
    {
        // initialise instance variables
        if (text.length() == 1)
        {
            return text;
        }
        
        char c = text.charAt(0);
        String rest = text.substring(1);
        String reverseText = reverse(rest);
        reverseText += c;
        
        return reverseText;
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public static void main (String[] args)
    {
        // put your code here
        System.out.println(StringReverse.reverse("Hello"));
        System.out.println("Expected: elloH");
    }

}
