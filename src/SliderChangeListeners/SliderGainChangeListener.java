package SliderChangeListeners;

import org.lwjgl.openal.AL10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static org.lwjgl.openal.AL10.AL_GAIN;
import static org.lwjgl.openal.AL10.AL_PITCH;

public class SliderGainChangeListener implements ChangeListener{
    public int alSource;

    public SliderGainChangeListener(int i){
        alSource = i;
    }

    @Override
    public void stateChanged(ChangeEvent event){
        JSlider source = (JSlider) event.getSource();
        if(source.getValueIsAdjusting()){
            AL10.alSourcef(alSource,AL_GAIN,modifiedGain(source.getValue()));
        }
    }

    private float modifiedGain(int input){
        return (float) input / 10;
    }

}
