package leapstream.scoreboard.alien.script;

import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.Iterator;
import java.util.List;

public final class DefaultArgs implements Args {
    List<Arg> list;
    Nu nu;

    public void put(String name, Object value) {
        Arg arg = nu.nu(Arg.class, name, value);
        list.add(arg);
    }

    public Iterator<Arg> iterator() {
        return list.iterator();
    }
}
