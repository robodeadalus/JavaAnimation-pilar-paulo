
/**
 * This SceneFrame class is for setting up the frame,buttons,and infinitely rotating Eyes
 * that make use of the angle variable in all the other Eye classes. It also makes use of audio files 
 * so that when the user presses buttons corresponding to any of the eyes, a sound is played and the
 * corresponding eye is displayed on screen
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

public class SceneFrame extends JPanel {
    private JFrame frame;
    private SceneCanvas sceneCanvas;
    private JButton Sharingan, ShisuiMangekyo, SasukeMangekyo;
    private JPanel buttonsPanel;
    private Timer timer;
    private InfiniteRotate infiniteRotate;
    private File file;
    private AudioInputStream audioStream;
    private Clip clip;

    /**
     * This constructor creates new instances of the variables.
     * These will then be used in the setUpGUI method
     */
    // Playing Audio in Java: https://www.youtube.com/watch?v=SyZQVJiARTQ&t=553s
    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas();
        Sharingan = new JButton("Sharingan");
        ShisuiMangekyo = new JButton("Shisui Uchiha Mangekyo");
        SasukeMangekyo = new JButton("Sasuke Uchiha Mangekyo");
        buttonsPanel = new JPanel();
        file = new File("Normal Sharingan Sound Effect.wav");
        buttonsPanel.setLayout(new GridLayout(1, 3));
        infiniteRotate = new InfiniteRotate();
        timer = new Timer(25, infiniteRotate);
        timer.start();
    }

    /**
     * This is where the variables that have been instantiated will be used.
     * It sets up the Gui and all of its assets such as the frame title, buttons
     * and the audio file/
     * 
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    // Playing Audio in Java: https://www.youtube.com/watch?v=SyZQVJiARTQ&t=553s
    public void setUpGUI() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Container cp = frame.getContentPane();
        frame.setTitle("Midterm Project - Pilar, Paulo Miguel - 225008");
        cp.add(sceneCanvas);
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(Sharingan);
        buttonsPanel.add(ShisuiMangekyo);
        buttonsPanel.add(SasukeMangekyo);
        cp.add(buttonsPanel, BorderLayout.SOUTH);
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method connects the buttons instantiated above to a button listener.
     * This will then allow the program to execute a command based on the button
     * clicked.
     */
    public void setUpButtonListener() {
        ButtonListener b1 = new ButtonListener();
        Sharingan.addActionListener(b1);
        ShisuiMangekyo.addActionListener(b1);
        SasukeMangekyo.addActionListener(b1);
    }

    // Source: Vaughn Alvarez (taught me how to make us of the timer import as well
    // as ActionListeners)
    // Source: https://www.youtube.com/watch?v=KcEvHq8Pqs0 (additional info)
    /**
     * Class that allows the Eyes to rotate.
     * This is executed every 25 miliseconds to show rotation animation.
     */
    private class InfiniteRotate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            sceneCanvas.getShisuiEye().Rotate();
            sceneCanvas.getSharingan().Rotate();
            sceneCanvas.getSasukeEye().Rotate();
            sceneCanvas.repaint();
        }
    }

    // Playing Audio in Java: https://www.youtube.com/watch?v=SyZQVJiARTQ&t=553s
    /**
     * This class allows the program to listen to a button press.
     * From there it will execute the corresponding commands based
     * on the button that was pressed.
     */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Object o = ae.getSource();
            clip.start();
            if (o == Sharingan) {
                clip.setMicrosecondPosition(10000);
                sceneCanvas.showSharingan();
            } else if (o == ShisuiMangekyo) {
                clip.setMicrosecondPosition(10000);
                sceneCanvas.showMangekyoShisui();
            } else if (o == SasukeMangekyo) {
                clip.setMicrosecondPosition(10000);
                sceneCanvas.showMangekyoSasuke();
            }
            sceneCanvas.repaint();
        }
    }

}
