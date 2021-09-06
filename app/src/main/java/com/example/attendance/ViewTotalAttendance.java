package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewTotalAttendance extends AppCompatActivity {

    ListView lst;
    SQLiteDatabase sql;
    EditText idtext;

    attendancedatabase attendancee;
    ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_total_attendance);

        lst = findViewById(R.id.lstviewattendance);
        idtext = findViewById(R.id.editText9);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attendancee.ReturnAnAttendance(Integer.parseInt(idtext.getText().toString()))
        );

        sql = openOrCreateDatabase("test", 0, null);
        attendancee = new attendancedatabase(sql);

        lst.setAdapter(adapter1);
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) lst.getAdapter();
        adapter.notifyDataSetChanged();


    }

    public boolean checkID(String id) {
         SQLiteDatabase db=this.openOrCreateDatabase("Student1",MODE_PRIVATE,null);

        Cursor cursor = db.rawQuery("select * from Student1 where id=?", new String[]{id});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;


    }
}