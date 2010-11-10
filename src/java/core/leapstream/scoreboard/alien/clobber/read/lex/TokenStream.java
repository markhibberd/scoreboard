package leapstream.scoreboard.alien.clobber.read.lex;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface TokenStream {
    Token take(Token.Type... types);

    Token expect(Token.Type... types);

    boolean is(Token.Type... types);

    boolean isEmpty();
}
