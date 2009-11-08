package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.gunge.collection.DefaultFunctionalMaestro;
import au.net.netstorm.boost.gunge.collection.FunctionalMaestro;
import au.net.netstorm.boost.gunge.collection.ObjectEqualityFilter;

import java.util.Arrays;
import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultTokenStream implements TokenStream {
    private final List<Token> tokens;
    private int index = 0;
    FunctionalMaestro fm = new DefaultFunctionalMaestro();

    public DefaultTokenStream(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token take(Token.Type... types) {
        Token token = expect(types);
        next();
        return token;
    }

    public Token expect(Token.Type... types) {
        if (!is(types)) fail("Unexpected token " + token() + " Expected one of " + Arrays.toString(types));
        return token();
    }

    public boolean is(Token.Type... types) {
        List<Token.Type> typesList = Arrays.asList(types);
        ObjectEqualityFilter<Token.Type> predicate = new ObjectEqualityFilter<Token.Type>(type());
        return fm.detect(typesList, predicate);
    }

    public boolean isEmpty() {
        return tokens.size() == index;
    }

    private void next() {
        ++index;
    }

    private Token.Type type() {
        return token().type();
    }

    private Token token() {
        if (index >= tokens.size()) fail("Parse not complete, unexpected end of tokens.");
        return tokens.get(index);
    }

    private void fail(String message) {
        throw new IllegalStateException(message + " : " + tokens);
    }
}
