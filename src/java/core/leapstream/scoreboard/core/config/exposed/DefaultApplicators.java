package leapstream.scoreboard.core.config.exposed;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.gunge.reflect.method.MethodMaster;

import java.lang.reflect.Method;

public class DefaultApplicators implements Applicators {
    MethodMaster methods;
    Impl impl;
    
    public Applicator bind(Object target, String methodname) {
        Class<?> cls = target.getClass();
        if (!methods.has(cls, methodname, String.class)) barf(cls, methodname);
        Method method = methods.get(cls, methodname, String.class);
        method.setAccessible(true);
        return impl.impl(ReflectiveApplicator.class, target, method);
    }

    private void barf(Class<?> cls, String methodname) {
        String msg = "Could not find method for bind [" + cls.getName() + "#" + methodname + "]";
        throw new IllegalArgumentException(msg);
    }
}
