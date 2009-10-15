package leapstream.scoreboard.dead.spinner;

public final class SpinnerRunnable implements Runnable {
    private final Spinner spinner;

    public SpinnerRunnable(Spinner spinner) {
        this.spinner = spinner;
    }

    public void run() {
        spinner.begin();
    }
}
