import javax.swing.*;

import java.awt.event.ActionEvent;

import static org.lwjgl.openal.AL10.alSourcePlay;

public class Window extends JFrame{

    public Window(){
        setTitle("Localized 3D Sound Test");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //the buttons corresponding to the audio sources
        JButton leftButton = new JButton("LEFT");
        JButton rightButton = new JButton("RIGHT");
        JButton topButton = new JButton("FRONT");
        JButton bottomButton = new JButton("BACK");

        leftButton.addActionListener((ActionEvent event) -> {
            alSourcePlay(OpenALInit.sources[0]);
        });
        rightButton.addActionListener((ActionEvent event) -> {
            alSourcePlay(OpenALInit.sources[1]);
        });
        topButton.addActionListener((ActionEvent event) -> {
            alSourcePlay(OpenALInit.sources[2]);
        });
        bottomButton.addActionListener((ActionEvent event) -> {
            alSourcePlay(OpenALInit.sources[3]);
        });
    }

}
