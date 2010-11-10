package leapstream.scoreboard.alien.resilient;

public class SafeRunnable implements Runnable {
    private Runnable delegate;
    private ErrorHandler handler;

    public SafeRunnable(Runnable delegate, ErrorHandler handler) {
        this.delegate = delegate;
        this.handler = handler;
    }

    public void run() {
        try {
            delegate.run();
        } catch (Throwable t) {
            handler.handle(t);
        }
    }
}
