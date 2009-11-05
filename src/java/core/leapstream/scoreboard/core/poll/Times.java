package leapstream.scoreboard.core.poll;

public final class Times {
    public static final int TIMEOUT = seconds(20);
    public static final int IMAGE = seconds(20);
    public static final int SCORE_TIMEOUT = seconds(30);
    public static final int SCORE_POLL = seconds(5);
    public static final int STATUS_TIMEOUT = seconds(30);
    public static final int STATUS_POLL = seconds(15);
    private static final int SLOW_DOWN = 20;

    private static int seconds(int s) {
        return s * 1000 * SLOW_DOWN;
    }
}
