
/**
  *This class is for when the user wants to add a rectangle to the canvas. This class also
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

public class Rectangle implements DrawingObject {
    private double x, y, width, height;
    private Color color1, color2;
    private GradientPaint rectangleGradientPaint;
    private boolean toFill;

    /**
     * This constructor creates the attributes of the rectangle.
     * Through its parameters it changes the width,height,color and position
     * of the rectangle in the canvas.
     * 
     * @param x
     * @param y
     * @param width
     * @param color1
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color1 = color1;
        rectangleGradientPaint = null;
        toFill = true;
    }

    /**
     * This method draws in the rectangle.
     * It also determines whether or not the user wants it filled in with a 
     * uniform color or a gradient
     */
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
        if (toFill == false && rectangleGradientPaint != null) {
            g2d.setPaint(rectangleGradientPaint);

        } else if (toFill == true && rectangleGradientPaint == null) {
            g2d.setColor(color1);
        }
        g2d.fill(rectangle);

    }

    // Source for adding
    // gradiants:http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawingwithaGradientColor.htm
    /**
     * This method takes in arguments that allow the user to add a gradient to the rectangle.
     * These include the position of the first gradient and its color and the position of the second gradient
     * and its color
     */
    public void addGradient(float startX, float startY, Color color1, float endX, float endY, Color color2) {
        toFill = false;
        rectangleGradientPaint = new GradientPaint(startX, startY, color1, endX, endY, color2);
    }

}
