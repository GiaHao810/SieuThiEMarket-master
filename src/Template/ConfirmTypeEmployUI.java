package Template;

import java.util.Scanner;

import Config.Actions;
import Controller.ConfirmTypeEmployController;
import Model.Order;

public class ConfirmTypeEmployUI {
    private Order order;
    private Actions command;

    private static Scanner input = new Scanner(System.in);

    private ConfirmTypeEmployController confirmTypeEmployController = new ConfirmTypeEmployController(order);

    public ConfirmTypeEmployUI(ConfirmTypeEmployController confirmTypeEmployController){
        this.confirmTypeEmployController = confirmTypeEmployController;
        this.command = null;
    }
    
    public boolean confirmType(){

        confirmTypeEmployController.displayPreCus();
        
        System.out.print("[SYSTEM] Insert a name: ");
        String repName = input.next();
        
        if(confirmTypeEmployController.confirmType(repName)){
            return true;
        } else {
            return false;
        }

    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.XNKHTT;
        if(this.command.equals(Actions.XNKHTT)){
            return "[SYSTEM] Insert a name";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(){
        if(confirmType()){
            return "[SYSTEM] Confirmed Premium Custumer.";
        } else {
            return "[SYSTEM] Something wrong";
        }
    }
}
