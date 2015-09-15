package com.example.pankaj.contentprovider2015.net.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Pankaj on 9/14/2015.
 */
public class SearializeObject {
    public static void main(String[] args) {
        Employee employee = new Employee(1,"pankaj","344567778","ranchi");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("objser.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        try{
            FileInputStream fileInputStream = new FileInputStream("objser.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Employee employee1 = (Employee)objectInputStream.readObject();

        }
        catch (Exception ex){

        }

    }
}
