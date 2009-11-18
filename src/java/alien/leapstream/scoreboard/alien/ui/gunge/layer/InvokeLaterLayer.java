package leapstream.scoreboard.alien.ui.gunge.layer;

import au.net.netstorm.boost.gunge.layer.Layer;
import au.net.netstorm.boost.gunge.layer.Method;
import au.net.netstorm.boost.spider.api.runtime.Impl;

import javax.swing.SwingUtilities;

// FIX LIFECYCLE Use or lose. Wire into everything that should be on edt. 
public class InvokeLaterLayer implements Layer {
    private Object target;
    Impl impl;

    public InvokeLaterLayer(Object target) {
        this.target = target;
    }

    public Object invoke(Method method, Object[] objects) {
        MethodRunnable runnable = impl.impl(MethodRunnable.class, target, method, objects);
        SwingUtilities.invokeLater(runnable);
        return null;
    }
}
