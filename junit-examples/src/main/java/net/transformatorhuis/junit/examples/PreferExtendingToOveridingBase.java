package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class PreferExtendingToOveridingBase {

    private int counter;

    public void addNumbers() {
        this.counter = counter = 5;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
