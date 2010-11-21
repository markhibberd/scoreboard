package leapstream.scoreboard.legacy.edge.javax.sound.sampled;

public interface SourceDataLine extends DataLine {
    void open(AudioFormat format);

    void start();

    void write(byte[] bytes, int offset, int length);

    void drain();

    void close();
}
