package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Config.Actions;
import Controller.CreateOrderController;
import Controller.HangHoaController;
import Controller.LogginAccountController;
import Model.Account;
import Model.Custumer;
import Model.HangHoa;
import Model.Order;

public class CreateOrderUI {
    private static Scanner input = new Scanner(System.in);
    private CreateOrderController orderController;
    private Actions command;
    private HangHoa hanghoa;
    private Order order;
    private Custumer custumer;
    private Account account;

    private HangHoaController hangHoaController = new HangHoaController(hanghoa);
    
    public CreateOrderUI(CreateOrderController orderController) {
        this.orderController = orderController;
        this.command = null;
    }

    private int datHangInput(){

        hangHoaController.getAllHangHoa();
        
        System.out.print("[SYSTEM] Item's index: ");
        int purchaseID = input.nextInt();

        if(checkMemorySize(purchaseID)){
            System.out.println("[SYSTEM] YES or NO");
            System.out.print("[SYSTEM] Please confirm your order: ");
            String resCmd = input.next();
    
            if(!resCmd.equalsIgnoreCase("YES")){
                purchaseID = -1;
            }
        } else {
            purchaseID = -1;
            System.out.println("[SYSTEM] WRONG ID");
        }

        return purchaseID;
    }

    public boolean checkMemorySize(int index){
        if(index <= orderController.getSize()){
            return true;
        } else {
            return false;
        }
    }

    public String handleCommands(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.MH)){
            return "[SYSTEM] | Please enter your choice |";
        } else {
            return "[SYSTEM] | Unknown command |";
        }
    }

    public String handleInputs(LogginAccountController logginAccountController){
        List<Object> list = new ArrayList<>();

        int purchaseID = datHangInput();

        int idHangHoa = -1;
        String nameHangHoa = null;
        Double priceHangHoa = -1.0;

        String returnValue = null;

        if(purchaseID == -1){
            return "[SYSTEM] BACK TO MENU";
        }

        list.add(orderController.getValue("ID", purchaseID));
        list.add(orderController.getValue("Name", purchaseID));
        list.add(orderController.getValue("Price", purchaseID));
        
        try {
            String parseStringID = String.valueOf(list.get(0));
            idHangHoa = Integer.valueOf(parseStringID);
    
            nameHangHoa = String.valueOf(list.get(1));
    
            String parseStringHH = String.valueOf(list.get(2));
            priceHangHoa = Double.valueOf(parseStringHH);
        } catch (Exception e) {

        }

        if(this.command.equals(Actions.MH)){
            if(idHangHoa != -1 || nameHangHoa != null || priceHangHoa != -1.0){
                String owner = logginAccountController.getCustomer().getUserName();

                String deliveryAddress = logginAccountController.getCustomer().getAddress();

                Order newOrder = new Order(idHangHoa, nameHangHoa, priceHangHoa, owner, deliveryAddress);

                orderController.CreateNewOrder(newOrder);

                int index = orderController.getIndex("ID", idHangHoa);

                returnValue = "[SYSTEM] | Your order have been created |";
            } else {
                returnValue = "[SYSTEM] | ITEM DOES NOT EXIST |";
            }
            
        }

        return returnValue;
    }

}
