package org.transformatorhuis.posix;

import java.util.Observable;
import java.util.Observer;

/**
 * User: Olivier Van Acker
 * Date: Mar 11, 2010
 */
public class DoStuff implements Runnable, Observer {

    private boolean shutdown = false;
    
    public DoStuff() {

    }

    private void sendErrorMessage() {
        System.err.println("Error message from server");
    }

    private void sendMessage() {
        System.out.println("Message from server");
    }

    public void run() {
        while(!shutdown) {
            sendErrorMessage();
            sendMessage();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.toString());
                System.exit(0);
            }
        }
        System.out.println("End of program");
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
}
