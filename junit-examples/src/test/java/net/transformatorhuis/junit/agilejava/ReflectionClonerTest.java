package net.transformatorhuis.junit.agilejava;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.transformatorhuis.junit.agilejava.ReflectionCloner.CloneViaReflectionExcpetion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ReflectionClonerTest {

    int testInt =123;
    String testString = "test";

    public ReflectionClonerTest() {
    }

    /**
     * Test of cloneViaReflection method, of class ReflectionClone.
     */
    @Test
    public void testCloneViaReflectionSameObjectReference() {
        ReflectionCloner cloner = new ReflectionCloner("blah");
        Object object = null;
        try {
            object = cloner.cloneViaReflection(this);
        } catch (CloneViaReflectionExcpetion ex) {
            Logger.getLogger(ReflectionClonerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Check if doesn't return the same object reference
        assertFalse(object == this);
    }

    /**
     * Test of cloneViaReflection method, of class ReflectionClone.
     */
    @Test
    public void testCloneViaReflectionNoEmptyConstructor() {
        ReflectionCloner cloner = new ReflectionCloner("blah");
        try {
            Object object = cloner.cloneViaReflection(cloner);
            fail("ReflectionColner doesn't have a no argument exception");
        } catch (CloneViaReflectionExcpetion ex) {
            // success
        }
    }

    /**
     * Test of cloneViaReflection method, of class ReflectionClone.
     */
    @Test
    public void testCloneViaReflection() {
        ReflectionCloner cloner = new ReflectionCloner("blah");
        try {
            ReflectionClonerTest testObject = (ReflectionClonerTest) cloner.cloneViaReflection(this);
            // Check if doesn't return the same object reference
            assertFalse(testObject == this);
            assertEquals(this.testInt, testObject.testInt);
            assertEquals(this.testString, testObject.testString);
        } catch (CloneViaReflectionExcpetion ex) {
            fail(ex.toString());
        }
    }
    
}