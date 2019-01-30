package DesignModel.DutyModel;

/**
 * Created by yexiaoxin on 2017/7/31.
 */
public class MasterHandler extends ConsumeHandler {
    public void handle(String user, int fee) {
        if("yj".equals(user)&& fee<500){
            System.out.println("master done!");
        }else{
            getNextHandler().handle(user,fee);
        }
    }
}
