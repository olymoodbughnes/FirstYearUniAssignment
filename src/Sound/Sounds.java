package Sound;
import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Sounds {
    private static SoundClip background;
    private static SoundClip background2;
    private static SoundClip background3;

    static
    {
        try{


            background  = new SoundClip("data/BgM.wav");

            background2  = new SoundClip("data/BgM2.wav");

            background3  = new SoundClip("data/BgM3.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            ex.printStackTrace();
        }
    }
public static SoundClip getBackground(){

        return background;
}
    public static SoundClip getBackground2(){

        return background2;
    }

    public static SoundClip getBackground3(){

        return background3;
    }

}
