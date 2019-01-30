package DesignModel.DutyModel;

/**
 * Created by yexiaoxin on 2017/7/31.
 */
public class Test {
    public static void main(String args[]){
        LeaderHandler l = new LeaderHandler();
        MasterHandler m = new MasterHandler();
        ManagerHandler m1 = new ManagerHandler();
        l.setNextHandler(m);
        m.setNextHandler(m1);
        l.handle("yj",10);
        l.handle("yj",150);
        l.handle("yj",500);
        l.handle("yj",1000);
    }
}
