package com.example.attendance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;


public class attendancedatabase{
    private SQLiteDatabase sql;
    public  attendancedatabase (SQLiteDatabase sql){
        this.sql=sql;
    }
    public  void  createTable(){
        //sql.execSQL("create table if not exists courses (i)");
        sql.execSQL("create table if not exists attendance(Attendance_Id integer primary Key autoincrement, "
                +" Attendance_status Text not null ,Attendance_Date DATE  ,Year Text ,Student_ID integer )");

    }
    public void insertattendance( String Attendance_status, int Student_ID , Date Attendance_Date, String Year){
        sql.execSQL("insert into attendance values('"+Attendance_status+"','"+Student_ID+"','"+Attendance_Date+"','"+Year+"')");


    }


    public ArrayList<String> ReturnAnAttendance(int student_ID){
        ArrayList<String> arr=new ArrayList<String>();
        Cursor cursor=sql.rawQuery("select Attendance_ID,Attendance_status,Attendance_Date,Year  from attendance where Student_ID='"+student_ID+"'",null);
        if(cursor.getCount() >0){

            while (cursor.moveToNext()){

                arr.add(String.valueOf(cursor.getString(0)));
                arr.add(cursor.getString(1));
                arr.add(cursor.getString(2));
                arr.add(cursor.getString(3));
                arr.add(String.valueOf(cursor.getString(2)));

            }
        }
        cursor.close();
        return arr;

    }
    public ArrayList<String>getAll(){
        ArrayList<String>arr= new ArrayList<>();
        Cursor cursor=sql.rawQuery("select Attendance_ID,Attendance_status,Attendance_Date,Year  from attendance ",null);
        if(cursor.getCount() >0){
            while (cursor.moveToNext()){

                arr.add(String.valueOf(cursor.getString(0)));
                arr.add(cursor.getString(1));
                arr.add(cursor.getString(2));
                arr.add(cursor.getString(3));
            }
        }
        cursor.close();
        return arr;
    }
}

/*
public class attendancedatabase extends SQLiteOpenHelper {
    private static String DatabaseName  = "AttendanceDataBase";
    SQLiteDatabase attendancedatabase;

    public attendancedatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create  table  if not exists Attendance (attendance_id integer primary key," + " student_id integer foreign key, " +" attendance_status text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Attendance");
        onCreate(sqLiteDatabase);

    }

    public void createnewattendance (String name , String )
}
*/
