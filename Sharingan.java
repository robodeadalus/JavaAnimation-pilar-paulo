
/**
 *This class is instantiated when the user wants to create the Three Tomoe Sharingan, which is
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

public class Sharingan implements DrawingObject {
    private double angle;

    /**
     * This class does not make use of any parameters and only has
     * the angle variable
     * 
     * This variable is used later on to rotate the shape
     */
    public Sharingan() {
        angle = 0;
    }

    /**
     * This draw method makes use of other classes.
     * The Sharingan class is drawn and everytime that it is, the angle
     * changes.
     */
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(angle), 512, 384);

        Circle base = new Circle(512, 384, 492, Color.white);
        Circle shade = new Circle(512, 384, 490, Color.red);
        shade.addGradient(512, 384, Color.red, Color.black);
        Circle iris = new Circle(512, 384, 100, Color.black);
        Circle outerRing = new Circle(512, 384, 300, Color.black);
        outerRing.hollowCircle(5);
        Tomoe tomoe1 = new Tomoe(530, 255, 50, Color.black, true, 50);
        Tomoe tomoe2 = new Tomoe(425, 500, 50, Color.black, true, -70);
        Tomoe tomoe3 = new Tomoe(660, 490, 50, Color.black, true, 200);

        base.draw(g2d);
        shade.draw(g2d);
        iris.draw(g2d);
        outerRing.draw(g2d);
        tomoe1.draw(g2d);
        tomoe2.draw(g2d);
        tomoe3.draw(g2d);

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
