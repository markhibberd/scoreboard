package leapstream.scoreboard.alien.ui.gunge.thread;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public class DefaultThreadUtil extends Primordial implements ThreadUtil {
    public void run(Runnable runnable) {
        doRun(runnable, false);
    }

    public void daemon(Runnable runnable) {
        doRun(runnable, true);
    }

    private void doRun(Runnable runnable, boolean daemon) {
        Thread t = new Thread(runnable);
        t.setDaemon(daemon);
        t.start();
    }
}
