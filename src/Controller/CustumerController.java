package Controller;

import Model.Custumer;

public class CustumerController {
    private Custumer custumer;

    public CustumerController(Custumer custumer){
        this.custumer = custumer;
    }

    public void createNewCustumer(String name, String address){
        
        Custumer.getCustumers().update(name, address, "Customer", "");
        Custumer.getCustumers().write();
    }
    
}
