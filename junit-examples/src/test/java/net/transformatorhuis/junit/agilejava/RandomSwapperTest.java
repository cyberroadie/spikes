package net.transformatorhuis.junit.agilejava;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RandomSwapperTest {

    List<Integer> numberList;

    public RandomSwapperTest() {
    }

    @Before
    public void createList() {
        numberList = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            numberList.add(i);
        }
    }

    @Test
    public void randomSwapper() {
    }

    public void swap(List<Integer> list) {
        int position1 = (int) (Math.random() * 100);
        int position2 = (int) (Math.random() * 100);
        int value1 = list.get(position1);
        int value2 = list.get(position2);
        list.set(position1, value2);
        list.set(position2, value1);
    }
    
}