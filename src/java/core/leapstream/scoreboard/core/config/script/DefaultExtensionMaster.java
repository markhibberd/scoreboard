package leapstream.scoreboard.core.config.script;

public class DefaultExtensionMaster implements ExtensionMaster {
    public String extension(String... sx) {
        if (sx.length < 1)
            throw new IllegalArgumentException("Expected at least one extension.");
        String ext = extenstion(sx[0]);
        check(ext, sx);
        return ext;
    }

    public void check(String ext, String... sx) {
        for (String s : sx)
            if (!s.endsWith("." + ext))
                throw new IllegalStateException("Value [" + s + "] does not have extension [" + ext + "].");
    }

    private String extenstion(String s) {
        int i = s.lastIndexOf('.');
        return s.substring(i + 1);
    }
}
