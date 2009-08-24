package net.transformatorhuis.junit.examples.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class Server extends Thread {

    private BlockingQueue<ServerLogic> queue = new LinkedBlockingQueue<ServerLogic>();
    private ServerLogic logic;

    public Server(ServerLogic... logic) {
        for (ServerLogic serverLogic : logic) {
            queue.add(serverLogic);
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                // This will wait until there is something in the queue
                execute(queue.take());
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    private void execute(ServerLogic logic) {
        logic.execute("Test");
    }

    public void add(ServerLogic logic) throws InterruptedException {
        queue.put(logic);
    }

    public void shutdown() {
        this.interrupt();
    }
}
