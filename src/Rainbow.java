// Chapter 5 Question 27

// ________________________________________________


//Thanks to stackoverflow to helping me understand this problem!!


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
	private final Color skyColor = Color.CYAN;; 

  public Rainbow()
  {
	
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    int xCenter = width/2;
	int yCenter = (height*3) / 4;
	
	//radius of largest red semicircle
	int largeRadius = width/4;
	int mediumRadius = height*1/4;


    g.setColor(Color.RED);
    g.fillArc(xCenter - largeRadius/2, yCenter - largeRadius/2 + largeRadius/4 -height/4, largeRadius, largeRadius,0,180);
    
    
    g.setColor(Color.MAGENTA);
    int geoMean = mediumRadius * largeRadius; 
    int smallRadius = (int) Math.sqrt(geoMean);
    g.fillArc(xCenter-(smallRadius)/2, yCenter-(smallRadius)/2 + largeRadius/4 -height/4, smallRadius, smallRadius, 0, 180);
    
    
    g.setColor(Color.GREEN);
    g.fillArc(xCenter-(mediumRadius)/2, yCenter-(mediumRadius)/2 + largeRadius/4 -height/4, mediumRadius, mediumRadius, 0, 180);
    
    int tinyRadius = (largeRadius+mediumRadius+smallRadius)/5;
    g.setColor(skyColor);
    g.fillArc(xCenter-(tinyRadius)/2,yCenter-(tinyRadius)/2 + largeRadius/4 - height/4,tinyRadius,tinyRadius,0,180);
    
    
    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    // ________________________________________________

    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________

    // Draw the sky-color semicircle:
    // ________________________________________________
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
