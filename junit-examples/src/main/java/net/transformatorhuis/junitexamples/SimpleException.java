package net.transformatorhuis.junitexamples;

/**
 *
 * @author cyberroadie
 */
public class SimpleException extends RuntimeException {

    /**
     * Creates a new instance of <code>SimpleException</code> without detail message.
     */
    public SimpleException() {
    }


    /**
     * Constructs an instance of <code>SimpleException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SimpleException(String msg) {
        super(msg);
    }
}
