package net.transformatorhuis.junit.agilejava.ring;

/**
 *
 * @author cyberroadie
 */
public class EmptyRingNodeException extends Exception {

    private static final long serialVersionUID = 7402524160453164480L;

    /**
     * Creates a new instance of <code>EmptyRingNodeException</code> without detail message.
     */
    public EmptyRingNodeException() {
    }

    /**
     * Constructs an instance of <code>EmptyRingNodeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyRingNodeException(String msg) {
        super(msg);
    }
}
