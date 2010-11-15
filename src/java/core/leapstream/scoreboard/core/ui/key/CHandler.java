package leapstream.scoreboard.core.ui.key;

import leapstream.scoreboard.core.ui.config.ConfigPrompt;

public class CHandler implements Handler {
    ConfigPrompt configPrompt;

    public void u() {
        configPrompt.get();
    }
}
