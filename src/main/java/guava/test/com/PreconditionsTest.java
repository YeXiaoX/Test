package guava.test.com;

import com.google.common.base.Preconditions;

/**
 * Created by yexiaoxin on 2019/1/24.
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        try {
            Preconditions.checkArgument(1>2);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Preconditions.checkArgument(1>2,"参数不合法!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Preconditions.checkNotNull(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

