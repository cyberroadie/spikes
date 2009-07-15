package net.transformatorhuis.junitexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RemoveNullFromList {

    List nullList = new ArrayList();

    @Before
    public void createList() {
        nullList.add("Blah");
        nullList.add(null);
        nullList.add(null);
        nullList.add("BlahBlah");
        nullList.add(null);
    }

    @Test
    public void removeNullFromListWithCollectionSinglton() {
        assertEquals(5, nullList.size());
        nullList.removeAll(Collections.singleton(null));
        assertEquals(2, nullList.size());
    }
}
