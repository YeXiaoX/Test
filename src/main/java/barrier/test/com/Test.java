package barrier.test.com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by yexiaoxin on 2017/7/10.
 */
public class Test {
    private static int count = 5;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private static class WorkThread implements Runnable {
        private CyclicBarrier barrier;

        public WorkThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        public void run() {
            System.out.println(Thread.currentThread().getId() + "barrier");
            try {
                barrier.await();
                System.out.println(Thread.currentThread().getId() + "wait over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    private static double getLiFangGen(double num){
        if(num==0){
            return 0;
        }
        double num1 = num;
        double num2  = ((2*num1)+(num/(num1*num1)))/3;
        System.out.println(num2);
        while(num1-num2>0.00000001  || num1-num2<(-0.00000001)){
            num1 = num2;
            num2  = ((2*num1)+(num/(num1*num1)))/3;
            System.out.println(num2);
        }

        return num2;

    }

    private static double kaiFang(double a){
        if(a==0)return 0;
        double x = a;
        double y = (2*x+a/(x*x))/3;
        return 0.0;
    }



    private static double getPingFangGen(double num){
        if(num==0){
            return 0;
        }
        if(num<0){
            System.out.println(num+"没有平方根");
            System.exit(0);
        }
        double num1 = num;
        double num2 = (num1+(num/num1))/2;
        while(num1-num2>0.00000001){
            num1 = num2;
            num2 = (num1+(num/num1))/2;
        }

        return num2;
    }

    public static void main(String args[]) {
//        Executor threadPool = new ScheduledThreadPoolExecutor(count);
//        Test t = new Test();
//        CyclicBarrier c = new CyclicBarrier(count + 1);
//        for (int i =0; i < 5; i++) {
//            threadPool.execute(new WorkThread(c));
//        }
//        try {
//            c.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        System.out.println("test");
//        Integer i = 10000;
//        long j = 10000;
//        System.out.println(i==j);
//        Test t = new Test();
//        System.out.println(1 == t.getId());
//
//        BigDecimal c;
//        BigDecimal b;
//        c = new BigDecimal(3);
//        b = new BigDecimal(81);
//        System.out.println(c.divide(b, 2, RoundingMode.HALF_UP));
//
//        System.out.println(Math.pow(64,1.0/3));
//
//        System.out.println("请输入一个数字");
//        Scanner sc= new Scanner(System.in);
//        double a= sc.nextDouble();
//        double num =getLiFangGen(a);
//        System.out.println(a+"的立方根为："+num);
//        double num1 = getPingFangGen(a);
//        System.out.println(a+"的平方根为："+num1);

        Long time = System.currentTimeMillis();

        time = time - 360000;
        Timestamp date = new Timestamp(time);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = sdf.format(date);
        System.out.println(temp);
        System.out.println(date.getTime());

    }
}
