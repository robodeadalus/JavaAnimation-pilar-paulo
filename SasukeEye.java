
/**
 *This class is instantiated when the user wants to create Sasuke's eye, which is
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

public class SasukeEye implements DrawingObject {
    private double x, y, width, height, angle;
    private Color color;

    /**
     * Takes in the following parameters that will be used to create Sasuke's eye
     * These parameters are used in the methods below.
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public SasukeEye(double x, double y, double width, double height, Color color) {
        this.x = x - width / 2;
        this.y = y - height / 2;
        this.width = width;
        this.height = height;
        this.color = color;
        this.angle = 0;
    }

    /**
     * This draw method draws shapes using the arguements in the constructur
     * It makes it so that the drawn shape would be Sasuke's eye
     */
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        double centerX = x + width / 2;
        double centerY = y + height / 2;
        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        Circle base = new Circle(512, 384, 492, Color.white);
        Circle shade = new Circle(512, 384, 490, Color.red);
        shade.addGradient(512, 384, Color.red, Color.black);
        Circle iris = new Circle(512, 384, 100, Color.black);
        Triangle t1 = new Triangle(512 - 25, 384, 512 + 25, 384, 512, 384 - 200, Color.black);
        Circle redIris = new Circle(512, 384, 50, Color.red);
        base.draw(g2d);
        shade.draw(g2d);
        iris.draw(g2d);
        t1.draw(g2d);

        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        g2d.rotate(Math.toRadians(121), 512, 384);
        t1.draw(g2d);
        g2d.setTransform(reset);

        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        g2d.rotate(Math.toRadians(240), 512, 384);
        t1.draw(g2d);
        g2d.setTransform(reset);
        g2d.rotate(Math.toRadians(angle), centerX, centerY);
        g2d.rotate(Math.toRadians(90), centerX, centerY);
        Oval r1 = new Oval(centerX, centerY, 475, 200, Color.black, false);
        r1.draw(g2d);
        g2d.rotate(Math.toRadians(120), centerX, centerY);
        Oval r2 = new Oval(centerX, centerY, 475, 200, Color.black, false);
        r2.draw(g2d);
        g2d.rotate(Math.toRadians(300), centerX, centerY);
        Oval r3 = new Oval(centerX, centerY, 475, 200, Color.black, false);
        r3.draw(g2d);
        redIris.draw(g2d);
        g2d.rotate(Math.toRadians(angle), centerX, centerY);

        g2d.setTransform(reset);

    }

    /**
     * This method is for rotating the eye.
     * It increments the angle by 4 turning it to the right.
     */
    public void Rotate() {
        angle += 4;
    }
}
