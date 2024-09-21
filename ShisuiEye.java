
/**
  *This class is instantiated when the user wants to create Shisui's eye, which is
 * a composite shape. It can also rotate via the rotate method, which adds 4 to the 
 * angle variable
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

public class ShisuiEye implements DrawingObject {
    private double x, y, size, angle;
    private Color color;

    /**
     * This class takes in parameters that determines the location of the eye and
     * the size of the elements that make up Shisui's Eye. It is a composite shape
     * that makes use of the other shape classes.
     * 
     * @param x
     * @param y
     * @param size
     * @param color
     */
    public ShisuiEye(double x, double y, double size, Color color) {
        this.x = x - size / 2;
        this.y = y - size / 2;
        this.size = size;
        this.color = color;
        this.angle = 0;
    }

    /**
     * This draws in the components of Shisui's eye. It makes use of the
     * arguments in the constructor. Additionally every time it is printed it can be
     * rotated using
     * a the Rotate method.
     */
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        double centerX = x + size / 2;
        double centerY = y + size / 2;
        g2d.rotate(Math.toRadians(angle), centerX, centerY);

        Circle base = new Circle(512, 384, 492, Color.white);
        Circle shade = new Circle(512, 384, 490, Color.red);
        shade.addGradient(512, 384, Color.red, Color.black);
        Square shisuiSquare = new Square(x, y, size, color);
        Triangle shisuiTriangleUpperLeft = new Triangle(x, y, x, y - 80, x + 80, y, color);
        Triangle shisuiTriangleLowerLeft = new Triangle(x, y + size, x - 80, y + size, x, (y + size) - 80, color);
        Triangle shisuiTriangleUpperRight = new Triangle(x + size, y, (x + size) + 80, y, x + size, (y + 80), color);
        Triangle shisuiTriangleLowerRight = new Triangle(x + size, y + size, x + size, (y + size) + 80, (x + size) - 80,
                (y + size), color);
        Circle innerRedCircle = new Circle(centerX, centerY, 80, Color.decode("#8A0000"));
        Circle innerBlackCircle = new Circle(centerX, centerY, 25, Color.black);

        base.draw(g2d);
        shade.draw(g2d);
        shisuiSquare.draw(g2d);
        shisuiTriangleUpperLeft.draw(g2d);
        shisuiTriangleLowerLeft.draw(g2d);
        shisuiTriangleLowerRight.draw(g2d);
        shisuiTriangleUpperRight.draw(g2d);
        innerRedCircle.draw(g2d);
        innerBlackCircle.draw(g2d);

        g2d.setTransform(reset);

    }

    /**
     * This method allows Shisui's eye to rotate
     * It increments the angle by 4.
     */
    public void Rotate() {
        angle += 4;
    }
}
