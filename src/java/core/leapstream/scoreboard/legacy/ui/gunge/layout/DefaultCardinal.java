package leapstream.scoreboard.legacy.ui.gunge.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class DefaultCardinal implements Cardinal {
    public void order(Component[] tiles, Dimension dimension) {
        Random random = random(tiles, dimension);
        List<Component> list = Arrays.asList(tiles);
        Collections.shuffle(list, random);
        list.toArray(tiles);
    }

    private Random random(Component[] tiles, Dimension dimension) {
        Random random = new Random();
        int seed = Arrays.hashCode(tiles);
        seed ^= dimension.width * 31;
        seed ^= dimension.height * 13;
        random.setSeed(seed);
        return random;
    }
}
