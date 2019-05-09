package bingfa;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yexiaoxin on 2019/5/8.
 */
public class Consumer extends Thread {
    private List<String> data;
    private ReentrantLock lock;
    private Condition a;
    private Condition b;

    public Consumer(List<String> data, ReentrantLock lock, Condition a, Condition b) {
        this.data = data;
        this.lock = lock;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (data.size() <= 0) {
                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止多个线程消费时被唤醒后获取锁时最后一个资源已被其他线程消费，出现数组越界的情况
            if (data.size() > 0) {
                String s = data.get(data.size() - 1);
                data.remove(data.size() - 1);
                System.out.println(Thread.currentThread().getId() + " remove " + s);
                a.signal();
            }
            lock.unlock();
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
