package com.example.unityHR.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class EmployeeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public EmployeeTypes(){

    }


    public EmployeeTypes(int id,String name){
        this.id= id;
        this.name= name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    @Override
    public String toString() {
        return "EmployeeTypes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}



