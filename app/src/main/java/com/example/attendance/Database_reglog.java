package com.example.attendance;

import java.net.PasswordAuthentication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_reglog extends SQLiteOpenHelper {
	public static final String database_name="register.db";
	public static final String table_name="register";
	public static final String col_1="ID";
	public static final String col_2= "FirstName";
	public static final String col_3="LastName";
	public static final String col_4="Password";
	public static final String col_5= "Email";
	public static final String col_6="Phone";
	public  Database_reglog(Context context) {
		super(context,database_name,null,1);
			
	}

	

	@Override
	public void onCreate(SQLiteDatabase db) {
	  db.execSQL("CREATE TABLE " + table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		db.execSQL("DROP TABLE IF EXISTS " +table_name);
		onCreate(db);
		
	}
	

}

