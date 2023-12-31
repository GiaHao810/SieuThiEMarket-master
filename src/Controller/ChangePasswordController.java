package Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Model.Account;

public class ChangePasswordController {
    // methods
    public void changePassword(LogginAccountController logginAccountController, int currentPass, int newPass) {
        JsonArray array = Account.getAccount().getAll();
        int index = Account.getAccount().search("un", logginAccountController.getCustomer().getUserName());

        JsonObject jsonObject = array.get(index).getAsJsonObject();

        boolean valid = this.checkValidPass(jsonObject.get("ps").getAsInt(), currentPass, newPass);

        if (valid) {
            jsonObject.addProperty("ps", newPass);

            Account.getAccount().write();
        }

    }

    public boolean checkValidPass(int accPass, int currentPass, int newPass) {
        boolean valid = false;
        // currentPass correct
        if (currentPass == accPass) {
            if (newPass == accPass) {
                System.out.println("[ERROR] new password must be different to old password");
                valid = false;
            } else {
                valid = true;
            }
        } else { // currentPass invalid
            System.out.println("[ERROR] current password invalid!");
            valid = false;
        }

        return valid;
    }
}
