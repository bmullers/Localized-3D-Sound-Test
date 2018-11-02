import static org.lwjgl.openal.AL10.*;

/**
 * This class represents a sound source localised in a 3D space
 * It is used only to facilitate the manipulations made on OpenAL source objects
 * It also manages a unique Auxiliary Send so that we can have unique effect values for each source (TODO)
 * There is no need for any getter method (but might as well add some for good measure later on)
 */

//TODO : error handling
public class Source {
    //The index for the OpenAL source
    int source;

    public Source(int s){
        source = s;
        //Setting the properties that remain the same for each source at any time
        alSource3f(source,AL_VELOCITY,0,0,0);
        alSourcef(source,AL_MAX_GAIN,4.0f);
    }//Overloaded just in case
    public Source(int s, float x, float y, float z){
        source = s;
        alSource3f(source,AL_POSITION,x,y,z);
        //Setting the properties that remain the same for each source at any time
        alSource3f(source,AL_VELOCITY,0,0,0);
        alSourcef(source,AL_MAX_GAIN,4.0f);
    }

    //Here are the setter methods
    public void setPosition(float x, float y, float z){
        alSource3f(source,AL_POSITION,x,y,z);
    }

    public void setDirection(float x, float y, float z){
        alSource3f(source,AL_DIRECTION,x,y,z);
    }

    public void setGain(float gain){
        alSourcef(source,AL_GAIN,gain);
    }
}
