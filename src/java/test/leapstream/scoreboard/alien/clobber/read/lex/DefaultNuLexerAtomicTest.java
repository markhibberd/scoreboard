package leapstream.scoreboard.alien.clobber.read.lex;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.FIELD;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_ELEMENT;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_START;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;
import leapstream.scoreboard.test.framework.testcase.ScoreboardTestCase;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultNuLexerAtomicTest extends ScoreboardTestCase implements InjectableTest, HasFixtures {
    private static final String FLURGLE = "Flurgle";
    private static final String BARNY = "Barny";
    private static final String HELLO = "hello-there";
    private static final String BLETCH = "bletch";
    private static final String FRED = "fred";
    private static final String FOO = "foo";
    private static final String BAR = "Bar";
    private static final String GOOBER = "goober";
    private static final String FIELD1 = FRED + "=" + BARNY + "[" + BLETCH + "]\n";
    private static final String FIELD2 = FOO + "=" + BAR + "[" + GOOBER + "]\n";
    private static final String FIELD3 = FRED + "=" + GOOBER;
    private static final String LIST = "[" + BARNY + "[" + BLETCH + "], " + BARNY + "[" + GOOBER + "]" + "]";
    private static final String EMPTY_LIST = "[" + "]";
    private Token class_flurgle;
    private Token class_barny;
    private Token value_hello;
    private Token value_bletch;
    private Token field_fred;
    private Token field_foo;
    private Token class_bar;
    private Token value_goober;
    private Token list_start;
    private Token list_element;
    private Token list_end;
    private Token value_empty;
    private Token end;
    NuLexer subject;
    Nu nu;

    public void fixtures() {
        class_flurgle = nu.nu(Token.class, CLASS, FLURGLE);
        class_barny = nu.nu(Token.class, CLASS, BARNY);
        value_hello = nu.nu(Token.class, VALUE, HELLO);
        value_bletch = nu.nu(Token.class, VALUE, BLETCH);
        field_fred = nu.nu(Token.class, FIELD, FRED);
        field_foo = nu.nu(Token.class, FIELD, FOO);
        class_bar = nu.nu(Token.class, CLASS, BAR);
        value_goober = nu.nu(Token.class, VALUE, GOOBER);
        value_empty = nu.nu(Token.class, VALUE, "");
        list_start = nu.nu(Token.class, LIST_START, "[");
        list_element = nu.nu(Token.class, LIST_ELEMENT, ",");
        list_end = nu.nu(Token.class, LIST_END, "]");
        end = nu.nu(Token.class, END, "]");
    }

    // FIX 1202 Complete.
    public void testMinimal() {
        String input = FLURGLE + "[" + "]";
        Token[] expected = {class_flurgle, value_empty, end};
        check(expected, input);
    }

    public void testHolder() {
        String input = FLURGLE + "[" + HELLO + "]";
        Token[] expected = {class_flurgle, value_hello, end};
        check(expected, input);
    }

    public void testSimpleField() {
        String input = FLURGLE + "[" + FIELD3 + "]\n";
        Token[] expected = {class_flurgle, field_fred, value_goober, end};
        check(expected, input);
    }

    public void testOneField() {
        String input = FLURGLE + "[\n" + FIELD1 + "]\n";
        Token[] expected = {class_flurgle, field_fred, class_barny, value_bletch, end, end};
        check(expected, input);
    }

    public void testTwoFields() {
        String input = FLURGLE + "[\n" + FIELD1 + FIELD2 + "]\n";
        Token[] expected = {class_flurgle,
                field_fred, class_barny, value_bletch, end,
                field_foo, class_bar, value_goober, end,
                end
        };
        check(expected, input);
    }
//    public void testList() {
//        String input = FLURGLE + "[" + LIST + "]";
//        Token[] expected = {class_flurgle, list_start,
//                class_barny, value_bletch, end, list_element,
//                class_barny, value_goober, end,
//                list_end, end};
//        check(expected, input);
//    }
//
//    public void testEmptyList() {
//        String input = FLURGLE + "[" + EMPTY_LIST + "]";
//        Token[] expected = {class_flurgle, list_start, list_end, end};
//        check(expected, input);
//    }

    private void check(Token[] expected, String string) {
        TokenStream actual = call(string);
        check(expected, actual);
    }

    private TokenStream call(String string) {
        return subject.lex(string);
    }

    private void check(Token[] expectedTokens, TokenStream actualStream) {
        for (Token expected : expectedTokens)
            check(expected, actualStream);
        assertEquals(true, actualStream.isEmpty());
    }

    private void check(Token expected, TokenStream stream) {
        Token.Type type = expected.type();
        Token actual = stream.take(type);
        assertEquals(expected, actual);
    }
}
