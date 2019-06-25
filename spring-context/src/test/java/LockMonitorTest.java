/**
 * Created by bjzhangjifu on 2019/6/6.
 */
public class LockMonitorTest {

    public static void main(String[] args) {
        LockMonitor lockMonitor = new LockMonitor();
        lockMonitor.start();
        lockMonitor.start();
        lockMonitor.stop();
    }
}
