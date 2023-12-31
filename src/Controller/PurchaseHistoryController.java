package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Custumer;
import Model.Order;

public class PurchaseHistoryController {
    private Custumer custumer;

    public PurchaseHistoryController(Custumer custumer){
        this.custumer = custumer;
    }

    public Boolean displayOrderInfo(String nameCustumer){
        return Order.getOrder().toArray_B(nameCustumer);
    }

    public List<String> getPHistory(String name){
        List<String> list = new ArrayList<>();

            int index = Custumer.getCustumers().searchIndex("Name", name);

            if(index == -1){
                list.add("NO CUSTUMER FOUND");
                return list;
            }

            String result = Custumer.getCustumers().searchStr("Purchased Product", index);

            if(result == null || result == ""){
                list.add("NO PRODUCT FOUND");
                return list;
            } else {
                list.add(result);
                return list;
            }
    }
}
