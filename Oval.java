
/**
 * This class is for when the user wants to instantiate and draw an Oval
 * It also allows the user to make it so that the oval is filled with a gradient or solid color
 * or it is hollow.
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
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.*;

public class Oval implements DrawingObject {
    private double x, y, width, height;
    private Color color;
    private boolean toFill;
    private RadialGradientPaint ovalGradientPaint;

    /**
     * This constructor takes in arguments that allow for customizability for the
     * line.
     * These include the position, width and height, color and if the user wants to
     * have a hollow
     * oval or a filled.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @param toFill
     */
    public Oval(double x, double y, double width, double height, Color color, boolean toFill) {
        this.x = x - width / 2;
        this.y = y - height / 2;
        this.width = width;
        this.height = height;
        this.color = color;
        this.toFill = toFill;
        this.ovalGradientPaint = null;
    }

    /**
     * This draws in the oval
     * Depending on what the user wants it the program either fills the oval, leaves
     * it a hollow shape
     * or a gradient color.
     * 
     */
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double o = new Ellipse2D.Double(x, y, width, height);
        if (toFill == true && ovalGradientPaint == null) {
            g2d.setColor(color);
            g2d.fill(o);
            return;
        } else if (toFill == false) {
            g2d.setStroke(new BasicStroke(8));
            g2d.draw(o);
            return;
        } else if (ovalGradientPaint != null) {
            g2d.setPaint(ovalGradientPaint);
            g2d.fill(o);
            return;
        }
    }

    // Source for adding radial gradient =
    // https://docs.oracle.com/javase/7/docs/api/java/awt/RadialGradientPaint.html
    /**
     * This method takes in arguments that allow the user to add a gradient to the
     * oval shape.
     * It takes in the first color and its position as well as the following color
     * and position.
     * 
     * @param centerX
     * @param centerY
     * @param color1
     * @param color2
     */
    public void addGradient(float centerX, float centerY, Color color1, Color color2) {
        Point2D center = new Point2D.Float(centerX, centerY);
        Color[] gradientColors;
        gradientColors = new Color[2];
        gradientColors[0] = color1;
        gradientColors[1] = color2;

        float[] dist;
        dist = new float[2];
        dist[0] = 0.0f;
        dist[1] = 0.5f;

        ovalGradientPaint = new RadialGradientPaint(center, 300, dist, gradientColors);

    }

}
