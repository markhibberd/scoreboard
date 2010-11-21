package leapstream.scoreboard.legacy.script;

import leapstream.scoreboard.legacy.edge.java.net.URL;

// FIX 244 Name.
public interface Script {
    Object execute(Args args, URL url);
    void execute(Args args, URL... urls);
}
