package org.transformatorhuis.posix;

import com.sun.akuma.Daemon;
import com.sun.akuma.JavaVMArguments;
import com.sun.jna.StringArray;
import org.productivity.java.syslog4j.*;
import org.productivity.java.syslog4j.impl.message.processor.SyslogMessageProcessor;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import static com.sun.akuma.CLibrary.LIBC;

/**
 * User: Olivier Van Acker
 * Date: Mar 11, 2010
 */
public class THServer extends Daemon implements Observer {

    private static final Logger LOGGER = Logger.getLogger(THServer.class.getName());
    private static final int SIGTERM = 15;
    private static final String MODE_PROPERTY = THServer.class.getName() + ".mode";
    private static final int MAX_THREADS = 10;
    
    private static SyslogIF syslog = Syslog.getInstance("unix_syslog");

    protected final List<String> arguments;

    public static void main(String[] args) throws Exception {
        JavaVMArguments arguments = JavaVMArguments.current();
        arguments.setSystemProperty(MODE_PROPERTY, "first start");
        new THServer(args).run();
    }

    public static void thread(Runnable runnable, boolean daemon) {

        Thread serverThread = new Thread(runnable);
        serverThread.setDaemon(daemon);
        serverThread.start();
    }

    public void run() throws IOException {
        String mode = System.getProperty(MODE_PROPERTY);
        if ("dostuff".equals(mode)) {
            syslog.alert("Starting the threads");
            doStuff();
        } else {
            syslog.alert("Fork process");
            forkProcess();
        }

    }

    public THServer(String[] args) throws Exception {
        this.arguments = Collections.unmodifiableList(Arrays.asList(args));
    }

    private void forkProcess() throws IOException {
        JavaVMArguments arguments = JavaVMArguments.current();
        String exe = Daemon.getCurrentExecutable();
        arguments.setSystemProperty(MODE_PROPERTY, "dostuff");
        StringArray sa = new com.sun.jna.StringArray(arguments.toArray(new String[arguments.size()]));

        int r = LIBC.fork();
        if (r < 0) {
            LIBC.perror("forking VBase process failed");
            syslog.error("forking VBase process failed");
            System.exit(-1);
        }
        if (r == 0) {
            LIBC.execv(exe, sa);
            LIBC.perror("initial exec failed");
            syslog.error("initial exec failed");
            System.exit(-1);
        }

    }

    private void doStuff() throws IOException {

        writePidFile();

        THSignalHandler thSignalHandler = new THSignalHandler();
        thSignalHandler.addObserver(this);
        Signal.handle(new Signal("TERM"), thSignalHandler);

        for (int i = 0; i < MAX_THREADS; i++) {
            DoStuff ds = new DoStuff("Thread " + i);
            thSignalHandler.addObserver(ds);
            thread(ds, true);
        }

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

    @Override
    public void update(Observable o, Object arg) {
        syslog.warn("Exit process");
        System.exit(0);
    }

    private class THSignalHandler extends Observable implements SignalHandler {

        @Override
        public void handle(Signal signal) {
            switch (signal.getNumber()) {
                case (SIGTERM):
                    setChanged();
                    notifyObservers();
                    break;
            }
        }
    }

}
