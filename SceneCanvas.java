
/**
  *This class is for adding things onto the canvas of the frame itself. Using the paint component
 * it draws the shapes in the array list  shapes. It also has methods which allow the user to swap
 * between which eyes to show
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

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class SceneCanvas extends JComponent {
  private ArrayList<DrawingObject> shapes;
  private ShisuiEye shisuiEye;
  private Sharingan sharingan;
  private SasukeEye sasukeEye;
  private Circle eyeAura;
  private Oval shadow;
  private Background bg;
  public int arrayLister;

  // Source for making transcluscent colors:
  // https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
  /**
   * This constructor adds the classes that will be displayed in the program into
   * an ArrayList called shapes.
   * Additionally it sets the width and height of the program.
   */
  public SceneCanvas() {
    Color aura = new Color(255, 0, 0, 1);
    Color shadowBlur = new Color(0, 0, 0, 25);

    shapes = new ArrayList<>();
    shapes.add(sharingan = new Sharingan());
    shapes.add(shisuiEye = new ShisuiEye(512, 384, 200, Color.black));
    shapes.add(sasukeEye = new SasukeEye(512, 384, 500, 250, Color.black));
    shapes.add(bg = new Background());
    shapes.add(eyeAura = new Circle(512, 384, 400, aura));
    shapes.add(shadow = new Oval(512, 700, 400, 150, Color.black, true));

    shadow.addGradient(512, 700, Color.black, shadowBlur);
    eyeAura.addGradient(512, 384, aura, Color.black);
    setPreferredSize(new Dimension(1024, 768));
    arrayLister = 0;
  }

  /**
   * This method is resposible for actually outputting the shapes that have been
   * added to the shapes
   * ArrayList. It loops through the array list depending on a certain variable.
   * When it loops it prints out
   * the background, what eye the user wants, the shadow and the aura.
   */
  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHints(rh);

    for (int i = arrayLister; i <= arrayLister; i++) {
      bg.draw(g2d);
      DrawingObject o = shapes.get(i);
      o.draw(g2d);
      shadow.draw(g2d);
      eyeAura.draw(g2d);

    }
  }

  /**
   * This method returns the instance of Shisui's eye.
   * This is used for its infinite rotate
   * 
   * @return
   */
  public ShisuiEye getShisuiEye() {
    return shisuiEye;
  }

  /**
   * This method returns the instance of the Sharingan.
   * This is used for its infinite rotate
   * 
   * @return
   */
  public Sharingan getSharingan() {
    return sharingan;
  }

  /**
   * This method returns the instance of the Sasuke's Eye.
   * This is used for its infinite rotate
   * 
   * @return
   */
  public SasukeEye getSasukeEye() {
    return sasukeEye;
  }

  /**
   * This method allows the user to set the arraylister variable to 0.
   * It shows displays the sharingan on the screen.
   */
  public void showSharingan() {
    arrayLister = 0;
  }

  /**
   * This method allows the user to set the arraylister variable to 1.
   * It shows displays Shisui's eye on the screen.
   */

  public void showMangekyoShisui() {
    arrayLister = 1;
  }

  /**
   * This method allows the user to set the arraylister variable to 2.
   * It shows displays the Sasuke's eye on the screen.
   */
  public void showMangekyoSasuke() {
    arrayLister = 2;
  }

}
