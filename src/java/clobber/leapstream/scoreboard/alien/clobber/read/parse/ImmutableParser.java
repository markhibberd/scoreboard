package leapstream.scoreboard.alien.clobber.read.parse;

import au.net.netstorm.boost.bullet.incredibles.core.Incredibles;
import au.net.netstorm.boost.bullet.incredibles.core.Strong;
import au.net.netstorm.boost.bullet.incredibles.engine.type.StrongTyper;
import au.net.netstorm.boost.gunge.collection.FunctionalMaestro;
import au.net.netstorm.boost.gunge.goop.Nvp;
import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.clobber.read.lex.Token;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.CLASS;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.END;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.FIELD;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.LIST_START;
import static leapstream.scoreboard.alien.clobber.read.lex.Token.Type.VALUE;
import leapstream.scoreboard.alien.clobber.read.lex.TokenStream;

import java.lang.reflect.Method;
import java.util.List;
// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.

// FIX 1202 Dec 23, 2008 This needs some love, but is about to be rewritten as S-EXP.
public final class ImmutableParser implements Parser {
    private final Class type;
    List<Nvp> specs;
    Incredibles incredibles;
    StrongTyper auto;
    ParserFactory factory;
    LayerFactory proxies;
    LayerFactory layers;
    EdgeClass classer;
    Marker marker;
    Impl impl;
    Nu nu;
    FunctionalMaestro fm;

    public ImmutableParser(Class type) {
        this.type = type;
    }

    public Object parse(TokenStream tokens) {
        tokens.take(CLASS);
        return content(tokens);
    }

    private Object content(TokenStream tokens) {
        tokens.expect(END, VALUE, CLASS, LIST_START, FIELD);
        if (tokens.is(END)) return resolve(tokens);
        if (tokens.is(VALUE, CLASS, LIST_START)) return anon(tokens);
        if (tokens.is(FIELD)) named(tokens);
        return content(tokens);
    }

    private void named(TokenStream tokens) {
        String name = name(tokens);
        field(tokens, name);
    }

    private Object anon(TokenStream tokens) {
        return strong(type) ? strong(tokens) : struct(tokens);
    }

    private Object struct(TokenStream tokens) {
        Method[] methods = type.getMethods();
        if (methods.length != 1) throw new IllegalStateException("Anonymous values not valid for multi attributed types.");
        String name = methods[0].getName();
        field(tokens, name);
        return resolve(tokens);
    }

    private Object strong(TokenStream tokens) {
        field(tokens, "");
        return resolve(tokens);
    }

    private void field(TokenStream tokens, String name) {
        tokens.expect(VALUE, CLASS, LIST_START);
        Class type = retrn(name);
        Parser parser = factory.nu(type);
        Object value = parser.parse(tokens);
        Nvp spec = nu.nu(Nvp.class, name, value);
        specs.add(spec);
    }

    private Class retrn(String name) {
        return strong(type) ? auto.weak(type) : methodrtn(name);
    }

    private Class methodrtn(String name) {
        Method method = classer.getDeclaredMethod(type, name);
        return method.getReturnType();
    }

    private String name(TokenStream tokens) {
        Token token = tokens.take(FIELD);
        return token.lexeme();
    }

    private Object resolve(TokenStream tokens) {
        tokens.take(END);
        Interface iface = nu.nu(Interface.class, type);
        Nvp[] fields = specs();
        Object[] values = values(fields);
        return incredibles.nu(iface, values);
    }

    private Object[] values(Nvp[] fields) {
        Object[] values = new Object[fields.length];
        for (int i = 0; i < values.length; ++i) values[i] = fields[i].value();
        return values;
    }

    private Nvp[] specs() {
        Nvp[] result = new Nvp[specs.size()];
        return specs.toArray(result);
    }

    public boolean strong(Class type) {
        return Strong.class.isAssignableFrom(type);
    }
}

