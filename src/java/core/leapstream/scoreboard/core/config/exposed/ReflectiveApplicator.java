package leapstream.scoreboard.core.config.exposed;

import au.net.netstorm.boost.gunge.sledge.java.lang.reflect.EdgeMethod;

import java.lang.reflect.Method;

public class ReflectiveApplicator implements Applicator {
    private Object target;
    private Method method;
    EdgeMethod methods;

    public ReflectiveApplicator(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public void apply(String s) {
        methods.invoke(method, target, s);
    }
}
