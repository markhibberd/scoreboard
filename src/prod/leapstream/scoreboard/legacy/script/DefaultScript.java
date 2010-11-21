package leapstream.scoreboard.legacy.script;

import leapstream.scoreboard.legacy.resource.gunge.StringSlurper;
import leapstream.scoreboard.legacy.edge.java.io.InputStream;
import leapstream.scoreboard.legacy.edge.java.net.URL;
import leapstream.scoreboard.legacy.edge.java.net.URLConnection;
import leapstream.scoreboard.legacy.edge.javax.script.ScriptEngine;

public final class DefaultScript implements Script {
    StringSlurper slurper;
    Engines engines;
    ScriptFu fu;

    public Object execute(Args args, URL url) {
        ScriptEngine engine = engine(args, url);
        return execute(engine, url);
    }

    public void execute(Args args, URL... urls) {
        if (urls.length == 0) return;
        ScriptEngine engine = engine(args, urls);
        execute(engine, urls);
    }

    private ScriptEngine engine(Args args, URL... urls) {
        ScriptEngine engine = engine(urls);
        fu.bind(engine, args);
        return engine;
    }

    private Object execute(ScriptEngine engine, URL url) {
        String script = script(url);
        return engine.eval(script);
    }

    private void execute(ScriptEngine engine, URL... urls) {
        for (URL url : urls) execute(engine, url);
    }

    public String script(URL url) {
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        return slurper.slurp(in);
    }

    // FIX LEAPERS Feb 6, 2009 Check all urls use the same engine??
    private ScriptEngine engine(URL... urls) {
        return engines.byExt(urls[0]);
    }
}
