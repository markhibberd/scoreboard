package leapstream.scoreboard.alien.clobber.read.parse;

import au.net.netstorm.boost.gunge.reflect.cls.Classes;
import au.net.netstorm.boost.gunge.sledge.java.lang.EdgeClass;

import java.util.List;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class DefaultTypeMapper implements TypeMapper {
    List<NameMapper> mappers;
    EdgeClass classer;
    Classes classes;

    public Class map(String input) {
        for (NameMapper mapper : mappers) {
            if (ok(mapper, input)) return map(mapper, input);
        }
        throw new IllegalArgumentException("Can not map type for: " + input);
    }

    public void add(NameMapper mapper) {
        mappers.add(mapper);
    }

    private Class map(NameMapper mapper, String input) {
        String name = mapper.map(input);
        return classer.forName(name);
    }

    private boolean ok(NameMapper mapper, String input) {
        String name = mapper.map(input);
        return classes.exists(name);
    }
}
