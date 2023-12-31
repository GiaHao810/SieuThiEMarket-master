package Template;

import java.util.Scanner;

import Config.Actions;
import Controller.ConfirmOrderController;
import Controller.HangHoaController;
import Controller.LogginAccountController;
import Model.Order;

public class ConfirmOrderUI {
    private HangHoaController hangHoaController;
    private Actions command;
    private Order order;

    private ConfirmOrderController confirmOrderController = new ConfirmOrderController(order);

    private Scanner input = new Scanner(System.in);

    public ConfirmOrderUI(ConfirmOrderController confirmOrderController){
        this.confirmOrderController = confirmOrderController;
        this.command = null;
    }

    public int ConfirmInput(LogginAccountController logginAccountController){
                
        confirmOrderController.displayOrder();

        System.out.print("[SYSTEM] Order's ID: ");
        int orderID = input.nextInt();

        if(checkMemory(orderID)){
            System.out.println("[SYSTEM] YES OR NO");
            System.out.print("[SYSTEM] Please comfirm your action: ");
            String resCmd = input.next();

            if(!resCmd.equalsIgnoreCase("YES")){
                orderID = -1;
            }
        } else {
            orderID = -1;
            System.out.println("[SYSTEM] INVALID ID");
        }

        return orderID;
    }

    public boolean checkMemory(int index){
        if(index < confirmOrderController.getSize()){
            return true;
        } else {
            return false;
        }
    }

    public String handleCommands(String reply){
        String cmd = reply.toUpperCase();
        
        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.XNDH)){
            return "[SYSTEM] Choose an ID to vertify";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(LogginAccountController logginAccountController){
        int orderID = ConfirmInput(logginAccountController);

        String returnValue = null;

        if(orderID != -1){
            confirmOrderController.ConfirmOrder(orderID);
            returnValue = "[SYSTEM] COMFIRM SUCCESSED";
        } else {
            returnValue = "[SYSTEM] ORDER DOES NOT EXIST";
        }

        return returnValue;
    }
}
