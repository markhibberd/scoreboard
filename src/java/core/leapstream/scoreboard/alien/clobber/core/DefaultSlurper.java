package leapstream.scoreboard.alien.clobber.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.clobber.read.lex.Lexer;
import leapstream.scoreboard.alien.clobber.read.lex.Scanner;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;
import leapstream.scoreboard.alien.clobber.read.parse.Parser;
import leapstream.scoreboard.alien.gunge.StringSlurper;
import leapstream.scoreboard.edge.java.io.InputStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultSlurper implements Slurper {
    StringSlurper stringer;
    Parser parser;
    Nu nu;

    public <T> T slurp(Class<T> type, InputStream input) {
        String string = stringer.slurp(input);
        Object ref = parse(string);
        return type.cast(ref);
    }

    private Object parse(String string) {
        StringBuilder builder = new StringBuilder(string);
        Scanner scanner = nu.nu(Scanner.class, builder);
        Lexer lexer = nu.nu(Lexer.class, scanner);
        TokenStream tokens = lexer.lex();
        return parser.parse(tokens);
    }
}