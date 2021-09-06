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

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {
    Button buttonAdd,buttonStu,buttonlogin;
    ListView list;
    TextView text;
    SQLiteDatabase sql;

    coursedatabase Course;
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        sql=openOrCreateDatabase("test",0,null);
        Course = new coursedatabase(sql);
        Toast.makeText(getApplicationContext(),"I am here",Toast.LENGTH_LONG).show();

        buttonAdd = findViewById(R.id.addcoursebtn);
       /* buttonStu= findViewById(R.id.stdbtn);
        buttonlogin= findViewById(R.id.loginbtn);*/
        list= findViewById(R.id.listview);

        ArrayAdapter<String> add= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Course.getAll());

        list.setAdapter(add);
        ArrayAdapter<String> adapter= (ArrayAdapter<String>) list.getAdapter();
        adapter.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ViewCourses.this,CourseDetails.class);
                intent.putExtra("x",((TextView)view).getText().toString());
                startActivity(intent);

            }


        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"I am here",Toast.LENGTH_LONG).show();
                Intent i =new Intent(ViewCourses.this,AddCourse.class);
                startActivity(i);
            }
        });
      /*  buttonStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ViewCourses.this,ViewStudents2.class);
                startActivity(i);
            }
        });
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ViewCourses.this,Login.class);
                startActivity(i);
            }
        });
*/
    }
}

