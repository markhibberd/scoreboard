package leapstream.scoreboard.dead.spinner;

public final class DefaultSpinner implements Spinner {
    private final Pokeable pokeable;
    private final Long interval;
    private boolean end;
    private boolean stopped;

    public DefaultSpinner(Long interval, Pokeable pokeable) {
        this.interval = interval;
        this.pokeable = pokeable;
    }

    public synchronized void begin() {
        loop();
    }

    public synchronized void end() {
        end = true;
    }

    public synchronized void start() {
        stopped = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
        notify();
    }

    private void loop() {
        while (!end) cycle();
    }

    private void cycle() {
        stopped();
        waitus(interval);
        pokeable.poke();
    }

    private void stopped() {
        while (stopped) waitus();
    }

    // FIX 377 Add to primordial.
    private void waitus() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // FIX 377 Add to primordial.
    private void waitus(long interval) {
        try {
            wait(interval);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
