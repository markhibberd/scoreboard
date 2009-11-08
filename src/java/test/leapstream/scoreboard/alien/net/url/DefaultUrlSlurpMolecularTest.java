package leapstream.scoreboard.alien.net.url;

import au.net.netstorm.boost.sniper.marker.InjectableTest;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;
// FIX 2040 Feb 25, 2009 Rename this to UrlGetter<OutOfTheBox>Test.
// FIX 2040 Feb 25, 2009 There is a need for OutOfTheBox tests but should be small number.
public final class DefaultUrlSlurpMolecularTest extends ScoreboardTestCase implements InjectableTest {
    UrlSlurper<String> slurper;

    public void test() {
        // FIX This is crap.
//        check("<html>", "http://www.google.com");
//        check("Score[", "https://boost:boost@geekscape.org/dashboard/tab/score/boost");
//        check("\n\n<!DOCTYPE html", "https://www.comsec.com.au");
    }

    private void check(String expected, String location) {
        String content = slurper.slurp(location);
        boolean actual = content.startsWith(expected);
        assertEquals(true, actual);
    }
}