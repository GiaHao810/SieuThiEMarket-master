package Controller;

import Model.Order;

public class ConfirmOrderController {
    private Order orderObj;

    public ConfirmOrderController(Order orderObj){
        this.orderObj = orderObj;
    }

    public void ConfirmOrder(int idOrder){

        Order.getOrder().setValue("State", "Dang giao", idOrder);
        Order.getOrder().write();
    }

    public void displayOrder(){
        Order.getOrder().toArray_A();
    }

    public int getSize(){
        return Order.getOrder().getMemorySize();
    }


}
