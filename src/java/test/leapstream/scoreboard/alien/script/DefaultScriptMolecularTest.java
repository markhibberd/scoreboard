package leapstream.scoreboard.alien.script;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

public final class DefaultScriptMolecularTest extends ScoreboardTestCase implements InjectableTest {
    Script subject;
    Edges edges;
    Args args;

    public void testSingle() {
        URL url = url("foo.js");
        args.put("config", "boo");
        // FIX 1531 This puts spew to stdout.  aaaaaaaaaaaarrrrrrrrrrgggggh
        subject.execute(args, url);
    }

    public void testMultiple() {
        URL foo = url("foo.js");
        URL bar = url("bar.js");
        args.put("config", "boo");
        // FIX 1531 This puts spew to stdout.  aaaaaaaaaaaarrrrrrrrrrgggggh
        subject.execute(args, foo, bar);
    }

    private URL url(String script) {
        Class cls = getClass();
        java.net.URL resource = cls.getResource(script);
        return edges.ref(URL.class, resource);
    }
}
