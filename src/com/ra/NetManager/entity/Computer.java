package com.ra.NetManager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Computer implements Serializable {
    private String computerId;
    private String name;
    private List<AdditionalService> additionalServiceList = new ArrayList<>();
    private String startTime;
    private boolean status = false;

    public Computer() {
    }

    public Computer(String computerId, String name, String startTime, boolean status) {
        setStatus(status);
        setComputerId(computerId);
        setStartTime(startTime);
        setName(name);
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if (!isStatus()){
            this.startTime = null;
        } else {
            this.startTime = startTime;
        }
    }


    public List<AdditionalService> getAdditionalServiceList() {
        return additionalServiceList;
    }

    public void setAdditionalServiceList(List<AdditionalService> additionalServiceList) {
        this.additionalServiceList = additionalServiceList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void display(){
        if (additionalServiceList.isEmpty()){
            System.out.printf("%4s | %8s | %20s | %15s | %s\n",
                    getComputerId(),
                    getName(),
                    getStartTime(),
                    isStatus()?"Đang sử dụng":"Đã tắt",
                    "Chưa có dịch vụ phát sinh"
            );
        } else {
            Map<String,Long> additionalServices = additionalServiceList.stream()
                    .collect(Collectors
                            .groupingBy(AdditionalService::getServiceName,Collectors.counting())
                    );
            System.out.printf("%4s | %8s | %20s | %15s |",
                    getComputerId(),
                    getName(),
                    getStartTime(),
                    isStatus()?"Đang sử dụng":"Đã tắt"
            );
            additionalServices.keySet()
                    .forEach(serviceName -> System.out.printf(" [%s : %s] |",serviceName,additionalServices.get(serviceName)));
            System.out.print("\n");
        }
    }
    public void setStandBy(){
        setStatus(false);
        setStartTime(null);
        setAdditionalServiceList(new ArrayList<>());
        System.out.println("Đã tắt "+getName());
    }


}
