package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.FIELD;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_ELEMENT;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_START;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
// DEBT CyclomaticComplexity|NCSS {
public final class DefaultLexer implements Lexer {
    private final Scanner scanner;
    List<Token> tokens;
    Nu nu;

    public DefaultLexer(Scanner scanner) {
        this.scanner = scanner;
    }

    public TokenStream lex() {
        cls();
        return nu.nu(TokenStream.class, tokens);
    }

    private void cls() {
        String cls = scanner.scanPast('[');
        token(CLASS, cls);
        value();
    }

    private void value() {
        if (scanner.lookahead("\\w+\n")) simple();
        else if (scanner.lookahead("[\\w-\\.]+\\]")) holder();
        else if (scanner.lookahead("\\w+\\[")) cls();
        else if (scanner.lookahead("\\[")) list();
        else if (scanner.lookahead("\\w+=")) field();
        else if (scanner.lookahead("\\]")) end();
        else throw new IllegalStateException("" + scanner);
    }

    private void end() {
        lexTo(END, ']');
    }

    private void field() {
        String name = scanner.scanPast('=');
        token(FIELD, name);
        value();
        nextField();
    }

    private void holder() {
        String value = scanner.scanPast(']');
        token(VALUE, value);
        token(END, "]");
    }

    private void simple() {
        String value = scanner.scanPast('\n');
        token(VALUE, value);
    }

    private void list() {
        lexTo(LIST_START, '[');
        if (!scanner.lookahead("\\]")) element();
        lexTo(LIST_END, ']');
        // FIX 375 this is nasty, it is to handle the holder[list] pattern, shows an inconsistency between token types.
        if (scanner.lookahead("\\]")) end();
    }

    private void element() {
        cls();
        nextElement();
    }

    private void nextField() {
        value();
    }

    private void nextElement() {
        if (scanner.lookahead(",")) {
            lexTo(LIST_ELEMENT, ',');
            element();
        }
    }

    private void token(Token.Type type, String lexeme) {
        Token token = nu.nu(Token.class, type, lexeme);
        tokens.add(token);
    }

    private void lexTo(Token.Type f, char c) {
        String s = c + "";
        scanner.scanPast(c);
        token(f, s);
    }
}
// } DEBT CyclomaticComplexity|NCSS