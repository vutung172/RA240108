package com.ra.NetManager.Service.ServiceImpl;

import com.ra.NetManager.Service.FileService;

import java.io.*;
import java.util.List;

public class FileServiceImpl<C> implements FileService<C> {

    @Override
    public List<C> readFromFile() {
        try{
            File file = new File("data.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<C> list = (List<C>) ois.readObject();
            ois.close();
            fis.close();
            return list;
        } catch (FileNotFoundException fnfe){
            fnfe.getStackTrace();
        } catch (IOException ioe) {
            ioe.getStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.getStackTrace();
        } catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public void writeToFile(List<C> list) {
        try{
            File file = new File("data.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException fnfe){
            fnfe.getStackTrace();
        } catch (IOException ioe) {
            ioe.getStackTrace();
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
