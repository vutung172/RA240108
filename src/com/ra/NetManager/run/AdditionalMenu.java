package com.ra.NetManager.run;

import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdditionalMenu {
    public static List<AdditionalService> additionalMenuList = new ArrayList<>();
    public static void menu(Scanner sc, Computer computerAddService){
        do {
            System.out.println("++++Menu dịch vụ++++");
            additionalMenuList.stream()
                    .forEach(additionalService -> {
                        System.out.printf("%s. %s | Giá: %s\n",
                                additionalService.getServiceId(),
                                additionalService.getServiceName(),
                                additionalService.getPrice());
                    });
            System.out.print("Mời bạn chọn");
            String choice =sc.nextLine();
            AdditionalService additionalService = additionalMenuList.stream()
                    .filter(as -> as.getServiceId().equals(choice))
                    .findFirst().orElse(null);
            if (additionalService == null){
                System.err.println("Dịch vụ bạn muốn thêm không tồn tại");
            } else {
                computerAddService.getAdditionalServiceList().add(additionalService);
                System.out.println("Đã thêm dịch vụ thành công");
            }
        } while (!additionalMenuList.isEmpty());
    }
}
