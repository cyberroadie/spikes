package org.transformatorhuis.posix;

import com.sun.akuma.Daemon;
import com.sun.akuma.JavaVMArguments;
import com.sun.jna.StringArray;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static com.sun.akuma.CLibrary.LIBC;

/**
 * User: Olivier Van Acker
 * Date: Mar 11, 2010
 */
public class THServer extends Daemon {

    private static final Logger LOGGER = Logger.getLogger(THServer.class.getName());
    private static final int SIGTERM = 15;
    private static final String MODE_PROPERTY = THServer.class.getName() + ".mode";

    private boolean shutdown = false;

    protected final List<String> arguments;

    public static void main(String[] args) throws Exception {
        new THServer(args).run();
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread serverThread = new Thread(runnable);
        serverThread.setDaemon(daemon);
        serverThread.start();
    }

    public void run() throws IOException {
        String mode = System.getProperty(MODE_PROPERTY);
        if("dostuff".equals(mode))
            doStuff();
        else
            forkProcess();

    }


    public THServer(String[] args) throws Exception {
        this.arguments = Collections.unmodifiableList(Arrays.asList(args));
    }

    private void forkProcess() throws IOException {
        JavaVMArguments arguments = JavaVMArguments.current();
        String exe = Daemon.getCurrentExecutable();
        arguments.setSystemProperty(MODE_PROPERTY,"dostuff");
        StringArray sa = new com.sun.jna.StringArray(arguments.toArray(new String[arguments.size()]));

        int r = LIBC.fork();
        if(r < 0) {
            LIBC.perror("forking VBase process failed");
            System.exit(-1);
        }
        if(r == 0) {
            LIBC.execv(exe, sa);
            System.err.println("exec failed");
            LIBC.perror("initial exec failed");
            System.exit(-1);            
        }

    }

    private void doStuff() throws IOException {

        writePidFile();

        if (!isDaemonized())
            daemonize();

        thread(new DoStuff(), true);
        thread(new DoStuff(), true);

        Signal.handle(new Signal("TERM"),
                new SignalHandler() {
                    public void handle(Signal sig) {
                        System.out.println("I'm dying!!");
                        LIBC.kill(0, SIGTERM);
                        System.exit(-1);
                    }
                });

        // hang forever

        
        Object o = new Object();
        synchronized (o) {
            try {
                o.wait();
            } catch (InterruptedException e) {
                System.exit(0);
            }
        }
        
    }

}
