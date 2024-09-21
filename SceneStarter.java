
/**
 * This SceneStarter class is for instantiating the SceneFrame class along with
 * the audio file that plays in the background. It then calls the method in SceneCanvas
 * so that everything may be put in the Frame. It also calls the set up button listeners that changes something
 * in the frame depending on the button clicked.
 * 
@author Paulo Miguel. Pilar(225008)
@version March 3, 2023
**/
/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SceneStarter {

    // Playing Audio in Java: https://www.youtube.com/watch?v=SyZQVJiARTQ&t=553s
    /**
     * Main class that allows everything to funcion
     * Starts the Gui, button listeners, and audio files
     * 
     * @param args
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SceneFrame sf = new SceneFrame();
        File file = new File("Naruto Shippuden OST Original Soundtrack 13 - Loneliness.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        sf.setUpGUI();
        sf.setUpButtonListener();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
