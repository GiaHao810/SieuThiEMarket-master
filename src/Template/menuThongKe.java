package Template;
import java.util.Scanner;
public class menuThongKe {

    public void renderUI (Scanner a) {
        int key;
        do {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. Theo Ngày                                           ");
            System.out.println(">>2. Theo Loại hàng hóa                                  ");
            System.out.println(">>3. Theo nhà cung cấp                                   ");
            System.out.println(">>4. trở về.                                             ");
            System.out.println("=========================================================");
            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch(key){
                case 1: 
                    break;
                case 2:
                    break;
                case 3: 
                    break;
            }
        } while (key != 4);
        System.out.println(" kết thúc");
    }
}

