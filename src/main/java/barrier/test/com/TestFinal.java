package barrier.test.com;

/**
 * Created by yexiaoxin on 2019/1/18.
 */
public class TestFinal {
    public static void main(String[] args) {
            String a = "xiaomeng2";
            final String b = "xiaomeng";
            String d = "xiaomeng";
            String c = b + 2;
            String e = d + 2;
            System.out.println((a == c));
            System.out.println((a == e));
            e.intern();
            System.out.println((a == e));
            String x = "hello2";
            String ax = "hello";
            String y = "hello"+2;
            System.out.println(x == y);
            String tx = "java";
            String tx1 = new String("java");
            //tx1.intern();
            System.out.println(tx1 ==tx);

        }
    }


