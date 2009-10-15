package leapstream.scoreboard.alien.clobber.test;

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;

import java.util.Arrays;
import java.util.List;

public final class DefaultFixture implements Fixture {
    TimeFactory times;
    Nu nu;

    public Root data() {
        TimePoint time = times.time(12345654321L);
        SingleVal single = nu.nu(SingleVal.class, "sval");
        MultiVal multi = nu.nu(MultiVal.class, "xval", "yval");
        Element element = nu.nu(Element.class, "el");
        Element[] elements = {element, element, element};
        List list = Arrays.asList(elements);
        SingleValList singleList = nu.nu(SingleValList.class, list);
        return nu.nu(Root.class, time, Enumeriffic.FOO, single, multi, list, singleList);
    }
}
