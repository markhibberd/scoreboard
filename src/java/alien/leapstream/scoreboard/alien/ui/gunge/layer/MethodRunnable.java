package leapstream.scoreboard.alien.ui.gunge.layer;

import au.net.netstorm.boost.gunge.layer.Method;

public class MethodRunnable implements Runnable {
    private Object target;
    private Method method;
    private Object[] objects;

    public MethodRunnable(Object target, Method method, Object[] objects) {
        this.target = target;
        this.method = method;
        this.objects = objects;
    }

    public void run() {
        method.invoke(target, objects);
    }
}
