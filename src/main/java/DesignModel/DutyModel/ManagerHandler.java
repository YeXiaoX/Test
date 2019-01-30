package DesignModel.DutyModel;

/**
 * Created by yexiaoxin on 2017/7/31.
 */
public class ManagerHandler extends ConsumeHandler {
    public void handle(String user, int fee) {
        if("yj".equals(user)&&fee<1000){
            System.out.println("manager done!");
        }else{
            System.out.println("can't be done!");
        }
    }
}
