package net.transformatorhuis.junit.agilejava;

import java.util.ArrayList;

/**
 *
 * @author cyberroadie
 */
public class Threes {

    public static ArrayList getThrees(int... numbers) {
        ArrayList threes = new ArrayList();
        for (int num : numbers) {
            if(num%3 == 0) {
                threes.add(num);
            }
        }
        return threes;
    }

    public static ArrayList getThreesWithoutMod(int... numbers) {
        ArrayList threes = new ArrayList();
        for (int num : numbers) {
            int quotient = num / 3;
            float numFloat = num;
            float remainder = numFloat - 3 * (float) quotient;
            if(remainder == 0) {
                threes.add(num);
            }
        }
        return threes;
    }
}
