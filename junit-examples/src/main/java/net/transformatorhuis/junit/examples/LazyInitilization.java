package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class LazyInitilization {

    private Integer lazyVariable = null;

    public LazyInitilization() {

    }

    public Integer getLazyVariable() {
        if(lazyVariable == null)
            lazyVariable = 1;
        return lazyVariable;
    }

}
