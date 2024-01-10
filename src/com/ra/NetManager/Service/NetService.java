package com.ra.NetManager.Service;

import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public interface NetService {
    String currentTime();
    void startUp(Computer startUpComputer);
    void shutdown(Computer shutdownComputer);
    float payBill(String start, String end);
    void displayAll(List<Computer> list);
    void addService(Computer addserviceComputer);
    void changeComputer(Computer idOldComputer,Computer idNewComputer);
    Computer findById(String id,List<Computer> list);
}
