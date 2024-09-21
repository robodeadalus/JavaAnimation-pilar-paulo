
/**
 * This class is for when the user wants to draw a line
 * They can adjust the line's thickness and color
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

public class Line implements DrawingObject {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;
    private float thickness;
    private Color color;

    /**
     * By using two points this class creates a line
     * The thickness and color of is also customizable
     * 
     * @param xStart
     * @param yStart
     * @param xEnd
     * @param yEnd
     * @param thickness
     * @param color
     */
    public Line(double xStart, double yStart, double xEnd, double yEnd, float thickness, Color color) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.thickness = thickness;
        this.color = color;
    }

    /**
     * Makes use of the arguments in the constructor to create the line.
     * Also makes use of color and thickness variable to customize the line's
     * color and thickness.
     * 
     */
    public void draw(Graphics2D g2d) {
        Line2D.Double l = new Line2D.Double(xStart, yStart, xEnd, yEnd);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(l);
    }

}
