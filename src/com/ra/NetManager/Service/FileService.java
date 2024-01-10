package com.ra.NetManager.Service;

import java.util.List;

public interface FileService<C> {
    List<C> readFromFile();
    void writeToFile(List<C> list);
}
