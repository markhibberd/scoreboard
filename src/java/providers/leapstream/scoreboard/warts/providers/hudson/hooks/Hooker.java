package leapstream.scoreboard.warts.providers.hudson.hooks;

import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import hudson.model.Action;
import hudson.model.Hudson;

import javax.servlet.ServletContext;
import java.util.List;

public final class Hooker implements Runnable {
    Class[] types = {ScoreAction.class};
    Restafarian restafarian;
    ServletContext context;
    Impl impl;
    Wire wire;

    public void run() {
        while (!loaded()) restafarian.rest();
        configure();
    }

    private boolean loaded() {
        return app() instanceof Hudson;
    }

    public void configure() {
        Hudson hudson = hudson();
        for (Class t : types) add(hudson, t);
    }

    private void add(Hudson hudson, Class<? extends Action> t) {
        Action action = impl.impl(t);
        List<Action> actions = hudson.getActions();
        actions.add(action);
    }

    private Hudson hudson() {
        Hudson hudson = (Hudson) app();
        wire.ref(hudson).to(Hudson.class);
        return hudson;
    }

    private Object app() {
        return context.getAttribute("app");
    }
}
