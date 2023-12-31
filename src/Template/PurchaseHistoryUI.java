package Template;

import Config.Actions;
import Controller.ConfirmPackageController;
import Controller.LogginAccountController;
import Controller.PurchaseHistoryController;
import Model.Custumer;
import Model.Order;

public class PurchaseHistoryUI {
    private Custumer custumer;
    private Order order;
    private Actions command;

    PurchaseHistoryController purchaseHistoryController = new PurchaseHistoryController(custumer);
    ConfirmPackageController confirmPackageController = new ConfirmPackageController(custumer, order);

    public PurchaseHistoryUI(PurchaseHistoryController purchaseHistoryController){
        this.purchaseHistoryController = purchaseHistoryController;
        this.command = null;
    }

    public Boolean showPHistoryInput(LogginAccountController logginAccountController){
        String name = logginAccountController.getCustomer().getUserName();

        return purchaseHistoryController.displayOrderInfo(name);
    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.LSMH)){
            return "[SYSTEM] Purchased History";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(LogginAccountController logginAccountController){

        if(showPHistoryInput(logginAccountController)){
            return "[SYSTEM] YOUR ORDER IS PRINTED";
        } else {
            return "[SYSTEM] You do not have any order";
        }
    }
}
