package net.transformatorhuis.junitexamples;

/**
 *
 * @author cyberroadie
 */
public class Boom {

    public static void blowsUp() {
        throw new SimpleException("Booooom!");
    }

    public static void rethrows() {
        try {
            Boom.blowsUp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
