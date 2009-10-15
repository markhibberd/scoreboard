package leapstream.scoreboard.alien.script;

import leapstream.scoreboard.edge.java.net.URL;

// FIX 244 Name.
public interface Script {
    Object execute(Args args, URL url);
    void execute(Args args, URL... urls);
}
