package leapstream.scoreboard.alien.clobber.read.parse;

import leapstream.scoreboard.alien.clobber.read.lex.Token;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class EnumParser implements Parser {
    private final Class type;

    public EnumParser(Class type) {
        this.type = type;
    }

    public Object parse(TokenStream tokens) {
        Token token = tokens.take(VALUE);
        String value = token.lexeme();
        return Enum.valueOf(type, value);
    }
}