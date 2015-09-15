package com.example.pankaj.contentprovider2015.net.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Created by Pankaj on 9/14/2015.
 */
public class MyFile {
    private File dirName, fileName;//To create director and file
    private FileWriter fileWriter;//To write date to file
    private FileReader fileReader;//To Read data from file
    private BufferedReader rdfcon;//To Read data from Console or dos
    private BufferedReader rdffile;//To Read data from file
    ModalBean bean;

    public MyFile() {
        rdfcon = new BufferedReader(new InputStreamReader(System.in));
        createFileFolder();
    }

    public void createFileFolder() {
        dirName = new File("dataDir");
        //To create directory
        if (dirName.mkdirs()) { //if directory create will return true else false. Directory will create in currently working directory
            System.out.println("Director created");
        } else {
            System.out.println("Director all ready exists");
        }
        //To create File.
        fileName = new File(dirName, "dataFile");//file will be created in current
        if (!fileName.exists()) {
            try {
                fileName.createNewFile();
                System.out.println("File created");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } else {
            System.out.println("File already exits");
        }
    }

    /**
     * This method will get data from console and set the value to bean
     */
    public void getData() {
        bean = new ModalBean();
        try {
            System.out.print("Enter Id:- \t");
            bean.setId(Integer.parseInt(rdfcon.readLine()));
            System.out.print("Enter Name:- \t");
            bean.setName(rdfcon.readLine());
            System.out.print("Enter Mobile:- \t");
            bean.setMobile(rdfcon.readLine());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * This method will write the data to file
     */
    public void witeDataToFile() {
        try {
            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(bean.getId() + "\t");
            fileWriter.write(bean.getName() + "\t");
            fileWriter.write(bean.getMobile() + "\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("All Data Save");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void displayData() {
        try {
            fileReader = new FileReader(fileName);
            rdffile = new BufferedReader(fileReader);
            String data = rdffile.readLine();
            do {
                System.out.println(data);
                data = rdffile.readLine();
            } while (data != null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void readDataCharacterStream(){
        try{
            FileReader fileReader = new FileReader(fileName);
            fileReader.read();
        }catch (Exception ex){}

    }

    public static void main(String[] args) {
        MyFile myFile = new MyFile();
        System.out.println("-----------------Menu----------------");
        System.out.println("1.Write data to file");
        System.out.println("2.Display data from file");
        System.out.println("3.Exit");
        System.out.println("-------------------------------------");


        try {
            System.out.println("Enter your choice");
            int ch = Integer.parseInt(myFile.rdfcon.readLine());
            do {
                switch (ch) {
                    case 1:
                        myFile.getData();
                        myFile.witeDataToFile();
                        break;
                    case 2:
                        myFile.displayData();
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                System.out.println("-----------------Menu----------------");
                System.out.println("1.Write data to file");
                System.out.println("2.Display data from file");
                System.out.println("3.Exit");
                System.out.println("-------------------------------------");
                System.out.println("Enter your choice");
                ch = Integer.parseInt(myFile.rdfcon.readLine());
            } while (ch == 1 || ch == 2);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
