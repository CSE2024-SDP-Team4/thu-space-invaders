package engine;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;


public class Sound {

    private static float masterchange = 1.0f;

    private static Clip musicClip;

    public static void backgroundmusic(){
        if (Core.MusicOn_Off == 1){
            try{
                String bgm = "Bgm/background.wav";

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                SetMasterGain(clip);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                musicClip = clip;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void bulletsound() {
        if (Core.EffectOn_Off == 1) {
            try {
                String bgm = "Bgm/ball.wav";

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                SetMasterGain(clip);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void explosionsound() {
        if (Core.EffectOn_Off == 1) {
            try {
                String bgm = "Bgm/bomb.wav";
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                SetMasterGain(clip);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void buttonsound() {
        if (Core.EffectOn_Off == 1) {
            try {
                String bgm = "Bgm/button.wav";
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                SetMasterGain(clip);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void MusicStop(){
        musicClip.stop();
    }

    public static void SetMasterGain(Clip clip){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(masterchange));
    }

    public static void setMasterChange(float newchange) {
        masterchange = newchange;
    }
}
