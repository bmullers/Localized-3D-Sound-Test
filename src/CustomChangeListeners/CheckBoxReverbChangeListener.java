package CustomChangeListeners;

import Main.Source;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckBoxReverbChangeListener implements ChangeListener{

    Source source;

    public CheckBoxReverbChangeListener(Source s){
        source = s;
    }

    @Override
    public void stateChanged(ChangeEvent event){
        JCheckBox checkBox = (JCheckBox) event.getSource();
        if(checkBox.isSelected()){
            //Activate effect
        }else{
            //Deactivate effect
        }
    }
}
