package net.transformatorhuis.junitexamples;

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
}
