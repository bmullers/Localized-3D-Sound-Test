import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import static java.sql.Types.NULL;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.AL10.AL_BUFFER;
import static org.lwjgl.openal.AL10.alSourcei;
import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.ALC10.ALC_TRUE;
import static org.lwjgl.stb.STBVorbis.stb_vorbis_decode_filename;
import static org.lwjgl.system.MemoryStack.stackMallocInt;
import static org.lwjgl.system.MemoryStack.stackPop;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.libc.LibCStdlib.free;

public class OpenALInit {
    public static int[] sources;
    public static void init(){
        //Retrieving default device name
        if(alcIsExtensionPresent(NULL, "ALC_ENUMERATION_EXT")){
            System.out.println("Yes");
        }else throw new RuntimeException("No");

        String defaultDeviceName = alcGetString(NULL, ALC_DEVICE_SPECIFIER);
        System.out.println("Default device name : " +defaultDeviceName);
        //Initalizing device
        long device = alcOpenDevice(defaultDeviceName);
        if(device != NULL){
            System.out.println("Successfully opened default device");
            int[] attributes = {0};
            long context = alcCreateContext(device,attributes);
            alcMakeContextCurrent(context);
            ALCCapabilities alcCapabilities = ALC.createCapabilities(device);
            ALCapabilities alCapabilities = AL.createCapabilities(alcCapabilities);
        }else throw new RuntimeException("Error : couldn't open default device");


        //Initializing buffers
        //alGetError();//clearing error message

        int[] buffers = new int[1];
        alGenBuffers(buffers);

        int error = alGetError();//checking for errors
        if(error != AL_NO_ERROR){
            throw new RuntimeException("Error while generating buffers : error " + error);
        }

        //Loading OGG file into buffer
        String filename = "boom.ogg";

        //allocating buffers to collect data about source file
        stackPush();
        IntBuffer channelsBuffer = stackMallocInt(1);
        stackPush();
        IntBuffer sampleRateBuffer = stackMallocInt(1);
        //loading data from source
        ShortBuffer rawAudioBuffer = stb_vorbis_decode_filename(filename, channelsBuffer, sampleRateBuffer);
        //storing buffered data into variables and freeing memory space
        int channels = channelsBuffer.get(0);
        int sampleRate = sampleRateBuffer.get(0);
        stackPop();
        stackPop();

        int format = -1;
        if(channels == 1) {
            format = AL_FORMAT_MONO16;
        } else if(channels == 2) {
            format = AL_FORMAT_STEREO16;
        }
        //loading sound data into OpenAL buffer
        alBufferData(buffers[0], format, rawAudioBuffer, sampleRate);//forced to mono16 for a while, to be returned to format later

        free(rawAudioBuffer);

        if(error != AL_NO_ERROR){
            throw new RuntimeException("Error while loading data into buffers : error " + error);
        }

        //Generating sources
        sources = new int[4];
        alGenSources(sources);
        //No error handling because i'm lazy

        //Attaching the buffer to all sources
        alSourcei(sources[0],AL_BUFFER,buffers[0]);
        alSourcei(sources[1],AL_BUFFER,buffers[0]);
        alSourcei(sources[2],AL_BUFFER,buffers[0]);
        alSourcei(sources[3],AL_BUFFER,buffers[0]);
        //Again, no error handling
    }
}
