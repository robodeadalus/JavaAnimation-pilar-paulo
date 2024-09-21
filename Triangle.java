
/**
 * This class is instantiated when the user wants to create a triangle. The main idea is that it
 * takes in three points and then closes bridges the gap between the first and third.
 * 
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

public class Triangle implements DrawingObject {
    private double xPtOne;
    private double yPtOne;
    private double xPtTwo;
    private double yPtTwo;
    private double xPtLast;
    private double yPtLast;
    private Color color;

    /**
     * These parameters allow the user to create a triangle.
     * By using three points this class connects them all and fills the shape with
     * the color they want.
     * 
     * @param xPtOne
     * @param yPtOne
     * @param xPtTwo
     * @param yPtTwo
     * @param xPtLast
     * @param yPtLast
     * @param color
     */
    public Triangle(double xPtOne, double yPtOne, double xPtTwo, double yPtTwo, double xPtLast, double yPtLast,
            Color color) {
        this.xPtOne = xPtOne;
        this.yPtOne = yPtOne;
        this.xPtTwo = xPtTwo;
        this.yPtTwo = yPtTwo;
        this.xPtLast = xPtLast;
        this.yPtLast = yPtLast;
        this.color = color;
    }

    /**
     * This method makes use of the arguements in the constructor
     * to draw the shape and fill it out with the color the user wants
     */
    public void draw(Graphics2D g2d) {
        Path2D.Double t = new Path2D.Double();
        t.moveTo(xPtOne, yPtOne);
        t.lineTo(xPtTwo, yPtTwo);
        t.lineTo(xPtLast, yPtLast);
        t.closePath();
        g2d.setColor(color);
        g2d.fill(t);
    }
}
