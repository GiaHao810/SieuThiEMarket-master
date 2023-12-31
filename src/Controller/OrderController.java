package Controller;

import Model.Custumer;
import Model.Order;

public class OrderController {
    private Custumer custumerObj;
    private Order orderObj;

    public OrderController(Custumer custumerObj, Order orderObj){
        this.custumerObj = custumerObj;
        this.orderObj = orderObj;
    }

    
}
