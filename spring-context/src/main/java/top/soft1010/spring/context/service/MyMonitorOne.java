package top.soft1010.spring.context.service;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 * Created by bjzhangjifu on 2019/6/6.
 */
@Service("MyMonitorOne")
public class MyMonitorOne implements MyMonitor, SmartLifecycle {
    private volatile boolean running = false;

    public boolean isAutoStartup() {
        return true;
    }

    public void stop(Runnable callback) {
        System.out.println("=====runnable stop=====");
    }

    public void start() {
        running = true;
        System.out.println("=====start======");
    }

    public void stop() {
        running = false;
        System.out.println("=====stop======");
    }

    public boolean isRunning() {
        return running;
    }

    public void monitor() {
        System.out.println("=====monitor=====");
    }

    public int getPhase() {
        return 1;
    }
}
