package net.transformatorhuis.chess;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class StringUtilTest {

    public StringUtilTest() {
    }

    @Test
    public void testNewLine() {
        assertTrue(Character.isWhitespace(StringUtil.NEWLINE.charAt(0)));
    }

}