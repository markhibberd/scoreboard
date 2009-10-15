package leapstream.scoreboard.alien.net.url;

import leapstream.scoreboard.alien.io.stream.FromInputStream;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultUrlProcessor implements UrlProcessor {
    UrlGetter getter;

    public <T> T process(URL url, FromInputStream<T> action) {
        InputStream in = getter.input(url);
        try {
            return action.run(in);
        } finally {
            in.close();
        }
    }
}
