package leapstream.scoreboard.alien.clobber.gunge;

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import leapstream.scoreboard.alien.gunge.TimePointFormatter;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

public final class DefaultTimePointFormatterMolecularTest extends ScoreboardTestCase implements InjectableTest, HasFixtures {
    private String format = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
    private String text = "2008-09-02T21:05:50Z";
    private Long millis = 1220389550000L;
    private TimePoint time;
    TimePointFormatter subject;
    TimeFactory times;

    public void fixtures() {
        time = times.time(millis);
    }

    public void testEmit() {
        String string = subject.emit(time);
        assertEquals(true, string.matches(format));
    }

    public void testParse() {
        TimePoint time = subject.parse(text);
        assertEquals(millis, time.getMillis());
    }

    public void testSymmetricalEmitParse() {
        String string = subject.emit(time);
        TimePoint actual = subject.parse(string);
        assertEquals(time, actual);
    }

    public void testSymmetricalParseEmit() {
        TimePoint time = subject.parse(text);
        String actual = subject.emit(time);
        assertEquals(text, actual);
    }
}
