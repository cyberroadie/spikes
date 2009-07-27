package net.transformtorhuis.junit.agilejava;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class WordCountTest {

    public WordCountTest() {
    }

    /**
     * Test of wordCount method, of class WordCount.
     */
    @Test
    public void testWordCount() {
        WordCount wordCount = new WordCount();
        Map words = wordCount.getWordCount();
        assertEquals(1, words.get("string"));
        assertEquals(3, words.get("the"));
    }

}