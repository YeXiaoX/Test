package bingfa;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yexiaoxin on 2019/5/8.
 */
public class Producer extends Thread {
    private List<String> data;
    private ReentrantLock lock;
    private Condition a;
    private Condition b;

    public Producer(List<String> data, ReentrantLock lock, Condition a, Condition b) {
        this.data = data;
        this.lock = lock;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (data.size() >= 5) {
                try {
                    a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止多线程生产被唤醒时其他线程已经生成第五个资源
            if (data.size() < 5) {
                String s = Thread.currentThread().getId() + " produce aa:" + System.currentTimeMillis();
                data.add(s);
                System.out.println(s);
                b.signal();
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
