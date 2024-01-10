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
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào ID máy muốn bât:");
                    String idStart = sc.nextLine();
                    Computer startUpComputer = netService.findById(idStart,computers);
                    if (startUpComputer == null){
                        System.err.println("Máy tính có id là "+idStart+" không tồn tại");
                    } else {
                        netService.startUp(startUpComputer);
                    }
                    break;
                case 2:
                    System.out.println("Nhập vào ID máy muốn tính tiền:");
                    String idEnd = sc.nextLine();
                    Computer shutdownComputer = netService.findById(idEnd,computers);
                    if (shutdownComputer == null){
                        System.err.println("Máy tính có id là "+idEnd+" không tồn tại");
                    } else {
                        netService.shutdown(shutdownComputer);
                    }
                    break;
                case 3:
                    System.out.printf("%4s | %8s | %20s | %15s | %-10s\n","ID","Tên Máy","Giờ mở máy", "Trạng thái","Dịch vụ");
                    netService.displayAll(computers);
                    break;
                case 4:
                    System.out.println("Nhập máy muốn thêm dịch vụ: ");
                    String idComputerAddService = sc.nextLine();
                    Computer addServiceComputer = netService.findById(idComputerAddService,computers);
                    if (addServiceComputer == null){
                        System.err.println("Máy tính có id là"+idComputerAddService+" không tồn tại");
                    } else if (!addServiceComputer.isStatus()){
                        System.err.println("Máy "+addServiceComputer.getComputerId()+" hiện đang tắt, không thể thêm dịch vụ");
                    } else {
                        netService.addService(addServiceComputer);
                    }
                    break;
                case 5:
                    Computer oldComputer,newComputer;
                    do {
                        System.out.println("Nhập vào máy muốn chuyển: ");
                        String idOldComputer = sc.nextLine();
                        oldComputer = netService.findById(idOldComputer,computers);
                        if (oldComputer == null){
                            System.err.println("Máy tính có id là "+idOldComputer+" không tồn tại");
                        } else if (!oldComputer.isStatus()){
                            System.err.println("Máy "+oldComputer.getComputerId()+" đang tắt, không thể chuyển.");
                        } else {
                            break;
                        }
                    } while (true);
                    do {
                        System.out.println("Nhập vào máy muốn chuyển tới: ");
                        String idNewComputer = sc.nextLine();
                        newComputer = netService.findById(idNewComputer,computers);
                        if (newComputer == null){
                            System.err.println("Máy tính có id là "+idNewComputer+" không tồn tại");
                        } else if (newComputer.isStatus()){
                            System.err.println("Máy " +newComputer.getComputerId()+" hiện đang hoạt động, không thể đổi");
                        } else {
                            break;
                        }
                    }while (true);
                    netService.changeComputer(oldComputer,newComputer);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp");
            }
        } while (true);
    }
}
