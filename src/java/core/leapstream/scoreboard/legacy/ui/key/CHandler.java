package leapstream.scoreboard.legacy.ui.key;

import leapstream.scoreboard.legacy.ui.config.ConfigPrompt;

public class CHandler implements Handler {
    ConfigPrompt configPrompt;

    public void u() {
        configPrompt.get();
    }
}
