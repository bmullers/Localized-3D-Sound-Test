package CustomChangeListeners;

import Main.Source;
import org.lwjgl.openal.AL10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static org.lwjgl.openal.EXTEfx.AL_REVERB_DECAY_TIME;

public class SliderDecayTimeChangeListener implements ChangeListener {
    public Source source;

    public SliderDecayTimeChangeListener(Source s){source = s;}

    @Override
    public void stateChanged(ChangeEvent event){
        JSlider slider = (JSlider) event.getSource();
        if(slider.getValueIsAdjusting()){
            AL10.alSourcef(source.getReverb(),AL_REVERB_DECAY_TIME,adjustedValue(slider.getValue()));
        }
    }

    private float adjustedValue(float input){
        return input / 3;
    }
}
