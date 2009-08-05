package net.transformtorhuis.junit.agilejava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Swapper {

    List<Integer> list;

    public Swapper() {
        list = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }
    }

    public List swap() {
        int position1 = (int) (Math.random() * 100);
        int position2 = (int) (Math.random() * 100);
        int value1 = list.get(position1);
        int value2 = list.get(position2);
        list.set(position1, value2);
        list.set(position2, value1);
        return list;
    }

    public List getNumberList() {
        return list;
    }
}
