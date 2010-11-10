package leapstream.scoreboard.alien.io.stream;

import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;
import au.net.netstorm.boost.gunge.io.StreamConverter;
import au.net.netstorm.boost.gunge.sledge.java.io.DefaultEdgeInputStream;
import leapstream.scoreboard.edge.java.io.InputStream;
// FIX 377 This highlights a problem with edges, it is difficult to use gunge, because of

// FIX 377 different edges. See StreamConverter.
public final class DefaultBytesFromInputStream implements BytesFromInputStream {
    StreamConverter converter;

    public byte[] run(InputStream in) {
        Unedgable un = (Unedgable) in;
        java.io.InputStream real = (java.io.InputStream) un.unedge();
        DefaultEdgeInputStream edge = new DefaultEdgeInputStream(real);
        return converter.read(edge);
    }
}
