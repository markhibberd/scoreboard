package leapstream.scoreboard.alien.gunge;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
// FIX 375 Use or lose. Wire into custom output, to make it more pretty:)

// FIX 375 belongs in boost.
public interface TimePointFormatter {
    TimePoint parse(String value);
    String emit(TimePoint time);
}
