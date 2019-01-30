package DesignModel.DutyModel;

/**
 * Created by yexiaoxin on 2017/7/31.
 */
public abstract  class ConsumeHandler {
    private ConsumeHandler consumeHandler;
    public void setNextHandler(ConsumeHandler consumeHandler){
        this.consumeHandler = consumeHandler;
    }

    public ConsumeHandler getNextHandler(){
        return  this.consumeHandler;
    }

    public abstract  void handle(String user,int fee);
}
