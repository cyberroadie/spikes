import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * @auther Olivier Van Acker (cyberroadie@gmail.com)
 * Date: 13-Jun-2009
 */
public class ClassCounterTest {

    @Test
    public void count() {
        ClassCounter classCounter1 = new ClassCounter();
        System.out.println(classCounter1.getCount());

        ClassCounter classCounter2 = new ClassCounter();

        // Counter is the same for both
        assertEquals(classCounter2.getCount(), classCounter1.getCount());
        
    }
}
