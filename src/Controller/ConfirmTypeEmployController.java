package Controller;

import Model.Custumer;
import Model.Order;
import Model.PremiumCustumer;

public class ConfirmTypeEmployController {
    private Order order;

    public ConfirmTypeEmployController(Order order){
        this.order = order;
    }

    public boolean confirmType(String nameCustumer){

        int index = Custumer.getCustumers().searchIndex("Name", nameCustumer);

        int indexPre = Custumer.getCustumers().searchIndex("Name", nameCustumer);

        if(index == -1){
            return false;
        } else {
            Custumer.getCustumers().setValue("Type", "Premium", index);

            Custumer.getCustumers().write();

            PremiumCustumer.getPreCustumer().remove(indexPre);
            return true;
        }
    }

    public boolean displayPreCus(){
        if(PremiumCustumer.getPreCustumer().getMemorySize() != -1){
            PremiumCustumer.getPreCustumer().toArray();
            return true;
        } else {
            return false;
        }
    }
}
