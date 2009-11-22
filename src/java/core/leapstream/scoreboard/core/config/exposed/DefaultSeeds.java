package leapstream.scoreboard.core.config.exposed;

import au.net.netstorm.boost.gunge.collection.StrictMap;

import java.util.Iterator;
import java.util.Set;

public class DefaultSeeds implements Seeds {
    StrictMap<String, Seed> seeds;

    public void put(Seed seed) {
        String key = seed.key();
        if (seeds.exists(key)) barf(key);
        seeds.put(key, seed);
    }

    public Seed get(String key) {
        return seeds.get(key);
    }

    public Iterator<String> iterator() {
        Set<String> iterator = seeds.keySet();
        return iterator.iterator();
    }

    private void barf(String key) {
        throw new IllegalArgumentException("Two config seeds have the same key [" + key + "].");
    }
}
