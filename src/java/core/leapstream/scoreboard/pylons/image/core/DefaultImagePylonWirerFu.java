package leapstream.scoreboard.pylons.image.core;

import au.net.netstorm.boost.bullet.farmer.Farmer;
import au.net.netstorm.boost.bullet.farmer.FarmerWirer;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;
import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;
import static leapstream.scoreboard.core.poll.Times.IMAGE;
import leapstream.scoreboard.pylons.image.pull.DefaultImagePuller;
import leapstream.scoreboard.pylons.image.pull.ImagePuller;
import leapstream.scoreboard.pylons.image.pull.RotatingImagePuller;
import leapstream.scoreboard.pylons.image.push.ImagePusher;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;
import leapstream.scoreboard.pylons.image.ui.core.ImageTileWidgets;

// FIX 379 Sort out dupe with DefaultScorePylonWirer.
public final class DefaultImagePylonWirerFu implements ImagePylonWirerFu {
    ImageTileWidgets widgets;
    FarmerWirer farmers;
    Sticker sticker;

    public Ui nu(ImageLocation location) {
        Farmer farmer = farmers.nu(IMAGE);
        Spider spider = spider();
        sticker.instance(spider, ImageLocation.class, location);
        return pylon(spider, farmer, DefaultImagePuller.class);
    }

    public Ui nu(long interval, ImagePack pack) {
        Farmer farmer = farmers.nu(interval, IMAGE);
        Spider spider = spider();
        sticker.instance(spider, ImagePack.class, pack);
        return pylon(spider, farmer, RotatingImagePuller.class);
    }

    private Ui pylon(Spider spider, Farmer farmer, Class<? extends ImagePuller> type) {
        Widget<ImageTile> widget = widgets(spider);
        farm(spider, farmer, type);
        return widget;
    }

    private Widget<ImageTile> widgets(Spider spider) {
        Widget<ImageTile> widget = widgets.nu();
        ImageTile tile = widget.control();
        sticker.instance(spider, ImageTile.class, tile);
        return widget;
    }

    private void farm(Spider spider, Farmer farmer, Class<? extends ImagePuller> type) {
        Impl impl = spider.resolve(Impl.class);
        ImagePuller puller = impl.impl(type);
        ImagePusher pusher = spider.resolve(ImagePusher.class);
        StartStop ss = farmer.farm(pusher, puller);
        ss.start();
    }

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, ImageWeb.class);
        return egg.hatch();
    }
}
