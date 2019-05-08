package Test;


/**
 * Created by yexiaoxin on 2019/5/8.
 * 利用volatile实现三个线程交替打印1,2,3
 */
public class TestVolatile {
    private static volatile int a = 1;

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    if (a == 1) {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(1);
                        a++;
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    if (a == 2) {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(2);
                        a++;
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while(true) {
                    if (a == 3) {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(3);
                        a=1;
                    }
                }
            }
        }.start();
    }
}
