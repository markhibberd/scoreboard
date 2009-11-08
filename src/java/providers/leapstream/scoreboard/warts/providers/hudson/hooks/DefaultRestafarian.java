package leapstream.scoreboard.warts.providers.hudson.hooks;

// OK GenericIllegalRegexp|EmptyBlock {
public final class DefaultRestafarian implements Restafarian {
    public void rest() {
        try { 
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // I really, really want to ignore you.
        }
    }
}
// } OK GenericIllegalRegexp|EmptyBlock
