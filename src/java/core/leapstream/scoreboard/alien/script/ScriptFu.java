package leapstream.scoreboard.alien.script;

import leapstream.scoreboard.edge.javax.script.ScriptEngine;

public interface ScriptFu {
    void bind(ScriptEngine engine, Args args);
}
