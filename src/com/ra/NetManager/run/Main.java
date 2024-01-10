package com.ra.NetManager.run;

import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

public class Main {
    public static void main(String[] args) {
        GamingNet.computers.add(new Computer("1","23/11/2024, 12:00:00",true));
        GamingNet.computers.add(new Computer("2","23/11/2024, 8:00:00",false));
        GamingNet.computers.add(new Computer("3","23/11/2024, 22:00:00",false));
        GamingNet.computers.add(new Computer("4","23/11/2024, 15:00:00",true));
        GamingNet.computers.add(new Computer("5","23/11/2024, 18:00:00",true));
        AdditionalMenu.additionalMenuList.add(new AdditionalService("1","Bánh mì trứng",1500));
        AdditionalMenu.additionalMenuList.add(new AdditionalService("2","Sting",1200));
        AdditionalMenu.additionalMenuList.add(new AdditionalService("3","Mì trứng",20000));
        AdditionalMenu.additionalMenuList.add(new AdditionalService("4","Xôi",10000));
        AdditionalMenu.additionalMenuList.add(new AdditionalService("5","Cháo",17000));
        GamingNet.menu();
    }
}
