package com.ra.NetManager.run;

import com.ra.NetManager.Service.ServiceImpl.NetServiceImpl;
import com.ra.NetManager.entity.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamingNet {
    public static List<Computer> computers = new ArrayList<>();
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        NetServiceImpl netService = new NetServiceImpl();
        do {
            System.out.println("+++++Quản lý Net+++++");
            System.out.println("1. Mở máy");
            System.out.println("2. Tính tiền"); // giá mở của là 15k/giờ, nếu dưới 1h thì
            System.out.println("3. Hiển thị");
            System.out.println("4. Thêm dịch vụ"); // Thêm cách dịch vụ
            System.out.println("5. Chuyển máy"); //Chuyển tất cả các dịch vụ trong máy
            System.out.println("6. Thoát");
            System.out.print("Mời bạn chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập vào ID máy muốn bât:");
                    String idStart = sc.nextLine();
                    netService.startUp(idStart,computers);
                    break;
                case 2:
                    System.out.println("Nhập vào ID máy muốn tính tiền:");
                    String idEnd = sc.nextLine();
                    netService.Shutdown(idEnd,computers);
                    break;
                case 3:
                    System.out.printf("%4s | %20s | %15s |\n","Máy","Giờ mở máy","Trạng thái");
                    netService.displayAll(computers);
                    break;
                case 4:
                    AdditionalMenu.menu();
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp");
            }
        }while (true);
    }
}
