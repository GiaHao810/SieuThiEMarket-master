package Model;

public class HangHoa {

    private static StoredFiles hanghoas = new StoredFiles("hanghoa.json");

    private int id;
    private String name;
    private Double price;
    private boolean isAble;
    private int state;

    public HangHoa(){

    }

    public HangHoa(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAble = true;
    }

    public HangHoa(String nameOfString){
        this.name = nameOfString;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public boolean getHangHoaState() {
        return isAble;
    }

    public int getState() {
        return state;
    }

    public void setState(int state){
        this.state = state;
    }

    public void setAble(boolean isAble) {
        this.isAble = isAble;
    }

    public static StoredFiles getHanghoas() {
        return hanghoas;
    }
}
