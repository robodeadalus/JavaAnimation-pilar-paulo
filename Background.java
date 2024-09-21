
/**
 * This class is for when the user wants to create a background for the scene. This is a composite 
 * shape that makes use of other classes.
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

public class Background implements DrawingObject {

    /**
     * This constructor does not have any variable
     * The background itself is hardcoded
     */
    public Background() {
    }

    // Source for making transcluscent colors:
    // https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

    /**
     * This draw method uses other shapes to draw the background of the program.
     * It makes use of transcluscent colors to simulate a gradient
     * This was done because I wanted to use multiple colors.
     */
    public void draw(Graphics2D g2d) {
        Color sun = new Color(255, 202, 124, 5);
        Color redSky = new Color(185, 0, 0, 255);
        Color darkness = new Color(0, 0, 0, 255);
        Color seaLight = new Color(254, 237, 154, 5);
        Color seaNear = new Color(64, 55, 94, 100);
        Color seaLine = new Color(64, 55, 94, 140);
        Color whiteAura = new Color(255, 255, 255, 50);
        AffineTransform reset = g2d.getTransform();

        Rectangle b1 = new Rectangle(0, 0, 1024, 768, Color.BLACK);
        b1.addGradient(512, 0, darkness, 512, 500, redSky);

        Rectangle sunlight = new Rectangle(0, 300, 1024, 768, Color.black);
        sunlight.addGradient(512, 384, sun, 512, 650, Color.white);

        Rectangle b2 = new Rectangle(0, 500, 1024, 268, Color.decode("#40375E"));
        b2.addGradient(512, 500, seaLight, 512, 768, Color.decode("#40375E"));

        Rectangle horizonLight = new Rectangle(0, 500, 1024, 268, Color.black);
        horizonLight.addGradient(512, 500, seaLight, 512, 668, seaNear);

        Line horizonRay = new Line(0, 599, 1024, 600, 4, Color.white);
        Line horizonLine = new Line(0, 600, 1024, 600, 3, seaLine);

        Circle backgroundAura = new Circle(512, 384, 500, whiteAura);

        b1.draw(g2d);
        sunlight.draw(g2d);
        b2.draw(g2d);
        horizonLight.draw(g2d);
        horizonRay.draw(g2d);
        horizonLine.draw(g2d);
        backgroundAura.draw(g2d);
    }
}
