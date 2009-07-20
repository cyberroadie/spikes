package net.transformatorhuis.junitexamples;

/**
 *
 * @author cyberroadie
 */
public class Factorial {

    public static double factorialWhile(double n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        double i = 1;
        double total = 1;
        while(i <= n) {
            total = total * i;
            i++;
        }
        return total;
    }

    public static double factorialFor(double n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        double total = 1;
        for(double i = 1; i <=n; i++) {
            total = total * i;
        }
        return total;
    }

    public static double factorialDo(double n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        double i = 0d;
        double total = 1d;
        do {
            i++;
            total = total * i;
        } while (i < n);
        return total;
    }

}
