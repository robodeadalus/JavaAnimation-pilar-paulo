
/**
  *This class is for when the user wants to add a square to the canvas. This class also
  allows the user to fill the square or to add a gradient to it.
 * @author Paulo Miguel A. Pilar (225008)
 * @version March 3, 2023
/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.
I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program
that has been clearly noted with a proper citation in the comments
of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class Square implements DrawingObject {
    private double x, y, size;
    private Color color1;
    private GradientPaint squareGradientPaint;
    private boolean toFill;

    /**
     * This constructor takes in arguments that allow the user to modify the square
     * These include its position size and color
     * 
     * @param x
     * @param y
     * @param size
     * @param color1
     */
    public Square(double x, double y, double size, Color color1) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color1 = color1;
        squareGradientPaint = null;
        toFill = true;
    }

    /**
     * This draws in the square.
     * Depending whether the user wants to fill the square or have a uniform color
     * the corresponding square will be shown.
     */
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        if (toFill == false) {
            g2d.setPaint(squareGradientPaint);
        } else if (toFill == true) {
            g2d.setColor(color1);
        }
        g2d.fill(square);
    }

    // Source for adding
    // gradiants:http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawingwithaGradientColor.htm
    /**
     * This method allows the user to add a gradient to the square which can be
     * customized
     * These include the position and color of the first color and the second
     * position and color
     * 
     * @param startX
     * @param startY
     * @param color1
     * @param endX
     * @param endY
     * @param color2
     */
    public void addGradient(float startX, float startY, Color color1, float endX, float endY, Color color2) {
        toFill = false;
        squareGradientPaint = new GradientPaint(startX, startY, color1, endX, endY, color2);
    }
}
