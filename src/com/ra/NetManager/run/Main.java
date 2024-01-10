package com.ra.NetManager.run;

import com.ra.NetManager.entity.AdditionalService;
import com.ra.NetManager.entity.Computer;

public class Main {
    public static void main(String[] args) {
        GamingNet.computers.add(new Computer("1","10/01/2024, 12:00:00",true));
        GamingNet.computers.add(new Computer("2","8/12/2023, 8:00:00",false));
        GamingNet.computers.add(new Computer("3","10/01/2024, 22:00:00",false));
        GamingNet.computers.add(new Computer("4","24/12/2023, 15:00:00",true));
        GamingNet.computers.add(new Computer("5","8/01/2024, 18:00:00",true));
        AdditionalMenu.addServiceToMenu(new AdditionalService("1","Bánh mì trứng",1500));
        AdditionalMenu.addServiceToMenu(new AdditionalService("2","Sting",1200));
        AdditionalMenu.addServiceToMenu(new AdditionalService("3","Mì trứng",20000));
        /*AdditionalMenu.addServiceToMenu(new AdditionalService("4","Xôi",10000));
        AdditionalMenu.addServiceToMenu(new AdditionalService("5","Cháo",17000));*/
        GamingNet.menu();
    }
}
