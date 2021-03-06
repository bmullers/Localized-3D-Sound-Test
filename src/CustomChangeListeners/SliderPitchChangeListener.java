package CustomChangeListeners;

import org.lwjgl.openal.AL10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static org.lwjgl.openal.AL10.AL_PITCH;

import Main.Source;

/**
 * This implementation of ChangeListener is used on the sliders that modify the source's pitch
 */
public class SliderPitchChangeListener implements ChangeListener {

    public Source alSource;

    public SliderPitchChangeListener(Source i){
        alSource = i;
    }

    @Override
    public void stateChanged(ChangeEvent event){
        JSlider source = (JSlider) event.getSource();
        if(source.getValueIsAdjusting()){
            AL10.alSourcef(alSource.getSource(),AL_PITCH,modifiedPitch(source.getValue()));
        }
    }

    private float modifiedPitch(int input){
        //subject to potential tweaking, this is just a simple formula
        return (float) Math.pow(1.1,(double)input -10.0);
    }
}
