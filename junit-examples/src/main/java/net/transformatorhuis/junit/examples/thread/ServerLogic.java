package net.transformatorhuis.junit.examples.thread;

/**
 *
 * @author cyberroadie
 */
public interface ServerLogic<T> {

    public void execute(T object);
    
}
