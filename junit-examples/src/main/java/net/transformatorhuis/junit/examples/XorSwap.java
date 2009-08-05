package net.transformatorhuis.junit.examples;

/**
 *
 * @author cyberroadie
 */
public class XorSwap {

    private int x = 0;
    private int y = 0;

    public XorSwap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void swap() {
        x = x ^ y;
        y = x ^ y;
        x = y ^ x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
