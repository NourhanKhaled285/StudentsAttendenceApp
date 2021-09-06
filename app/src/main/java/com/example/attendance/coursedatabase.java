package com.example.attendance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class coursedatabase {
    private SQLiteDatabase sql;
    public  coursedatabase (SQLiteDatabase sql){
        this.sql=sql;
    }
    public  void  createTable(){
        //sql.execSQL("create table if not exists courses (i)");
        sql.execSQL("create table if not exists courses(Course_ID integer primary Key "+
                ",Course_Name Text not null,Course_book_title Text,Course_Credit_hours integer )");

    }
    public void insertcourse(int ID,String Course_Name,String Course_book_title,int Course_Credit_hours ){
        sql.execSQL("insert into courses values('"+ID+"','"+Course_Name+"','"+Course_book_title+"','"+Course_Credit_hours+"')");


    }
    public void deletecourse(String Name){
        sql.execSQL("delete from courses where Course_Name='"+Name+"'");
        //sql.delete(courses,Course_ID=Name,)
    }
    public void UpdateCourse(int id,String Name,int cridethours,String bookTitle,int oldID){

        sql.execSQL("update courses set Course_ID="+id+",Course_Name='"+Name+"',Course_Credit_hours="+cridethours+",Course_book_title='"+bookTitle+"'  where Course_ID="+oldID+" ");
//sql.execSQL("update courses set Course_Name='"+Name+"' where Course_ID="+id+" ");

    }
    public ArrayList<String> returnSelectedcourse(String Name){
        ArrayList<String> arr=new ArrayList<String>();
        Cursor cursor=sql.rawQuery("select Course_ID,Course_Name,Course_Credit_hours,Course_book_title  from courses where Course_Name='"+Name+"'",null);
        if(cursor.getCount() >0){

            while (cursor.moveToNext()){

                arr.add(String.valueOf(cursor.getString(0)));
                arr.add(cursor.getString(1));
                arr.add(String.valueOf(cursor.getString(2)));
                arr.add(cursor.getString(3));
            }
        }
        cursor.close();
        return arr;

    }
    public ArrayList<String>getAll(){
        ArrayList<String>arr=new ArrayList<String>();
        Cursor cursor=sql.rawQuery("select Course_Name from courses ",null);
        if(cursor.getCount() >0){
            //cursor.moveToFirst();
            while (cursor.moveToNext()){

                arr.add(cursor.getString(0));
            }
        }
        cursor.close();
        return arr;
    }
    /*public Boolean findcourse(String NameCourse){
        Boolean flage=false;
        ArrayList<String>arr=getAll();
        for(int i=0;i<3;i++){
            if(arr.get(i)==NameCourse)
            flage=true;
        }
          return  flage;
    }*/
}
