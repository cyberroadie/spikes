package net.transformatorhuis.junit.examples;

/**
 * @auhtor Olivier Van Acker
 * Date: 13-Jun-2009
 */
public class ClassCounter {

    private static int count = 0;

    private ClassCounter() {
        count++;
        System.out.println("Hello world! (" + count + ")");
    }

    public static ClassCounter createClassCounter() {
        return new ClassCounter();
    }

    public int getCount() {
        return count;        
    }
}
