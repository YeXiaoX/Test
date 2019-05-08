package Test;

/**
 * Created by yexiaoxin on 2019/5/8.
 */
public class Test {
    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.setA(1);
        Object o = new Object();
        ThreadTest t1 = new ThreadTest(1,t,o);
        ThreadTest t2 = new ThreadTest(2,t,o);
        ThreadTest t3 = new ThreadTest(3,t,o);
        t1.start();
        t2.start();
        t3.start();
    }
}
