import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      if (n <= 0)  // The smallest list we can make
      {
          tempList = new ArrayList<Integer>(0);
      }
      else        // All other size lists are created here
      {
          tempList = makeList(n-1);
          tempList.add(n);
      }
      return tempList;
   }
   
   public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
   {
       ArrayList<Integer> list = ListMethods.deepClone(tList); 
       if (list.size() == 0)// The list is empty or has one element
       {
           // Return the list as is – no need to reverse!
       }
       else
       {
           // Use the solution to a smaller version of the problem
           // to solve the general problem
           int tempInt = list.get(0);
           list.remove(0);
           list = reverseList(list);
           list.add(tempInt);
       }
       return list;
    }
   
   public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
   {
       ArrayList<Integer> list = new ArrayList<Integer>(); 
       for (Integer i : tList)
       {
           list.add(new Integer(i));
       }
       return list;
   }
   
    public static void main(String[] args)
   {
      ArrayList<Integer> list = new ArrayList<Integer>(0);
      list.add(10);
      list.add(5);
      list.add(20);
      ArrayList<Integer> tempList = ListMethods.reverseList(list);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
   }
}
