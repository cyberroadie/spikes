package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class XorSwapTest {


    @Test
    public void swapXor1() {
        XorSwap xorSwap = new XorSwap(5, 7);
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        assertTrue(xorSwap.getX() ==  5);
        assertTrue(xorSwap.getY() ==  7);
        xorSwap.swap();
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        assertTrue(xorSwap.getX() ==  7);
        assertTrue(xorSwap.getY() ==  5);
    }

    @Test
    public void swapXor2() {
        XorSwap xorSwap = new XorSwap(5424, 47);
        assertTrue(xorSwap.getX() ==  5424);
        assertTrue(xorSwap.getY() ==  47);
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        xorSwap.swap();
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        assertTrue(xorSwap.getX() ==  47);
        assertTrue(xorSwap.getY() ==  5424);
    }

    @Test
    public void swapXor3() {
        XorSwap xorSwap = new XorSwap(42, 41);
        assertTrue(xorSwap.getX() ==  42);
        assertTrue(xorSwap.getY() ==  41);
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        xorSwap.swap();
        System.out.println("X: " + xorSwap.getX());
        System.out.println("Y: " + xorSwap.getY());
        assertTrue(xorSwap.getX() ==  41);
        assertTrue(xorSwap.getY() ==  42);
    }

}