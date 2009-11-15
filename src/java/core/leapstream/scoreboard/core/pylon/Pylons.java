package leapstream.scoreboard.core.pylon;

// FIX LIFECYCLE Use or lose.  
public interface Pylons {
    void has(String name);
    void get(String name);
    void put(PylonView pylon);
}
