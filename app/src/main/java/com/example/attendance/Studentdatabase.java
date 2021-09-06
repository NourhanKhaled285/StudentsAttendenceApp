package com.example.attendance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

public class Studentdatabase {

    private SQLiteDatabase sql;

    public Studentdatabase(SQLiteDatabase sql) {
        this.sql = sql;
    }

    public void createTable() {
        //sql.execSQL("create table if not exists courses (i)");
        sql.execSQL("create table if not exists Student1(Stu_ID integer primary Key autoincrement" +
                ",Stu_Name Text not null,Stu_Birthdate Text,Stu_age integer,Stu_Password Text,Stu_Email Text )");

    }

    public void insertstudent(String Name, String Birthdate, int age, String password, String email) {
        sql.execSQL("insert into Student1( Stu_Name ,Stu_Birthdate ,Stu_age ,Stu_Password ,Stu_Email  ) values('" + Name + "','" + Birthdate + "','" + age + "','" + password + "','" + email + "')");


    }

    public void deletestudent(int id) {
        sql.execSQL("delete from Student1 where Stu_ID=" + id + "");
    }

    public void Updatestudent(int id, String Name, int age, String Birthdate, String password, String email) {

        sql.execSQL("update Student1 set Stu_Name='" + Name + "',Stu_age=" + age + ",Stu_Birthdate='" + Birthdate + "',Stu_Password='" + password + "',Stu_Email='" + email + "'  where Stu_ID=" + id + " ");

    }

    public ArrayList<String> returnSelectedstudent(String Name) {
        ArrayList<String> arr = new ArrayList<String>();
        Cursor cursor = sql.rawQuery("select Stu_ID,Stu_Name,Stu_age,Stu_Birthdate,Stu_Password,Stu_Email  from Student1 where Stu_Name='" + Name + "'", null);
        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                arr.add(String.valueOf(cursor.getString(0)));
                arr.add(cursor.getString(1));
                arr.add(String.valueOf(cursor.getString(2)));
                arr.add(cursor.getString(3));
                arr.add(cursor.getString(4));
                arr.add(cursor.getString(5));

            }
        }
        cursor.close();
        return arr;

    }

    public ArrayList<String> getAllStudent() {
        ArrayList<String> arr = new ArrayList<String>();
        Cursor cursor = sql.rawQuery("select Stu_Name  from Student1", null);
        if (cursor.getCount() > 0) {
            //cursor.moveToFirst();
            while (cursor.moveToNext()) {

                arr.add(cursor.getString(0));
            }
        }
        cursor.close();
        return arr;
    }

    public Boolean findStudent(String password, String email) {

        ArrayList<String> arr = new ArrayList<String>();
        Cursor cursor = sql.rawQuery("select Stu_Password ,Stu_Email from  Student1", null);

        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                if (cursor.getString(0).equals( password) &&cursor.getString(1).equals(email)) {
                    cursor.close();
                    return true;
                }
            }



        }
        cursor.close();
        return false;
    }

}

