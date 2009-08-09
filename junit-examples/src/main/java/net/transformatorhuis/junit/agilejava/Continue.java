package net.transformatorhuis.junit.agilejava;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author cyberroadie
 */
public class Continue {

    public static String getDivisibleByFiveString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if((i % 5) != 0) {
                sb.append(' ');
                continue;
            }
            sb.append("* ");
        }
        return sb.toString().trim();
    }

    public static Vector split(int n) {
        String factorial = getDivisibleByFiveString(n);
        String[] split = factorial.split(" ");
        Vector vector = new Vector();
        for (String string : split) {
            vector.add(string);
        }
        return vector;
    }
}
