package leapstream.scoreboard.alien.ui.audio.voice;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import leapstream.scoreboard.alien.ui.audio.core.Playable;

public class VoicePlayable implements Playable {
    private static final String VOICE = "kevin16";
    private String msg;

    // FIX AUDIO sort this property crap.
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    }

    public VoicePlayable(String msg) {
        this.msg = msg;
    }

    public void play() {
        Voice voice = getVoice();
        voice.allocate();
        voice.speak(msg);
        voice.deallocate();
    }

    private Voice getVoice() {
        VoiceManager manager = VoiceManager.getInstance();
        Voice voice = manager.getVoice(VOICE);
        if (voice == null) throw new IllegalArgumentException();
        return voice;
    }
}
