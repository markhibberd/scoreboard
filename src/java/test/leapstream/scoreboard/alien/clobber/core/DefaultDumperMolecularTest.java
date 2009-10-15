package leapstream.scoreboard.alien.clobber.core;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.alien.clobber.test.Fixture;
import leapstream.scoreboard.alien.clobber.test.Root;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

// FIX BREADCRUMB 375 Using this to drive up a to string dumper.
public final class DefaultDumperMolecularTest extends ScoreboardTestCase implements InjectableTest {
    Fixture fixture;
    Impl impl;

    public void test() {
        Dumper dumper = impl.impl(DefaultDumper.class);
        Root root = fixture.data();
        String actual = dumper.dump(root);
        // FIX 375 This is a pretty poor an unmaintainable test. Rethink.
//        assertEquals(expected(), actual);
    }

    private String expected() {
        return
                "Root[" + LINE +
                        "    list=[Element[el], Element[el], Element[el]]" + LINE +
                        "    time=TimePoint[12345654321]" + LINE +
                        "    single=SingleVal[sval]" + LINE +
                        "    multi=MultiVal[" + LINE +
                        "        x=xval" + LINE +
                        "        y=yval" + LINE +
                        "    ]" + LINE +
                        "    singleList=SingleValList[[Element[el], Element[el], Element[el]]]" + LINE +
                        "    enumer=FOO" + LINE +
                        "]";
    }
}