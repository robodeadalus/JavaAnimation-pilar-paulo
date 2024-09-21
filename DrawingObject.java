
/**
 *This is an interface which allows the other shape classes to use the draw method.
 * This also allows for the shapes to be listed in an array list as seen in SceneCanvas.
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

/**
 * This interface for every single one of my shapes to fall under one common
 * category
 * which is DrawingObject.
 * 
 * Those shape classes need to implement this interface and this method for them
 * to be a drawing object.
 */
public interface DrawingObject {
    public void draw(Graphics2D g2d);
}
