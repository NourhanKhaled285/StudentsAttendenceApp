package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewStudents2 extends AppCompatActivity {
    Button buttonAdd;
    ListView list;
    TextView text;
    SQLiteDatabase sql;
    Studentdatabase stuDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students2);

        sql=openOrCreateDatabase("test",0,null);
        stuDB=new Studentdatabase(sql);

        buttonAdd = findViewById(R.id.addstdbtn);

        stuDB.createTable();
        list= findViewById(R.id.listview1);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stuDB.getAllStudent());

        list.setAdapter(adapter1);
        ArrayAdapter<String>adapter= (ArrayAdapter<String>) list.getAdapter();
        adapter.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ViewStudents2.this,StudentDetails.class);
                intent.putExtra("x",((TextView)view).getText().toString());
                startActivity(intent);

            }


        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(ViewStudents2.this,AddStudent.class);
                startActivity(intent);
            }
        });
    }

}
