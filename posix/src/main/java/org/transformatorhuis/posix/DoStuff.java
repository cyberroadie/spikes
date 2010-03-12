package org.transformatorhuis.posix;

import java.util.Observable;
import java.util.Observer;

/**
 * User: Olivier Van Acker
 * Date: Mar 11, 2010
 */
public class DoStuff implements Runnable, Observer {

    private boolean shutdown = false;
    private String identifier;
    
    public DoStuff(String identifier) {
        this.identifier = identifier;
    }

    private void sendMessage() {
        System.out.println(identifier + "::Message from server");
    }

    public void run() {
        while(!shutdown) {
            sendMessage();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.toString());
                System.exit(0);
            }
        }
        System.out.println(identifier+"::End of thread");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(identifier + "::TERM received");
        shutdown = true;
    }
}
