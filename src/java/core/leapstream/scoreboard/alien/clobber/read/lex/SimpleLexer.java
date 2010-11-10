package leapstream.scoreboard.alien.clobber.read.lex;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
// FIX 1202 Use or lose. Wire into more complex lexer.
public interface SimpleLexer {
    List<SimpleToken> lex(String simple);
}
