package com.ra.NetManager.run;

import com.ra.NetManager.Service.NetService;
import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdditionalMenu {
    public static List<AdditionalService> additionalMenuList = new ArrayList<>();
    public static void menu(Computer addServiceComputer) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("++++Menu dịch vụ++++");
            additionalMenuList.stream()
                    .forEach(additionalService -> {
                        System.out.printf("%s. %s | Giá: %s\n",
                                additionalService.getServiceId(),
                                additionalService.getServiceName(),
                                additionalService.getPrice());
                    });
            System.out.println((additionalMenuList.size() + 1) + ". Thoát");
            System.out.print("Mời bạn chọn");
            String choice = sc.nextLine();
            addService(choice,addServiceComputer);
        } while (!additionalMenuList.isEmpty());
    }
    public static void addService(String choice,Computer addServiceComputer){
        AdditionalService additionalService = additionalMenuList.stream()
                .filter(as -> as.getServiceId().equals(choice))
                .findFirst().orElse(null);
        if (choice.equalsIgnoreCase(String.valueOf(additionalMenuList.size() + 1))) {
            GamingNet.menu();
        } else if ((additionalService == null)) {
            System.err.println("Dịch vụ bạn muốn thêm không tồn tại");
        } else {
            addServiceComputer.getAdditionalServiceList().add(additionalService);
            System.out.println("Đã thêm dịch vụ thành công");
        }
    }
    public static void addServiceToMenu(AdditionalService additionalService){
        additionalMenuList.add(additionalService);
    }
}
