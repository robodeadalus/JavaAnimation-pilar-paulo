
/**
 * This class is for when the user wants to instantiate and draw a Circle
 * It also allows the user to make it so that the circle is filled with a gradient or solid color
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

public class Circle implements DrawingObject {
    private double x, y, size;
    private Color color1;
    private float thickness;
    private boolean toFill;
    private RadialGradientPaint circleRadialGradientPaint;

    /**
     * This constructor takes in arguments to customize the circle.
     * These include its position, size and color
     * 
     * @param x
     * @param y
     * @param size
     * @param color1
     */
    public Circle(double x, double y, double size, Color color1) {
        this.x = x - size / 2;
        this.y = y - size / 2;
        this.size = size;
        this.color1 = color1;
        this.toFill = true;
        this.circleRadialGradientPaint = null;
    }

    /**
     * This draws out the circle and depending on what the user wants the circle is
     * either
     * filled, hollow, or has a gradient color.
     */
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double c = new Ellipse2D.Double(x, y, size, size);
        if (toFill == true && circleRadialGradientPaint == null) {
            g2d.setColor(color1);
            g2d.fill(c);
            return;
        } else if (toFill == false) {
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(c);
            return;
        } else if (circleRadialGradientPaint != null) {
            g2d.setPaint(circleRadialGradientPaint);
            g2d.fill(c);
        }
    }

    // Source for adding radial gradient =
    // https://docs.oracle.com/javase/7/docs/api/java/awt/RadialGradientPaint.html
    /**
     * This adds a gradient to the circle.
     * This gradient extends outward from the points given by the user.
     * 
     * @param centerX
     * @param centerY
     * @param color1
     * @param color2
     */
    public void addGradient(float centerX, float centerY, Color color1, Color color2) {
        Point2D center = new Point2D.Float(centerX, centerY);
        Color whiteFaded = new Color(255, 255, 255, 15);
        Color[] gradientColors;
        gradientColors = new Color[3];
        gradientColors[0] = color1;
        gradientColors[1] = color2;
        gradientColors[2] = whiteFaded;

        float[] dist;
        dist = new float[3];
        dist[0] = 0.0f;
        dist[1] = 0.83f;
        dist[2] = 0.84f;

        circleRadialGradientPaint = new RadialGradientPaint(center, 300, dist, gradientColors);

    }

    /**
     * This method is for when the user wants to have a hollow circle
     * It takes in an argument that determines how thick the outline will be
     * 
     * @param thickness
     */
    public void hollowCircle(float thickness) {
        toFill = false;
        this.thickness = thickness;
    }
}
