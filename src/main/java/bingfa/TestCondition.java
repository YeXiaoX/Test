package bingfa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yexiaoxin on 2019/5/8.
 * 用condition实现最多只能生产五个资源的生产者和消费者模型
 *
 */
public class TestCondition {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        List<String> data = new ArrayList<String>();
        Producer p = new Producer(data, lock, condition1, condition2);
        Producer p1 = new Producer(data, lock, condition1, condition2);
        Consumer s = new Consumer(data, lock, condition1, condition2);
        Consumer s1 = new Consumer(data, lock, condition1, condition2);
        s.start();
        p1.start();
        s1.start();
        p.start();
    }
}
