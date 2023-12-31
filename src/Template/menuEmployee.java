package Template;

import java.util.Scanner;

import Config.Actions;
import Controller.ConfirmOrderController;
import Controller.ConfirmTypeEmployController;
import Controller.LogginAccountController;
import Model.Order;

public class menuEmployee {

    public void renderUI(LogginAccountController logginAccountController, Scanner a) {
        Order orderObj = new Order();

        menuThemSuaXoa menuThemSuaXoa = new menuThemSuaXoa();
        menuThongKe menuThongKe = new menuThongKe();
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);

        ConfirmOrderController confirmOrderController = new ConfirmOrderController(orderObj);
        ConfirmOrderUI confirmOrderUI = new ConfirmOrderUI(confirmOrderController);

        ConfirmTypeEmployController confirmTypeEmployController = new ConfirmTypeEmployController(orderObj);
        ConfirmTypeEmployUI confirmTypeEmployUI = new ConfirmTypeEmployUI(confirmTypeEmployController);

        int key;
        String rep = null;

        do {
            displayOptions(logginAccountController);

            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch (key) {
                case 1: menuThemSuaXoa.renderUI(a);
                    break;
                case 2:
                    rep = Actions.XNDH.toString();

                    System.out.println(confirmOrderUI.handleCommands(rep));

                    System.out.println(confirmOrderUI.handleInput(logginAccountController));
                    break;
                case 3:
                    rep = Actions.XNKHTT.toString();

                    System.out.println(confirmTypeEmployUI.handleCommand(rep));

                    System.out.println(confirmTypeEmployUI.handleInput());
                    break;
                case 4: 
                    menuThongKe.renderUI(a);
                    break;
                case 5: {
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
            }
        } while (key != 5);
        System.out.println(" kết thúc");
    }

    public void displayOptions(LogginAccountController logginAccountController) {
        if (logginAccountController.getEmployee().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. thêm sửa xóa hàng hóa                               ");
            System.out.println(">>2. xác nhận đơn hàng cho khách                         ");
            System.out.println(">>3. xác nhận đăng ký khách hàng thân thiết cho khách    ");
            System.out.println(">>4. thống kê                                            ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println("=========================================================");
        } else {
            BootStrap.chooseOptions();
        }

    }

}
