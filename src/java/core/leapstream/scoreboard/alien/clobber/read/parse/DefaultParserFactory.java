package leapstream.scoreboard.alien.clobber.read.parse;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.gunge.type.Immutable;
import au.net.netstorm.boost.spider.api.runtime.Impl;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
// DEBT CyclomaticComplexity|NCSS|ReturnCount {
public final class DefaultParserFactory implements ParserFactory {
    Impl impl;

    public Parser nu(Class cls) {
        if (is(TimePoint.class, cls)) return impl.impl(TimePointParser.class);
        // FIX 1202 Jan 12, 2009 Does this deal with just Incredibles.  Sort.
        if (is(Immutable.class, cls)) return impl.impl(ImmutableParser.class, cls);
        if (is(Enum.class, cls)) return impl.impl(EnumParser.class, cls);
        if (is(String.class, cls)) return impl.impl(StringParser.class);
        if (is(List.class, cls)) return impl.impl(ListParser.class);
        throw new IllegalArgumentException("Unsupported type: " + cls);
    }

    private boolean is(Class expected, Class cls) {
        return expected.isAssignableFrom(cls);
    }
}
// } DEBT CyclomaticComplexity|NCSS|ReturnCount