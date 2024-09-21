
/**
 * This class if for when the user wants to add Tomoes. This is the rotating circles with claw on the
 * Three Tomoe Sharingan.
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

public class Tomoe implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private boolean toRotate;
    private double degrees;
    private Color color;

    /**
     * This class takes in arguments to create the Tomoe for the Sharingan
     * These include its position, size, color, whether or not it is rotated and its
     * defrees
     * 
     * @param x
     * @param y
     * @param size
     * @param color
     * @param toRotate
     * @param degrees
     */
    public Tomoe(double x, double y, double size, Color color, boolean toRotate, double degrees) {
        this.x = x - size / 2;
        this.y = y - size / 2;
        this.size = size;
        this.color = color;
        this.toRotate = toRotate;
        this.degrees = degrees;
    }

    /**
     * This draw method is for drawing the tomoe.
     * The user can opt to rotate the tomoe or not depending on the boolean
     * variable in the constructor.
     */
    public void draw(Graphics2D g2d) {
        double xPtTwo = x - size / 2;
        double xFinalPt = xPtTwo;
        double yFinalPt = y - size;
        AffineTransform reset = g2d.getTransform();
        Circle tomoeCircle = new Circle(x, y, size, color);
        Triangle tomoeClaw = new Triangle(x, y, xPtTwo, y, xFinalPt, yFinalPt, color);
        if (toRotate == true) {
            g2d.rotate(Math.toRadians(degrees), x, y);
            tomoeCircle.draw(g2d);
            tomoeClaw.draw(g2d);
            g2d.setTransform(reset);
        } else {
            tomoeCircle.draw(g2d);
            tomoeClaw.draw(g2d);
        }
    }
}
