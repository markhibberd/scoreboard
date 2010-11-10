package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.CLOSE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.EQUALS;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.NEWLINE;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.OPEN;
import static leapstream.scoreboard.alien.clobber.read.lex.SimpleToken.Type.STRING;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.FIELD;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultNuLexer implements NuLexer {
    Nu nu;
    SimpleLexer lexer;

    public TokenStream lex(String string) {
        List input = lexer.lex(string);
        List output = nu.nu(List.class);
        parseClass(input, output);
        return nu.nu(TokenStream.class, output);
    }

    private void parseClass(List input, List output) {
        SimpleToken token = expect(input, STRING);
        parseClass(input, token, output);
    }

    private void parseClass(List input, SimpleToken token, List output) {
        String lexeme = token.lexeme();
        nu(CLASS, lexeme, output);
        classBody(input, output);
    }

    private void classBody(List tokens, List output) {
        expectOpen(tokens);
        classGuts(tokens, output);
        expectClose(tokens);
        nu(END, "]", output);
    }

    private void expectClose(List tokens) {
        expect(tokens, CLOSE);
        optionalNewline(tokens);
    }

    private void expectOpen(List tokens) {
        expect(tokens, OPEN);
        optionalNewline(tokens);
    }

    private void optionalNewline(List tokens) {
        if (is(tokens, NEWLINE))
            expect(tokens, NEWLINE);
    }

    private void classGuts(List tokens, List output) {
        if (is(tokens, STRING)) {
            classHolderOrField(tokens, output);
        } else {
            classEmptyHolder(output);
        }
    }

    private void classHolderOrField(List tokens, List output) {
        SimpleToken token = expect(tokens, STRING);
        if (is(tokens, EQUALS))
            field(tokens, output, token);
        else
            nu(VALUE, token.lexeme(), output);
    }

    private void field(List tokens, List output, SimpleToken token) {
        String name = token.lexeme();
        nu(FIELD, name, output);
        expect(tokens, EQUALS);
        SimpleToken string = expect(tokens, STRING);
        fieldBody(tokens, string, output);
        optionalField(tokens, output);
    }

    private void fieldBody(List tokens, SimpleToken string, List output) {
        if (is(tokens, OPEN))
            parseClass(tokens, string, output);
        else {
            String lexeme = string.lexeme();
            nu(VALUE, lexeme, output);
        }
    }

    private void optionalField(List tokens, List output) {
        if (is(tokens, CLOSE)) return;
        SimpleToken recurse = expect(tokens, STRING);
        field(tokens, output, recurse);
    }

    private void classEmptyHolder(List output) {
        nu(VALUE, "", output);
    }

    private SimpleToken expect(List<SimpleToken> tokens, SimpleToken.Type type) {
        SimpleToken token = tokens.remove(0);
        guard(token, type);
        return token;
    }

    private boolean is(List<SimpleToken> tokens, SimpleToken.Type type) {
        if (tokens.isEmpty()) return false;
        SimpleToken token = tokens.get(0);
        return token.type() == type;
    }

    private void nu(Token.Type type, String lexeme, List<Token> output) {
        Token token = nu.nu(Token.class, type, lexeme);
        output.add(token);
    }

    private void guard(SimpleToken token, SimpleToken.Type expected) {
        SimpleToken.Type type = token.type();
        if (type == expected) return;
        throw new IllegalStateException(" expected: " + expected + " got: " + type);
    }
}
