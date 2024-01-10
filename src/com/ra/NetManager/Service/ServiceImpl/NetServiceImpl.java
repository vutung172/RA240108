package com.ra.NetManager.Service.ServiceImpl;

import com.ra.NetManager.Service.DateTimeFormat;
import com.ra.NetManager.Service.NetService;
import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class NetServiceImpl implements NetService{
    private final String DATE_FORMAT = "dd/MM/yyyy, HH:mm:ss";
    private final double pricePerHour = 15000;
    @Override
    public void startUp(String id,List<Computer> computers) {
        Computer foundComputer = computers.stream()
                .filter(c -> c.getComputerId().equals(id))
                .findFirst()
                .orElse(null);
        if(foundComputer == null){
            System.err.println("Máy tính không tồn tại");
        } else if (foundComputer.isStatus()){
            System.err.println("Máy tính đang được sử dụng");
        } else {
            foundComputer.setStatus(true);
            foundComputer.setStartTime(currentTime());
            System.out.println("Đã mở máy");
        }
    }

    @Override
    public void Shutdown(String id,List<Computer> computers) {
        Computer foundComputer = computers.stream()
                .filter(c -> c.getComputerId().equals(id))
                .findFirst().orElse(null);
        if(foundComputer == null){
            System.err.println("Máy tính không tồn tại");
        } else if (!foundComputer.isStatus()){
            System.err.println("Máy tính chưa bật");
        } else {
            System.out.printf("Giá tiền: %s USD\n",
                    payBill(foundComputer.getStartTime(), currentTime()));
            System.out.println("Đã tắt máy");
            foundComputer = new Computer();
            foundComputer.setStatus(false);
        }
    }

    @Override
    public float payBill(String start, String end) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime startTime = LocalDateTime.parse(start,dateTimeFormatter);
        LocalDateTime endTime = LocalDateTime.parse(end,dateTimeFormatter);
        long hours = Duration.between(endTime,startTime).toHours();
        if (hours <= 1){
            return (float) (1*pricePerHour);
        } else {
            return (float) (hours*pricePerHour);
        }
    }

    @Override
    public void displayAll(List<Computer> computers) {
        computers.forEach(Computer::display);
    }

    @Override
    public void addService(String id, AdditionalService service) {

    }

    @Override
    public void changeComputer(String idOldComputer, String idNewComputer) {
    }

    @Override
    public String currentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return localDateTime.format(dateTimeFormatter);
    }

}
