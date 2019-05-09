package bingfa;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yexiaoxin on 2019/5/9.
 */
public class BlockQueueProducer extends Thread {
    private ArrayBlockingQueue<String> queue;

    public BlockQueueProducer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String data = " aa:" + System.currentTimeMillis();
            queue.add(data);
            System.out.println(Thread.currentThread().getId() + " produce " + data);
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
