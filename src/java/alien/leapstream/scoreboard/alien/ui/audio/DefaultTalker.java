package leapstream.scoreboard.alien.ui.audio;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class DefaultTalker extends Primordial implements Talker {
    private static final String VOICE = "kevin16";

    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    }

    public void say(String msg) {
        // FIX 826 Get rid of in favour of synchronous / locking / layer.
        // FIX 826 Look at singletons across spiders and how that all works.
        synchronized (AudioLock.class) {
            locked(msg);
        }
    }

    private void locked(String msg) {
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
