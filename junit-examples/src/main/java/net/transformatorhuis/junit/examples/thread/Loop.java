package net.transformatorhuis.junit.examples.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class Loop {

    LoopCallback callback;

    public Loop(LoopCallback count) {
        this.callback = count;
    }

    public void doLoop() {
        for (int i = 0; i <= callback.getMaxLoop(); i++) {
            try {
                callback.setProgress(i);
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
