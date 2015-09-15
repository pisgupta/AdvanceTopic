package com.example.pankaj.contentprovider2015.net.file;

import java.io.Serializable;

/**
 * Created by Pankaj on 9/14/2015.
 */
public class Employee implements Serializable {
    private int id;
    private String name;
    private String mobile;
    transient String address;//this value will not serialized
    public Employee(int id,String name,String mobile,String address) {
        this.id=id;
        this.name=name;
        this.mobile=mobile;
        this.address=address;
    }

}
