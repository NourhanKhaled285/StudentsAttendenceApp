package com.example.attendance;

import java.util.Date;

public class student {
    private  int ID;
    private String Name;
    private String Birthdate;
    private int age;
    private String Password;
    private  String Email;
    private course Stu_course;

    public void setID(int value){
        ID=value;
    }
    public void setName(String value){
        Name=value;
    }
    public void setBirthdate(String value){ Birthdate=value; }
    public void setAge(int value){
        age=value;
    }
    public void setStu_course(course stu_course) {
        this.Stu_course = stu_course;
    }
    public void setPassword(String value){ Password=value; }
    public void setEmail(String value){ Email=value; }

    public int getID(){
        return ID;
    }
    public int getAge(){
        return age;
    }
    public  String getName(){
        return Name;
    }
    public String getBirthdate(){
        return Birthdate;
    }
    public  course getStu_course(){
        return Stu_course;
    }
    public String getPassword(){return Password;}
    public String getEmail(){return Email;}
}
