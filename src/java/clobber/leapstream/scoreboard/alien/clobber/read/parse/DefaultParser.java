package leapstream.scoreboard.alien.clobber.read.parse;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.alien.clobber.read.lex.Token;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultParser implements Parser {
    ParserFactory factory;
    TypeMapper typer;
    Impl impl;

    public Object parse(TokenStream tokens) {
        Class cls = cls(tokens);
        Parser parser = factory.nu(cls);
        return parser.parse(tokens);
    }

    private Class cls(TokenStream tokens) {
        Token cls = tokens.expect(CLASS);
        String name = cls.lexeme();
        return typer.map(name);
    }
}
