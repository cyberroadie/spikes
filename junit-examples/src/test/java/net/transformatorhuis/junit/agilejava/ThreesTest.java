package net.transformatorhuis.junit.agilejava;

import net.transformtorhuis.junit.agilejava.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ThreesTest {

    @Test
    public void testGetThrees() {
        System.out.println("getThrees");
        ArrayList expResult = new ArrayList();
        expResult.addAll(Arrays.asList(3, 6, 9));
        int[] values = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList result = Threes.getThrees(values);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetThreesWithouModulus() {
        System.out.println("getThrees");
        ArrayList expResult = new ArrayList();
        expResult.addAll(Arrays.asList(3, 6, 9));
        int[] values = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList result = Threes.getThreesWithoutMod(values);
        assertEquals(expResult, result);
    }

}