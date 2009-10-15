package leapstream.scoreboard.warts.providers.hudson.hooks;

public final class DefaultRestafarian implements Restafarian {
    public void rest() {
        try { Thread.sleep(1000L); }
        catch (InterruptedException e) {}
    }
}
