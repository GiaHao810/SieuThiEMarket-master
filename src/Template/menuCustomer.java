package Template;

import java.util.Scanner;

import Config.Actions;
import Controller.ConfirmPackageController;
import Controller.CreateOrderController;
import Controller.LogginAccountController;
import Controller.PurchaseHistoryController;
import Controller.TrackOrderController;
import Model.Custumer;
import Model.HangHoa;
import Model.Order;

public class menuCustomer {
    public void renderUI(LogginAccountController logginAccountController, Scanner a) {
        HangHoa hanghoaObj = new HangHoa();
        Order orderObj = new Order();
        Custumer custumer = new Custumer();
        Order order = new Order();

        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);
        ChangePasswordUI changePasswordUI = new ChangePasswordUI(logginAccountController);

        CreateOrderController createOrderController = new CreateOrderController(hanghoaObj);
        CreateOrderUI createOrderUI = new CreateOrderUI(createOrderController);

        TrackOrderController trackOrderController = new TrackOrderController(orderObj);
        TrackOrderUI trackOrderUI = new TrackOrderUI(trackOrderController);

        PurchaseHistoryController purchaseHistoryController = new PurchaseHistoryController(custumer);
        PurchaseHistoryUI purchaseHistoryUI = new PurchaseHistoryUI(purchaseHistoryController);

        ConfirmPackageController confirmPackageController = new ConfirmPackageController(custumer, order);
        ConfirmPackageUI confirmPackageUI = new ConfirmPackageUI(confirmPackageController);

        String rep = null;

        int key;
        do {
            displayOptions(logginAccountController);

            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch (key) {
                case 1:
                    rep = Actions.MH.toString();

                    System.out.println(createOrderUI.handleCommands(rep));

                    System.out.println(createOrderUI.handleInputs(logginAccountController)); 
                    break;
                case 2:
                    rep = Actions.LSMH.toString();
                    
                    System.out.println(purchaseHistoryUI.handleCommand(rep)); 

                    System.out.println(purchaseHistoryUI.handleInput(logginAccountController));
                    break;
                case 3:
                    rep = Actions.TDDH.toString();

                    System.out.println(trackOrderUI.handleCommand(rep));

                    System.out.println(trackOrderUI.handleInput(logginAccountController));

                    rep = Actions.XNDG.toString();
                    
                    System.out.println(confirmPackageUI.handleCommand(rep));

                    System.out.println(confirmPackageUI.handleInput(logginAccountController));
                    break;
                case 4:
                    //trash
                    break;
                case 5: {
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
                case 6: {
                    changePasswordUI.handleCPInputs(logginAccountController, key);
                    break;
                }
                case 0: {
                    return;
                }
            }
        } while (key != 5);

    }

    public void displayOptions(LogginAccountController logginAccountController) {
        if (logginAccountController.getCustomer().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. mua hàng                                            ");
            System.out.println(">>2. xem lịch sử mua hàng                                ");
            System.out.println(">>3. theo dõi - xác nhận hàng hóa                        ");
            System.out.println(">>4. Tra cứu hàng hóa                                    ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println(">>6. Đổi mật khẩu                                        ");
            System.out.println("=========================================================");
        } else {
            BootStrap.chooseOptions();
        }

    }
}
