package com.ra.NetManager.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Computer {
    private String computerId;
    private List<AdditionalService> additionalServiceList = new ArrayList<>();
    private String startTime;
    private boolean status = false;

    public Computer() {
    }

    public Computer(String computerId, String startTime, boolean status) {
        setStatus(status);
        setComputerId(computerId);
        setStartTime(startTime);

    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
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
        System.out.printf("%4s | %20s | %15s |\n",getComputerId(),getStartTime(),isStatus()?"Đang sử dụng":"Đã tắt");
    }
    public void setStandBy(){
        setStatus(false);
        setStartTime(null);
        setAdditionalServiceList(new ArrayList<>());
        System.out.println("Máy tính đã tắt");
    }


}
