package Model;

public class Order extends HangHoa{

    private static StoredFiles order = new StoredFiles("orders.json");
    
    private int idHangHoa;
    private String nameHangHoa;
    private Double priceHangHoa;
    
    private String owner;
    private String deliveryAddress;
    private String stateDelivery;

    public Order(){

    }

    public Order(int id, String name, Double price, String owner, String deliveryAddress) {

        this.idHangHoa = id;
        this.nameHangHoa = name;
        this.priceHangHoa = price;
        this.owner = owner;
        this.deliveryAddress = deliveryAddress;
        this.stateDelivery = "Cho xac nhan";
    }

    @Override
    public String getName() {
        return nameHangHoa;
    }

    @Override
    public Double getPrice() {
        return priceHangHoa;
    }

    @Override
    public int getID() {
        return idHangHoa;
    }

    public void setStateDelivery(String stateDelivery) {
        this.stateDelivery = stateDelivery;
    }

    public static StoredFiles getOrder() {
        return order;
    }

    public String getOwner() {
        return owner;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getStateDelivery() {
        return stateDelivery;
    }

    public String getStateDelivery_New() {
        return "Cho xac nhan";
    }

    public void setOrder(int id, String name, Double price, String owner, String deliveryAddress){
        this.idHangHoa = id;
        this.nameHangHoa = name;
        this.priceHangHoa = price;
        this.owner = owner;
        this.deliveryAddress = deliveryAddress;
    }
}
