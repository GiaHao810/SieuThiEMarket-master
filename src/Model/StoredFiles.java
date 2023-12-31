package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFiles {
    private JsonArray memory;
    private String storedFile;

    // constructor
    public StoredFiles(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    // methods
    public JsonArray read() {
        JsonArray jsonArray = null;

        try (FileReader reader = new FileReader(storedFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public int search(String key, String value) {
        // search by username
        // key = un|ps|email; value = "mrteo"
        int index = -1;
        String username = null;
        for (int i = 0; i < memory.size(); i++) {
            // lấy tt tài khoản dưới dạng object
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            username = jsonObject.get(key).getAsString();

            if (value.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchIndex(String key, int value) { //Tim kiem theo Key va Value(Int) - Tra ve index neu tim duoc Value(Int)
        
        int index = -1;

        int nameInt = -1;
        for (int i = 0; i < memory.size(); i++) {
            if(value == -1){
                break;
            }
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            nameInt = jsonObject.get(key).getAsInt();
            if (value == nameInt) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchIndex(String key, String value) { //Tim kiem theo Key va Value(String) - Tra ve index neu tim duoc Value(String)

        int index = -1;

        String nameString = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            nameString = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(nameString)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public List<Integer> searchIndexList(String key, String value) { //Tim kiem theo Key va Value(String) - Tra ve index neu tim duoc Value(String)

        List<Integer> list = new ArrayList<>();

        int index = -1;

        String nameString = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            nameString = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(nameString)) {
                list.add(i);
            }
        }
        return list;
    }

    public int searchInt(String key, int value) { //Tim kiem theo Key va Value(Int) - Tra ve gia tri int Neu co trong Json
        int finalInt = -1;

        int nameInt = -1;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            nameInt = jsonObject.get(key).getAsInt();
            if (value == nameInt) {
                finalInt = nameInt;
                break;
            }
        }
        return finalInt;
    }

    public String searchStr(String key, String value) { //Tim kiem theo Key va Value(String) - Tra ve gia tri String Neu co trong Json
        String finalString = null;

        String nameString = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            nameString = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(nameString)) {
                finalString = nameString;
                break;
            }
        }
        return finalString;
    }

    public String searchStr(String key, int index) { //Tim kiem theo key va index - Tra ve list co cac bien rieng biet

        String nameString = null;
        for (int i = 0; i < memory.size(); i++) {
            if(index == -1){
                break;
            }
            
            JsonObject jsonObject = memory.get(i).getAsJsonObject();

            //Dang can kiem tra xem PHistory = null hay khong? Khong lay duoc value neu value = null
            if (index == i) {
                if(!jsonObject.get(key).isJsonNull()){
                    nameString = jsonObject.get(key).getAsString();
                }
                break;
            }
        }

        return nameString;
    }

    public Object searchStr(int index) { //Tim kiem theo index - Tra ve Object

        Object nameObj = null;

        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            if (index == i) {
                nameObj = jsonObject.getAsJsonObject();
                break;
            }
        }

        return nameObj;
    }

    public String searchKey(String key){

        String nameString = null;

        for(int i = 0; i < memory.size(); i++){
            JsonObject jsonObject = memory.get(i).getAsJsonObject();

            nameString = jsonObject.get(key).getAsString();

            if(key.equalsIgnoreCase(nameString)){
                break;
            }
        }

        return nameString;
    }
    
    // add to memory
    public void update(String username, Integer password, String tel, String role, String address) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("tel", tel);
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("address", address);

        memory.add(jsonObject);
    }

    public void update(int id, String name, int price) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", id);
        jsonObject.addProperty("Name", name);
        jsonObject.addProperty("Price", price);

        memory.add(jsonObject);
    }

    public void update(String name, String address,String type, String purchasedProduct) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Name", name);
        jsonObject.addProperty("Address", address);
        jsonObject.addProperty("Type", type);
        jsonObject.addProperty("Purchased Product", purchasedProduct);
    
        memory.add(jsonObject);
    }

    public void update(int idHangHoa, String nameHangHoa, Double priceHangHoa,String owner, String deliveryAddress, String stateDelivery) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", idHangHoa);
        jsonObject.addProperty("Name", nameHangHoa);
        jsonObject.addProperty("Price", priceHangHoa);
        jsonObject.addProperty("Owner", owner);
        jsonObject.addProperty("Address", deliveryAddress);
        jsonObject.addProperty("State", stateDelivery);

        memory.add(jsonObject);
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll() {
        return this.memory;
    }

    public boolean toArray_B(String nameCustumer){ //Tra ve tat ca cac gia tri trong File json
        
        List<Object> list=  new ArrayList<>();

        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            String nameStr = jsonObject.get("Owner").getAsString();
            String stateStr = jsonObject.get("State").getAsString();

            if(!stateStr.equalsIgnoreCase("Dang giao")){
                if(nameStr.equalsIgnoreCase(nameCustumer)){
                    list.add(memory.get(i));   
                }
            } else {
                return false;
            }
        }

        int size = list.size();
        Object[] stringArray = list.toArray(new Object[size]);
        
        int count = 0;
        for (Object object : stringArray) {
            System.out.print("orderId " + count + ": " + object + "\n");
            count ++;
            return true;
        }

        return false;
    }

    public boolean toArray(String nameCustumer){ //Tra ve tat ca cac gia tri trong File json
        
        Boolean returnValue = false;

        List<Object> listOrder =  new ArrayList<>();

        List<Integer> listIndex = new ArrayList<>();

        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            String nameStr = jsonObject.get("Owner").getAsString();

            if(nameStr.equalsIgnoreCase(nameCustumer)){
                listOrder.add(memory.get(i));
                listIndex.add(i);
            }

        }
        int index = 0;
        int size = listOrder.size();
        Object[] stringArray = listOrder.toArray(new Object[size]);
        
        for (Object object : stringArray) {
            System.out.print("orderId " + listIndex.get(index) + ": " + object + "\n");
            index ++;
            returnValue = true;
        }

        return returnValue;
    }

    

    public void toArray_A(){ //Tra ve tat ca cac gia tri trong File json
        
        List<Object> list=  new ArrayList<>();
        for (int i = 0; i < memory.size(); i++) {
                list.add(memory.get(i));   
        }

        int size = list.size();
        Object[] stringArray = list.toArray(new Object[size]);
        
        int count = 0;
        for (Object object : stringArray) {
            System.out.print("orderId " + count + ": " + object + "\n");
            count ++;
        }
    }

    public void toArray(){ //Tra ve tat ca cac gia tri trong File json
        
        List<Object> list=  new ArrayList<>();
        for (int i = 0; i < memory.size(); i++) {
                list.add(memory.get(i));   
        }

        int size = list.size();
        Object[] stringArray = list.toArray(new Object[size]);
        
        int count = 0;
        for (Object object : stringArray) {
            System.out.print(object + "\n");
            count ++;
        }
    }

    public String toArray(int index){

        String nameString = null;
        
        List<Object> list=  new ArrayList<>();
    
        if(memory.size() == -1){
            return null;
        }
    
        for (int i = 0; i <= memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
    
            nameString = jsonObject.getAsString();
            list.add(nameString);
        }
    
        int size = list.size();
        Object[] stringArray = list.toArray(new Object[size]);
        String string = (String) stringArray[index];
        
        return string;
    }

    public void setValue(String key, String value, int index){ //Set value cua mot Key theo index
        
        String nameStr = null;

        for(int i = 0; i < memory.size(); i++){
            JsonObject jsonObject = memory.get(i).getAsJsonObject();

            nameStr = jsonObject.get(key).getAsString();

            if(i == index){
                jsonObject.remove(key);
                jsonObject.addProperty(key, value);
                break;
            }
        }
    }

    public String addValue(String key, String value, int index, String addValue){

        String nameStr = null;

        for(int i = 0; i < memory.size(); i++){
            JsonObject jsonObject = memory.get(i).getAsJsonObject();

            nameStr = jsonObject.get(key).getAsString();

            if(i == index){
                nameStr = nameStr + " + " + addValue;
                break;
            }
        }

        return nameStr;
    }

    public int getMemorySize(){
        return memory.size();
    }

    public void remove(int index){  
        memory.remove(index);
    }
}
