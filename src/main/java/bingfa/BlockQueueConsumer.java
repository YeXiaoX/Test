package bingfa;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yexiaoxin on 2019/5/9.
 */
public class BlockQueueConsumer extends Thread {
    private ArrayBlockingQueue<String> queue;

    public BlockQueueConsumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = queue.take();
                System.out.println(Thread.currentThread().getId() + " remove " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
