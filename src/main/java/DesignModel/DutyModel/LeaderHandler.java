package DesignModel.DutyModel;

/**
 * Created by yexiaoxin on 2017/7/31.
 */
public class LeaderHandler extends ConsumeHandler{
    public void handle(String user, int fee) {
        if("yj".equals(user) && fee<100){
            System.out.println("leader done!");
        }else{
            getNextHandler().handle(user,fee);
        }
    }
}
