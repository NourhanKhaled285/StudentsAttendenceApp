package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseDetails extends AppCompatActivity {

    Button buttonDelete,buttonUpdate,buttonback;
    EditText ID,Name,cridethours,bookTitle;
    ArrayList<String> arr;

    SQLiteDatabase sql;
    coursedatabase courseDB;

    course coursee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        buttonDelete= findViewById(R.id.deletebtncourse);
        buttonUpdate= findViewById(R.id.updatebtn);
        buttonback= findViewById(R.id.btnback2);

        ID= findViewById(R.id.editText5);
        Name= findViewById(R.id.editText6);
        cridethours= findViewById(R.id.editText7);
        bookTitle= findViewById(R.id.editText8);


        Intent intent=getIntent();
        String s=intent.getExtras().getString("x");


        sql=openOrCreateDatabase("test",0,null);
        courseDB=new coursedatabase(sql);


        arr= courseDB.returnSelectedcourse(s);
        ID.setText(arr.get(0));
        Name.setText(arr.get(1));
        cridethours.setText(arr.get(2));
        bookTitle.setText(arr.get(3));

        //course=new courses();
//course.setCourse_ID(Integer.valueOf(ID.getText().toString()));
//course.setCourse_Name(Name.getText().toString());
//course.setCourse_Credit_hours(Integer.valueOf(cridethours.getText().toString()));
//course.setCourse_book_title(bookTitle.getText().toString());

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseDB.deletecourse(Name.getText().toString());
                Toast.makeText(getApplicationContext(),"the course is deleted",Toast.LENGTH_LONG).show();

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                coursee =new course();
                coursee.setCourse_ID(Integer.valueOf(ID.getText().toString()));
                coursee.setCourse_Name(Name.getText().toString());
                coursee.setCourse_Credit_hours(Integer.valueOf(cridethours.getText().toString()));
                coursee.setCourse_book_title(bookTitle.getText().toString());

                courseDB.UpdateCourse(coursee.getCourse_ID(),coursee.getCourse_Name(),coursee.getCourse_Credit_hours(),coursee.getCourse_book_title(),Integer.valueOf(arr.get(0)));
                //courseDB.UpdateCourse(Integer.valueOf(ID.getText().toString()),Name.getText().toString(),Integer.valueOf(cridethours.getText().toString()),bookTitle.getText().toString());

                Toast.makeText(getApplicationContext(),"the course is updated",Toast.LENGTH_LONG).show();

            }
        });

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CourseDetails.this,ViewCourses.class);
                startActivity(intent);
            }
        });
    }

}
