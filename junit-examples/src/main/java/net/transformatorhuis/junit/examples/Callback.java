package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class Callback {

    CallbackCounter cc;

    public Callback(CallbackCounter cc) {
        this.cc = cc;
    }

    public void count() {
        cc.executed();
    }

}
