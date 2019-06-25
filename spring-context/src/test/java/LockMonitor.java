import java.util.Date;

/**
 * Created by bjzhangjifu on 2019/6/6.
 */
public class LockMonitor {
    private long startTime;
    private String name;
    private final Object monitor = new Object();

    public void refresh() {
        synchronized (this.monitor) {
            startTime = System.currentTimeMillis();
            name = "name-" + startTime;
            System.out.println("refresh " + name);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        System.out.println("------start------");
        refresh();
    }

    public void stop() {
        synchronized (this.monitor) {
            System.out.println("-------stop--------");
            System.out.println(getName());
            System.out.println("run during " + (System.currentTimeMillis() - startTime) + "ms");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
