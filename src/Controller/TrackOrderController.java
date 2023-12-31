package Controller;

import Model.Order;

public class TrackOrderController {
    private Order orderObj;

    public TrackOrderController(Order orderObj){
        this.orderObj = orderObj;
    }

    public Boolean displayOrderInfo(String nameCustumer){
        return Order.getOrder().toArray(nameCustumer);
    }

    public String getCustumerName(LogginAccountController logginAccountController){
        return logginAccountController.getCustomer().getUserName();
    }
}