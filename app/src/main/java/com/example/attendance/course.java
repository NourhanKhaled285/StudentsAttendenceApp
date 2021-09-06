package com.example.attendance;

public class course {
    private int Course_ID;
    private String Course_Name;
    private int Course_Credit_hours;
    private String Course_book_title;

    public void  setCourse_ID(int value){
        Course_ID=value;

    }
    public void  setCourse_Credit_hours(int value){
        Course_Credit_hours=value;

    }
    public void  setCourse_Name(String value){
        Course_Name=value;

    }
    public void  setCourse_book_title(String value){
        Course_book_title=value;

    }
    public int getCourse_ID(){

        return Course_ID;
    }
    public int getCourse_Credit_hours(){

        return Course_Credit_hours;
    }
    public String getCourse_Name(){

        return Course_Name;
    }
    public String getCourse_book_title(){

        return Course_book_title;
    }


}
