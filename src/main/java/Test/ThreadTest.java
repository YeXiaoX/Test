package Test;

/**
 * Created by yexiaoxin on 2019/5/8.
 * 利用锁和notify机制实现三个线程交替打印1,2,3
 */
public class ThreadTest extends Thread {
    private Integer a;
    private Test t;
    private Object o;

    public ThreadTest(Integer a, Test t, Object o) {
        this.a = a;
        this.t = t;
        this.o = o;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (o) {
                    while(t.getA() != a) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(a);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (t.getA() == 3) {
                        t.setA(1);
                    } else {
                        t.setA(t.getA() + 1);
                    }
                    o.notifyAll();
                }
            }
        }
    }

