package leapstream.scoreboard.alien.clobber.read.parse;

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import leapstream.scoreboard.alien.clobber.read.lex.Token;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class TimePointParser implements Parser {
    TimeFactory times;

    public Object parse(TokenStream tokens) {
        tokens.take(CLASS);
        Long millis = millis(tokens);
        tokens.take(END);
        return times.time(millis);
    }

    private Long millis(TokenStream tokens) {
        Token millis = tokens.take(VALUE);
        String raw = millis.lexeme();
        return Long.parseLong(raw);
    }
}
