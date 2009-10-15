package leapstream.scoreboard.alien.gunge;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.lang.Class;
import leapstream.scoreboard.edge.java.lang.ClassLoader;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultResources implements Resources {
    Edges edges;

    public URL url(String name) {
        ClassLoader loader = cl();
        URL resource = loader.getResource(name);
        nulls(resource);
        return resource;
    }

    public InputStream stream(String name) {
        ClassLoader loader = cl();
        InputStream in = loader.getResourceAsStream(name);
        nulls(in);
        return in;
    }

    private void nulls(Object o) {
        if (o == null) throw new IllegalArgumentException("Resource not found on the class path.");
    }

    private ClassLoader cl() {
        java.lang.Class cls = getClass();
        Class edge = edges.ref(Class.class, cls);
        return edge.getClassLoader();
    }
}
