package leapstream.scoreboard.core.config.exposed;

import au.net.netstorm.boost.spider.api.runtime.Nu;

public class DefaultConfigRegistry implements ConfigRegistry {
    private static final String NO_DOC = "[undocumented feature; here be dragons!]";
    Applicators applicators;
    Seeds seeds;
    Nu nu;

    public void register(String key, String doc, Object target, String method) {
        Applicator applicator = applicators.bind(target, method);
        register(key, doc, applicator);
    }

    public void register(String key, Object target, String method) {
        register(key, NO_DOC, target, method);
    }

    public void register(String key, String doc, Applicator applicator) {
        Seed seed = nu.nu(Seed.class, key, doc, applicator);
        seeds.put(seed);
    }

    public void register(String key, Applicator applicator) {
        register(key, NO_DOC, applicator);
    }
}
