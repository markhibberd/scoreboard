package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.CLOSE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.EQUALS;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.NEWLINE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.OPEN;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.STRING;

import java.util.List;
// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.

// FIX 1202 Use or lose.
// DEBT CyclomaticComplexity|NCSS|ReturnCount {
public final class DefaultSimpleLexer implements SimpleLexer {
    Nu nu;

    public List<SimpleToken> lex(String text) {
        List<SimpleToken> result = nu.nu(List.class);
        lex(text, result);
        return result;
    }

    private void lex(String text, List<SimpleToken> result) {
        StringBuilder builder = new StringBuilder(text);
        while (!isEmpty(builder)) {
            lexOne(builder, result);
        }
    }

    private void lexOne(StringBuilder builder, List<SimpleToken> result) {
        SimpleToken token = lexOne(builder);
        result.add(token);
    }

    private SimpleToken lexOne(StringBuilder builder) {
        SimpleToken.Type type = classify(builder);
        String lexeme = chunk(builder, type);
        return nu.nu(SimpleToken.class, type, lexeme);
    }

    private String chunk(StringBuilder builder, SimpleToken.Type type) {
        StringBuilder token = new StringBuilder();
        while (!isEmpty(builder) && classify(builder) == type) snip(builder, token);
        return token.toString();
    }

    private void snip(StringBuilder builder, StringBuilder token) {
        char c = builder.charAt(0);
        builder.deleteCharAt(0);
        token.append(c);
    }

    private boolean isEmpty(StringBuilder builder) {
        return builder.length() == 0;
    }

    private SimpleToken.Type classify(StringBuilder builder) {
        char c = builder.charAt(0);
        return classify(c);
    }

    private SimpleToken.Type classify(char c) {
        if (c == '[')
            return OPEN;
        if (c == ']')
            return CLOSE;
        if (c == '=')
            return EQUALS;
        if (c == '\n')
            return NEWLINE;
        return STRING;
    }
}
// } DEBT CyclomaticComplexity|NCSS|ReturnCount