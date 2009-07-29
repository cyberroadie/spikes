package net.transformtorhuis.junit.agilejava;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class NameTest {

    Name equalsA = null;
    Name equalsB = null;
    Name equalsC = null;
    Set<Name> nameSet = new HashSet<Name>();

    public NameTest() {
    }

    /**
     * Test of equals method, of class Name.
     */
    @Test
    public void testEquals() {
        Name name = new Name("test");
        assertEquals("test", name.getName());
    }

    @Before
    public void setup() {
        equalsA = new Name("abc");
        equalsB = new Name("abc");
        equalsC = new Name("abc");
    }

    /**
     * Test reflexivity, of class Equals.
     */
    @Test
    public void testReflexivity() {
        assertTrue(equalsA.equals(equalsA));
    }

    @Test
    public void testSymmetry() {
        assertTrue(equalsA.equals(equalsB));
        assertTrue(equalsB.equals(equalsA));
    }

    @Test
    public void testTransitivity() {
        assertTrue(equalsA.equals(equalsB));
        assertTrue(equalsB.equals(equalsC));
        assertTrue(equalsA.equals(equalsC));
    }

    @Test
    public void testConsistency() {
        for (int i = 0; i < 100000; i++) {
            assertTrue(equalsA.equals(equalsB));
        }
    }

    @Test
    public void testComparisonToNull() {
        assertFalse(equalsA.equals(null));
    }

    @Test
    public void testSet() {
        nameSet.add(new Name("blah"));
        nameSet.add(new Name("blahblah"));
        nameSet.add(new Name("blahblahblah"));
        Name foo = new Name("foo");
        assertFalse(nameSet.contains(foo));
        nameSet.add(foo);
        assertTrue(nameSet.contains(foo));
    }

}