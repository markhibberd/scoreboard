package leapstream.scoreboard.alien.resilient;

import au.net.netstorm.boost.spider.api.runtime.Impl;

public class DefaultResilientRunnables implements ResilientRunnables {
    Impl impl;

    public Runnable imbune(Runnable runnable, ErrorHandler errors, TimeoutHandler timeouts, int timeout) {
        Runnable safe = impl.impl(SafeRunnable.class, runnable, errors);
        return impl.impl(TimeBoxedRunnable.class, safe, timeouts, timeout);
    }
}
