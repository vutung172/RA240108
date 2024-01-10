package com.ra.NetManager.Service;

import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface NetService {
    String currentTime();
    void startUp(String id,List<Computer> list);
    void Shutdown(String id,List<Computer> list);
    float payBill(String start, String end);
    void displayAll(List<Computer> list);
    void addService(String id, AdditionalService service);
    void changeComputer(String idOldComputer,String idNewComputer);
}
