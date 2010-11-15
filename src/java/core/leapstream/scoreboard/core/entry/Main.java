package leapstream.scoreboard.core.entry;

import au.net.netstorm.boost.gunge.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.spider.api.entry.SpiderMain;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;

// OK GenericIllegalRegexp {
public final class Main {
    public static void main(String[] args) {
        try {
            go(args);
        } catch (Throwable t) {
            handle(t);
        }
    }

    private static void go(String[] args) {
        new SpiderMain(BoostWeb.class, ScoreboardWeb.class).main(ScoreboardGo.class, args);
    }

    private static void handle(Throwable t) {
        ThrowableMaster master = new DefaultThrowableMaster();
        Throwable cause = master.realCause(t);
        System.err.println("Error starting scoreboard [" + cause.getClass().getSimpleName() + ":" + cause.getMessage());
        System.err.println("Set system property scoreboard.debug=true for complete stack trace.");
        System.err.println("usage: java -jar scoreboard-all.jar [-l|--lib configPrompt-libraries.(js|bsh) ...] configPrompt.js");
        if (debug())
            cause.printStackTrace();
        System.exit(1);
    }

    // FIX pull this out.
    private static boolean debug() {
        String prop = System.getProperty("scoreboard.debug", "false");
        return "true".equals(prop.toLowerCase()) || "1".equals(prop) || "yes".equals(prop);
    }
}
// } OK GenericIllegalRegexp