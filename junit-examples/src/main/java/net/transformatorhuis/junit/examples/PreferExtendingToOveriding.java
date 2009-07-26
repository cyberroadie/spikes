package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class PreferExtendingToOveriding extends PreferExtendingToOveridingBase {

    @Override
    public void addNumbers() {
        super.addNumbers();
        setCounter(getCounter() + 5);
    }

}
