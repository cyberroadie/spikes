package net.transformatorhuis.junit.agilejava.proxy;

import java.lang.reflect.Proxy;

/**
 *
 * @author cyberroadie
 */
public class StringDumpFactory {

    public static StringDump createWithProxy() {
        return createSpringDumpProxy();
    }

    public static StringDump createWithoutProxy() {
        return new Strings();
    }

    private static StringDump createSpringDumpProxy() {
        StringDumpProxy stringDumpProxy = new StringDumpProxy(new Strings());
        return (StringDump) Proxy.newProxyInstance(StringDump.class.getClassLoader(),
                new Class[] {StringDump.class},
                stringDumpProxy);
    }

}
