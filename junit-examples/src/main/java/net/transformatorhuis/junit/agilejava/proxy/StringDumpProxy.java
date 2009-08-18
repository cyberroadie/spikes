package net.transformatorhuis.junit.agilejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import net.transformatorhuis.junit.util.ObjectDumper;

/**
 *
 * @author cyberroadie
 */
public class StringDumpProxy implements InvocationHandler {

    private Object target;
    
    public StringDumpProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("toString")) {
            return ObjectDumper.dumpObject(target);
        }
        return method.invoke(target, args);
    }
    
}
