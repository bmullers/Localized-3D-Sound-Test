package Main;

import java.awt.*;
import java.nio.ByteBuffer;
import org.lwjgl.openal.ALC10.*;

import static org.lwjgl.openal.ALC10.alcCloseDevice;

public class Main {
    public static void main(String[] args){
        //Initializing OpenAL components
        OpenALInit.init();

        //Creating a new window and displaying it
        EventQueue.invokeLater(() -> {
            Window window = new Window();
            window.setVisible(true);
        });

        alcCloseDevice(new Long(null));

    }
}
