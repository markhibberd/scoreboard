package leapstream.scoreboard.test.framework.suite;

import au.net.netstorm.boost.sniper.suite.core.BoostSuite;
import au.net.netstorm.boost.sniper.suite.core.CompositeTestSuites;
import au.net.netstorm.boost.sniper.suite.core.TestSuites;
import junit.framework.Test;

public final class AllTestSuite implements BoostSuite {
    private static final TestSuites COMPOSITE = new CompositeTestSuites(
            "Testing The Board",
            AtomicTestSuite.class,
            MolecularTestSuite.class
    );

    public static Test suite() {
        return COMPOSITE.suite();
    }

    public TestSuites suites() {
        return COMPOSITE;
    }
}
