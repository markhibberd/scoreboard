package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.CLOSE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.EQUALS;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.NEWLINE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.OPEN;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.STRING;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

import java.util.Arrays;
import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultSimpleLexerAtomicTest extends ScoreboardTestCase implements HasFixtures, InjectableTest {
    private SimpleToken moo_token;
    private SimpleToken boo_token;
    private SimpleToken start_token;
    private SimpleToken end_token;
    private SimpleToken text_token;
    private SimpleToken equals_token;
    private SimpleToken newline_token;
    String moo = "Moo";
    String boo = "Boo";
    String start = "[";
    String end = "]";
    String text = "hello world";
    String equals = "=";
    String newline = "\n";
    String classer = moo + start + end;
    String holder = moo + start + text + end;
    String field = moo + equals + text;
    String silly = boo + start + newline + end;
    SimpleLexer subject;
    Nu nu;

    public void fixtures() {
        moo_token = nu.nu(SimpleToken.class, STRING, moo);
        boo_token = nu.nu(SimpleToken.class, STRING, boo);
        start_token = nu.nu(SimpleToken.class, OPEN, start);
        end_token = nu.nu(SimpleToken.class, CLOSE, end);
        text_token = nu.nu(SimpleToken.class, STRING, text);
        equals_token = nu.nu(SimpleToken.class, EQUALS, equals);
        newline_token = nu.nu(SimpleToken.class, NEWLINE, newline);
    }

    // FIX 1202 implement me
    public void test() {
        check(moo, moo_token);
        check(boo, boo_token);
        check(start, start_token);
        check(end, end_token);
        check(classer, moo_token, start_token, end_token);
        check(holder, moo_token, start_token, text_token, end_token);
        check(field, moo_token, equals_token, text_token);
        check(silly, boo_token, start_token, newline_token, end_token);
    }

    private void check(String text, SimpleToken... expected) {
        List<SimpleToken> actual = subject.lex(text);
        check(expected, actual);
    }

    private void check(SimpleToken[] expected, List<SimpleToken> actual) {
        List<SimpleToken> tokenList = Arrays.asList(expected);
        assertEquals(tokenList, actual);
    }
}
