package leapstream.scoreboard.alien.io.file;

import leapstream.scoreboard.edge.java.io.File;

public final class DefaultFiles implements Files {
    public void recursiveDelete(File file) {
        if (file.isDirectory()) deleteDir(file);
        else file.delete();
    }

    private void deleteDir(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) recursiveDelete(f);
    }
}
