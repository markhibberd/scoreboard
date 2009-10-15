package leapstream.scoreboard.alien.clobber.core;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.alien.gunge.Resources;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

public final class DefaultSlurperMolecularTest extends ScoreboardTestCase implements InjectableTest {
    Slurper subject;
    SlurperChecker checker;
    Impl impl;
    Edges edges;
    Resources resources;

    public void test() {
        InputStream stream = resources.stream("leapstream/scoreboard/alien/clobber/core/simple-to-test.bill");
        checker.check(subject, stream);
    }
}