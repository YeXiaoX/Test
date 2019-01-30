package barrier.test.com;

import java.util.concurrent.*;

/**
 * Created by yexiaoxin on 2017/7/10.
 */
public class TestCountDownLatch {
    private static int count = 5;

    private static class WorkThread implements Runnable {
        private CountDownLatch countDownLatch;

        public WorkThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            System.out.println(Thread.currentThread().getId() + "countDown");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getId() + "wait over");

        }
    }

    public static void main(String args[]) {
        Executor threadPool = new ScheduledThreadPoolExecutor(count);
        Test t = new Test();
        CountDownLatch c = new CountDownLatch(count);
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new WorkThread(c));
        }
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test");

    }
}
