import org.lwjgl.openal.*;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALC10;

import static org.lwjgl.openal.AL10.AL_TRUE;
import static org.lwjgl.openal.AL10.alGetError;
import static org.lwjgl.openal.ALC10.*;

public class Main {
    public void main(String[] args) throws RuntimeException{
        //Retrieving default device name
        if(alcIsExtensionPresent(Long.parseLong(null), "ALC_ENUMERATION_EXT")){
            System.out.println("Yes");
        }else throw new RuntimeException("No");

        String defaultDeviceName = alcGetString(Long.parseLong(null), ALC_DEFAULT_DEVICE_SPECIFIER);

        //Initalizing device
        if(alcOpenDevice(defaultDeviceName) == ALC_TRUE){
            System.out.println("Successfully opened default device");
        }else throw new RuntimeException("Error : couldn't open default device");


        //Initializing buffers
        alGetError();
    }
}
