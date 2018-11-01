import SliderChangeListeners.SliderGainChangeListener;
import SliderChangeListeners.SliderPitchChangeListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;

import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.RIGHT_ALIGNMENT;

/**
 * This class represents a JFrame container which contains
 * the sliders used to tweak the effects and filters added to
 * the corresponding source
 */

public class ParameterFrame {
    private int source;
    private JLabel label;
    public static int PITCH = 1;
    public static int GAIN = 2;

    public ParameterFrame(int s, JLabel l,String t){
        source = s;
        label = l;
        label.setLayout(new BoxLayout(label,BoxLayout.Y_AXIS));
        JLabel title = new JLabel(t);
        label.add(title);
    }

    public void addSlider(int type){
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,20,10);
        String strType;
        //TODO add new cases
        switch(type){
            case 1 : slider.addChangeListener(new SliderPitchChangeListener(source));
                strType = "pitch";
                break;
            case 2 : slider.addChangeListener(new SliderGainChangeListener(source));
                strType = "gain";
                break;
            default: System.out.println("Error : slider type " + type + " doesn't exist" );
                return;
        }
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel sliderLabel = new JLabel();
        Dimension labelSize = new Dimension(294,30);
        sliderLabel.setMinimumSize(labelSize);
        sliderLabel.setMaximumSize(labelSize);
        sliderLabel.setBorder(blackline);
        sliderLabel.setLayout(new BorderLayout());

        JTextField typeText = new JTextField(strType);
        typeText.setEditable(false);
        typeText.setAlignmentX(CENTER_ALIGNMENT);
        typeText.setVisible(true);
        typeText.setPreferredSize(new Dimension(40,30));

        slider.setVisible(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);

        slider.setBorder(blackline);
        slider.setAlignmentX(RIGHT_ALIGNMENT);

        sliderLabel.add(typeText, BorderLayout.LINE_START);
        sliderLabel.add(slider, BorderLayout.CENTER);
        label.add(sliderLabel);
    }

}
