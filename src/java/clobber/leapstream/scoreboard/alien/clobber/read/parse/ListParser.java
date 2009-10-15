package leapstream.scoreboard.alien.clobber.read.parse;

import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_ELEMENT;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_START;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class ListParser implements Parser {
    List elements;
    Parser parser;

    public Object parse(TokenStream tokens) {
        tokens.take(LIST_START);
        elements(tokens);
        tokens.take(LIST_END);
        return elements;
    }

    private void elements(TokenStream tokens) {
        if (tokens.is(LIST_END)) return;
        Object element = parser.parse(tokens);
        elements.add(element);
        if (tokens.is(LIST_ELEMENT)) next(tokens);
    }

    private void next(TokenStream tokens) {
        tokens.take(LIST_ELEMENT);
        elements(tokens);
    }
}
