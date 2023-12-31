package Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Model.Custumer;
import Model.Order;
import Model.PremiumCustumer;

public class ConfirmPackageController {
    private Custumer custumer;
    private Order order;

    public ConfirmPackageController(Custumer custumer, Order order){
        this.custumer = custumer;
        this.order = order;
    }

    public void displayOrder(int index){
        String nameString = null;

        try {
            nameString = String.valueOf(Order.getOrder().searchStr(index));
        } catch (Exception e) {

        }

        for(int i = 0; i <= Order.getOrder().getMemorySize(); i++){
            System.out.println("orderID" + i + nameString);
        }
        

    }

    public Boolean displayOrderInfo(String nameCustumer){
        return Order.getOrder().toArray(nameCustumer);
    }



    public boolean checkCustumer(String nameCustumer){

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = Order.getOrder().getAll();
        int indexOrder = -1;

        String custumerName = Order.getOrder().searchStr("Owner", nameCustumer);

        if(custumerName == "" || custumerName == null){
            return false;
        }
        
        if(custumerName.equalsIgnoreCase(nameCustumer)){
            return true;
        } else {
            return false;
        }
    }

    public void ConfirmOrder(int idOrder){

        Order.getOrder().setValue("State", "Da giao thanh cong", idOrder);
        Order.getOrder().write();

    }

    public String getStateOrder(int idOrder){
        return Order.getOrder().searchStr("State", idOrder);
    }

    public boolean confirmType_KH(String nameCustumer){

        int index = Custumer.getCustumers().searchIndex("Name", nameCustumer);

        String name = Custumer.getCustumers().searchStr("Name", index);

        String address = Custumer.getCustumers().searchStr("Address", index);

        String type = Custumer.getCustumers().searchStr("Type", index);

        String purchasedProduct = Custumer.getCustumers().searchStr("Purchased Product", index);



        if(index == -1){
            return false;
        } else {
            PremiumCustumer.getPreCustumer().update(name, address, type, purchasedProduct);
            PremiumCustumer.getPreCustumer().write();
            return true;
        }
    }

    public String getNameOrder(int idOrder){

        String nameOrder = Order.getOrder().searchStr("Name", idOrder);

        return nameOrder;
    }

    public int getOrderIndex(int idOrder){
        return Order.getOrder().searchIndex("ID", idOrder);
    }

    public void addPHistory(String nameCustumer, int idOrder, String nameOrder){

        String addValue = Custumer.getCustumers().addValue("Purchased Product", nameCustumer, idOrder, nameOrder);
        Custumer.getCustumers().setValue("Purchased Product", addValue, idOrder);
        Custumer.getCustumers().write();
        
    }
}
