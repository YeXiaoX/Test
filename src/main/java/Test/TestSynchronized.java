package Test;

/**
 * Created by yexiaoxin on 2017/8/1.
 */
public class TestSynchronized {
    static Object a = new Object();
    static Object b = new Object();

    public static void test(Object a, Object b) throws Exception {
        synchronized (a) {
            System.out.println(Thread.currentThread().getId() + ":1");
            synchronized (b) {
                a.wait();
                System.out.println(Thread.currentThread().getId() + ":2");
            }
        }
    }

    public static void main(String args[]) throws Exception {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    test(a, b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    test(a, b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
        Thread.currentThread().sleep(1000);
        System.out.println(thread.getState());
        System.out.println(thread1.getState());


    }
}
