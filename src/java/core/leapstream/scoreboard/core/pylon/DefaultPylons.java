package leapstream.scoreboard.core.pylon;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultPylons implements Pylons {
    private List<Pylon> pylons = new CopyOnWriteArrayList<Pylon>();

    public void add(Pylon pylon) {
        pylons.add(pylon);
    }

    public List<Pylon> mandatory() {
        return accumulate(true);
    }

    public List<Pylon> optional() {
        return accumulate(false);
    }

    public Iterator<Pylon> iterator() {
        return pylons.iterator();
    }

    private List<Pylon> accumulate(boolean mandatory) {
        List<Pylon> result = new ArrayList<Pylon>();
        for (Pylon pylon : this) {
            if (mandatory == pylon.mandatory()) result.add(pylon);
        }
        return result;
    }
}
