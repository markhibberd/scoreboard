package leapstream.scoreboard.test.framework.suite;

import au.net.netstorm.boost.sniper.suite.core.BoostSuite;
import au.net.netstorm.boost.sniper.suite.core.FileBasedTestSuites;
import au.net.netstorm.boost.sniper.suite.core.TestSuites;
import junit.framework.Test;

public final class AtomicTestSuite implements BoostSuite {
    private static final TestSuites ATOMIC = new FileBasedTestSuites("Atomic", AtomicTestSuite.class);

    public static Test suite() {
        return ATOMIC.suite();
    }

    public TestSuites suites() {
        return ATOMIC;
    }
}