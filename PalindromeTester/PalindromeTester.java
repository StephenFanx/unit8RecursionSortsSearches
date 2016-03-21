import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
   public static void main (String[] args)
   {
      String str, another = "y";
      int left, right;
      Scanner s = new Scanner(System.in);

      while (another.equalsIgnoreCase("y")) // allows y or Y
      {
         System.out.println ("Enter a potential palindrome:");
         str = s.nextLine();

         left = 0;
         right = str.length() - 1;

         while (str.charAt(left) == str.charAt(right) && left < right)
         {
            left++;
            right--;
         }

         System.out.println();

         if (left < right)
            System.out.println ("That string is NOT a palindrome.");
         else
            System.out.println ("That string IS a palindrome.");

         System.out.println();
         System.out.print ("Test another palindrome (y/n)? ");
         another = s.nextLine();
      }
   }
   
   public static boolean isPalindrome(String str)
   {
       if (string.length() <= 1)
       {
           return true;
       }
       
       String substr = str.substring(1,str.length() -1);
       
       return ((str.charAt(0) == str.charAt(str.length()-1)) &&isPalindrome(substr));
   }
}
