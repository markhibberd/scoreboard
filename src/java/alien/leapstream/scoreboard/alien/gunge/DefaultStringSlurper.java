package leapstream.scoreboard.alien.gunge;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.edge.java.io.BufferedReader;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.io.InputStreamReader;

// FIX 3083 Feb 25, 2009 Split into two classes.
public final class DefaultStringSlurper implements StringSlurper {
    Nu nu;

    public String slurp(InputStream in) {
        try {
            return safely(in);
        } finally {
            in.close();
        }
    }

    private String safely(InputStream stream) {
        BufferedReader in = reader(stream);
        StringBuilder builder = new StringBuilder();
        readLines(in, builder);
        return builder.toString();
    }

    private void readLines(BufferedReader in, StringBuilder builder) {
        String line;
        while ((line = in.readLine()) != null) append(builder, line);
    }

    private BufferedReader reader(InputStream stream) {
        InputStreamReader reader = nu.nu(InputStreamReader.class, stream);
        return nu.nu(BufferedReader.class, reader);
    }

    private void append(StringBuilder builder, String line) {
        builder.append(line);
        // FIX 707 This is pretty dodge, makes it the same behaviour on windows.
        builder.append("\n");
//        builder.append(LINE);
    }
}
