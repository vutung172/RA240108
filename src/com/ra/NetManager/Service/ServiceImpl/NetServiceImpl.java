package com.ra.NetManager.Service.ServiceImpl;

import com.ra.NetManager.Service.DateTimeFormat;
import com.ra.NetManager.Service.NetService;
import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;
import com.ra.NetManager.run.AdditionalMenu;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NetServiceImpl implements NetService {
    private final String DATE_FORMAT = "dd/MM/yyyy, HH:mm:ss";
    private final double pricePerHour = 15000;

    @Override
    public void startUp(Computer startUpComputer) {
        if (startUpComputer == null) {
            System.err.println("Máy tính không tồn tại");
        } else if (startUpComputer.isStatus()) {
            System.err.println("Máy tính đang được sử dụng");
        } else {
            startUpComputer.setStatus(true);
            startUpComputer.setStartTime(currentTime());
            System.out.println("Đã mở máy");
        }
    }

    @Override
    public void shutdown(Computer shutdownComputer) {
        if (shutdownComputer == null) {
            System.err.println("Máy tính không tồn tại");
        } else if (!shutdownComputer.isStatus()) {
            System.err.println("Máy tính chưa bật");
        } else {
            System.out.printf("%8s | %15s | %15s |\n","Máy","Số giờ chơi","Tổng tiền");
            System.out.printf("%8s | %10.2f giờ | %10.0f VND |\n",
                    shutdownComputer.getComputerId(),
                    totalTimeCount(shutdownComputer.getStartTime(), currentTime()),
                    payBill(shutdownComputer.getStartTime(),currentTime())
            );
            shutdownComputer.setStandBy();
        }
    }

    @Override
    public double totalTimeCount(String start, String end) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime startTime = LocalDateTime.parse(start, dateTimeFormatter);
        LocalDateTime endTime = LocalDateTime.parse(end, dateTimeFormatter);
        long minutes = Duration.between(startTime,endTime).toMinutes();
        return (double) minutes /60;
    }

    @Override
    public double payBill(String start,String end) {
        double totalTime = totalTimeCount(start,end);
        if (totalTime <= 1) {
            return (1 * pricePerHour);
        } else {
            return (totalTime * pricePerHour);
        }
    }

    @Override
    public void displayAll(List<Computer> computers) {
        computers.forEach(Computer::display);
    }

    @Override
    public void addService(Computer addServiceComputer) {
        if (addServiceComputer == null) {
            System.err.println("Máy không tồn tại");
        } else {
            AdditionalMenu.menu(addServiceComputer);
        }
    }

    @Override
    public void changeComputer(Computer oldComputer, Computer newComputer) {
        //Transfer  data of oldComputer to newComputer
        newComputer.setStatus(true);
        newComputer.setStartTime(oldComputer.getStartTime());
        newComputer.setAdditionalServiceList(oldComputer.getAdditionalServiceList());

        //Set oldComputer to off;
        oldComputer.setStandBy();
        System.out.println("Đã chuyển từ "+oldComputer.getName()+" sang "+newComputer.getName()+" thành công");
    }

    @Override
    public String currentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return localDateTime.format(dateTimeFormatter);
    }

    @Override
    public Computer findById(String id, List<Computer> computers) {
        return computers.stream()
                .filter(c -> c.getComputerId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
