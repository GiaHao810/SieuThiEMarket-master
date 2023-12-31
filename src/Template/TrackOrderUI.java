package Template;

import java.util.List;

import Config.Actions;
import Controller.LogginAccountController;
import Controller.TrackOrderController;
import Model.Order;

public class TrackOrderUI {
    private Order orderObj;
    private Actions command;

    TrackOrderController trackOrderController = new TrackOrderController(orderObj);

    public TrackOrderUI(TrackOrderController trackOrderController){
        this.trackOrderController = trackOrderController;
        this.command = null;
    }
    
    public List<Integer> TrackOrderInput(LogginAccountController logginAccountController){

        String owner = logginAccountController.getCustomer().getUserName();
        
        return Order.getOrder().searchIndexList("Owner", owner);
    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.TDDH)){
            return "[SYSTEM] Processing";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(LogginAccountController logginAccountController){
  
        String returnValue = null;

        String nameCustumer = logginAccountController.getCustomer().getUserName();

        if(trackOrderController.displayOrderInfo(nameCustumer)){
            return "[SYSTEM] YOUR ORDER IS PRINTED";
        } else {
            return "[SYSTEM] YOU DONT HAVE ANY ORDER";
        }
    }


}
