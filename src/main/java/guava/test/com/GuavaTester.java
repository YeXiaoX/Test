package guava.test.com;

import com.google.common.base.Optional;

/**
 * Created by yexiaoxin on 2019/1/24.
 */
public class GuavaTester {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]){
        GuavaTester guavaTester = new GuavaTester();
        guavaTester.setName("a");

        Optional<GuavaTester> oTest = Optional.of(guavaTester);
        System.out.println(oTest.get().getNum().isPresent());
        guavaTester.setName("b");
        guavaTester = new GuavaTester();
        //使用Optional对象本身不会改变，但对象的属性值可以改变
        System.out.println(oTest.get().getName());

        Integer invalidInput = null;
        //使用Optional在构建Optional对象时如果对象为null就会报错，如果不用则到具体的使用改对象时才会报错
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));

        System.out.println(guavaTester.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }

    public Optional<Integer> getNum(){
        return Optional.fromNullable(1);//isPresent为true
        //return Optional.fromNullable(null);//isPresent为false
    }
}