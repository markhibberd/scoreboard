package leapstream.scoreboard.core.config;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import leapstream.scoreboard.core.bits.Bits;
import leapstream.scoreboard.core.gunge.Urler;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultConfigurator implements Configurator {
    ArrayMaster arrays;
    ConfiguratorFu fu;
    Urler urler;
    Bits bits;

    public void config(String... strings) {
        URL[] env = env(strings);
        fu.config(env);
    }

    private URL[] env(String... strings) {
        URL[] env = {bits.url("core.js")};
        URL[] urls = urler.get(strings);
        return arrays.plus(env, urls);
    }
}
