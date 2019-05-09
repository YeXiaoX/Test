package bingfa;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yexiaoxin on 2019/5/9.
 * 基于阻塞队列实现生产者和消费者模型
 */
public class TestBlockQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        BlockQueueConsumer bc = new BlockQueueConsumer(queue);
        BlockQueueProducer bp = new BlockQueueProducer(queue);
        BlockQueueConsumer bc1 = new BlockQueueConsumer(queue);
        BlockQueueProducer bp1 = new BlockQueueProducer(queue);
        bc.start();
        bp.start();
        bc1.start();
        bp1.start();
    }
}
