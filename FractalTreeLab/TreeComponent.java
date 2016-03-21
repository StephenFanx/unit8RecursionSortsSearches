import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreeComponent extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double SQ = Math.sqrt(3.0) / 6;
   private final double branchingAngle = 30.0;
   private final double fractionLength = 0.7;

   private final int TOPX = 200, TOPY = 20;
   private final int LEFTX = 60, LEFTY = 300;
   private final int RIGHTX = 340, RIGHTY = 300;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreeComponent (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int order, int x1, int y1, int x5, int y5,
                            Graphics page)
   {
      int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

      if (order == 1)
         page.drawLine (x1, y1, x5, y5);
      else
      {
         deltaX = x5 - x1;  // distance between end points
         deltaY = y5 - y1;

         x2 = x1 + deltaX / 3;  // one third
         y2 = y1 + deltaY / 3;

         x3 = (int) ((x1+x5)/2 + SQ * (y1-y5));  // tip of projection
         y3 = (int) ((y1+y5)/2 + SQ * (x5-x1));

         x4 = x1 + deltaX * 2/3;  // two thirds
         y4 = y1 + deltaY * 2/3;

         drawFractal (order-1, x1, y1, x2, y2, page);
         drawFractal (order-1, x2, y2, x3, y3, page);
         drawFractal (order-1, x3, y3, x4, y4, page);
         drawFractal (order-1, x4, y4, x5, y5, page);
      }
   }

       /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     none
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   dLength is a positive real number
     *          startX is within the range of the frame
     *          startY is within the range of the frame
     *          angle is acute
     * @return  void
     */
    public void branch(double dLength, int startX, int startY, double angle, Graphics2D g2)
    {
        // put your code here
        if (dLength < 5) {}
        else
        {
            double angle1 = angle + branchingAngle;
            double angle2 = angle - branchingAngle;
           
            dLength = dLength*fractionLength;
           
            int endX1 = (int)(startX + dLength*Math.sin(angle));
            int endY1 = (int)(startY - dLength*Math.cos(angle));
           
            g2.draw(new Line2D.Double(startX, startY, endX1, endY1));
           
            branch(dLength, endX1, endY1, angle1, g2);
            branch(dLength, endX1, endY1, angle2, g2);
        }
    }
   
   //-----------------------------------------------------------------
   //  Performs the initial calls to the branch method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      branch(100, 200, 200, 0, (Graphics2D)page);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
