package leapstream.scoreboard.alien.ui.audio.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.gunge.thread.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultAudioWirer implements AudioWirer {
    ThreadUtil threads;
    Nu nu;
    
    public Audio nu() {
        Egg egg = nu.nu(Egg.class, BoostWeb.class, AudioWeb.class);
        Spider spider = egg.hatch();
        BlockingQueue<Playable> q = new LinkedBlockingQueue<Playable>();
        Audio audio = spider.nu(Audio.class, q);
        Runnable speaker = spider.impl(Speaker.class, q);
        threads.daemon(speaker);        
        return audio;
    }
}
