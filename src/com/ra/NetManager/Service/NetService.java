package com.ra.NetManager.Service;

import com.ra.NetManager.entity.Computer;
import java.util.List;

public interface NetService {
    String currentTime();
    void startUp(Computer startUpComputer);
    void shutdown(Computer shutdownComputer);
    double payBill(String start, String end);
    void displayAll(List<Computer> list);
    void addService(Computer addserviceComputer);
    void changeComputer(Computer idOldComputer,Computer idNewComputer);
    Computer findById(String id,List<Computer> list);
    double totalTimeCount(String start, String end);
}
