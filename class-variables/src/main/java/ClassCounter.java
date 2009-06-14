/**
 * @auhtor Olivier Van Acker
 * Date: 13-Jun-2009
 */
public class ClassCounter {

    static int count = 0;

    private ClassCounter() {
        System.out.println("Hello world! (" + count + ")");
        count++;
    }

    public static ClassCounter createClassCounter() {
        return new ClassCounter();
    }

    public int getCount() {
        return count;        
    }
}
