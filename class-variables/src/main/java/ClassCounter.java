/**
 * @auhtor Olivier Van Acker
 * Date: 13-Jun-2009
 */
public class ClassCounter {

    static int count = 0;

    public ClassCounter() {
        System.out.println("Hello world!");
        count++;
    }

    public int getCount() {
        return count;        
    }
}
