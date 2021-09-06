package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCourse extends AppCompatActivity {

    SQLiteDatabase sql;
    Button button,buttonback;
    EditText courseID,couresName,courseCridethours,coursebookTitle;
    coursedatabase course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        sql=openOrCreateDatabase("test",0,null);

        courseID= findViewById(R.id.editText);
        couresName= findViewById(R.id.editText2);
        courseCridethours= findViewById(R.id.editText3);
        coursebookTitle= findViewById(R.id.editText4);

        button= findViewById(R.id.buttonadd);
        buttonback= findViewById(R.id.buttonback);


        course=new coursedatabase(sql);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                course.createTable();

                course.insertcourse(Integer.valueOf(courseID.getText().toString()),couresName.getText().toString(), coursebookTitle.getText().toString(),Integer.valueOf(courseCridethours.getText().toString()));

                Toast.makeText(getApplicationContext(),"the course is added",Toast.LENGTH_LONG).show();

            }
        });
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(AddCourse.this,ViewCourses.class);
                startActivity(i);
            }
        });

    }



}

