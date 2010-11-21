package leapstream.scoreboard.legacy.pylon;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultPylons implements Pylons {
    private List<PylonX> pylonXs = new CopyOnWriteArrayList<PylonX>();

    public void add(PylonX pylonX) {
        pylonXs.add(pylonX);
    }

    public List<PylonX> mandatory() {
        return accumulate(true);
    }

    public List<PylonX> optional() {
        return accumulate(false);
    }

    public Iterator<PylonX> iterator() {
        return pylonXs.iterator();
    }

    private List<PylonX> accumulate(boolean mandatory) {
        List<PylonX> result = new ArrayList<PylonX>();
        for (PylonX pylonX : this) {
            if (mandatory == pylonX.mandatory()) result.add(pylonX);
        }
        return result;
    }
}
