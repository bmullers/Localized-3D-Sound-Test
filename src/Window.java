import SliderChangeListeners.SliderGainChangeListener;
import SliderChangeListeners.SliderPitchChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;

import static org.lwjgl.openal.AL10.alSourcePlay;

public class Window extends JFrame{

    public Window(){
        setTitle("Localized 3D Sound Test");
        setSize(900,625);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container container = this.getContentPane();
        container.setLayout(null);

        //Labels used to hold tools to test out source properties
        //One for each source
        JLabel labelTop = new JLabel();
        JLabel labelBot = new JLabel();
        JLabel labelLeft = new JLabel();
        JLabel labelRight = new JLabel();
        add(labelTop); labelTop.setBounds(600,0,300,200);
        add(labelBot); labelBot.setBounds(0,400,300,200);
        add(labelLeft); labelLeft.setBounds(0,0,300,200);
        add(labelRight); labelRight.setBounds(600,400,300,200);

        //the buttons corresponding to the audio sources
        JButton leftButton = new JButton("LEFT");leftButton.setBounds(0,200,300,200);add(leftButton);
        JButton rightButton = new JButton("RIGHT");rightButton.setBounds(600,200,300,200);add(rightButton);
        JButton topButton = new JButton("FRONT");topButton.setBounds(300,0,300,200);add(topButton);
        JButton bottomButton = new JButton("BACK");bottomButton.setBounds(300,400,300,200);add(bottomButton);

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

        //The various sliders used to modify source properties

        ParameterFrame topLeftPF = new ParameterFrame(OpenALInit.sources[2],labelTop,"Top Source Properties");
        topLeftPF.addSlider(ParameterFrame.PITCH);
        topLeftPF.addSlider(ParameterFrame.GAIN);



    }

}
