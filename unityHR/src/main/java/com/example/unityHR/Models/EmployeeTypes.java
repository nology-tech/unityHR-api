package com.example.unityHR.Models;

public class EmployeeTypes {
    private String id;
    private String name;

    public EmployeeTypes(String id,String name){
        this.id= id;
        this.name= name;
    }

    public String getId(){
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



