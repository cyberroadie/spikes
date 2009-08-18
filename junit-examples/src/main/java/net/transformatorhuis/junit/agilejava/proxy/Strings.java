package net.transformatorhuis.junit.agilejava.proxy;

/**
 *
 * @author cyberroadie
 */
public class Strings implements StringDump {

    String test1;
    String test2;
    String test3;

    @Override
    public String toString() {
        return "Real thing";
    }


}
