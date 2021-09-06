package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Teststatus extends AppCompatActivity {


    SQLiteDatabase Sql;
    Studentdatabase StuDB;
    attendancedatabase AttenDB;
    admin a= new admin();



    attendance attendance2;
    student student2;
    course course2;
    String status = "";
    Button attendanceSubmit;
    RadioButton present, absent;
    RadioGroup radioGroupp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teststatus);

        Sql = openOrCreateDatabase("test", 0, null);
        StuDB = new Studentdatabase(Sql);
        attendance2 = new attendance();
        student2 = new student();
        course2 = new course();




        attendanceSubmit = findViewById(R.id.btnsubmit);
        radioGroupp = findViewById(R.id.radigrbbtn);

        radioGroupp = findViewById(R.id.radigrbbtn);
        present = findViewById(R.id.radiobtn1);
        absent = findViewById(R.id.radiobtn2);

        radioGroupp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radiobtn1) {

                    status = "Present";
                } else if (checkedId == R.id.radiobtn2) {

                    status = "Absent";
                } else {
                }
            }
        });

        attendanceSubmit = findViewById(R.id.btnsubmit);
        attendanceSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent intent = getIntent();
                String StdName = intent.getExtras().getString("StdName");

                AttenDB.createTable();

              // a.COURSe="b";
               course2.setCourse_Name(a.COURSe);


                student2.setName(StdName);


                attendance2.setStudent_id(student2.getID());
                attendance2.setAttendance_status(status);
                attendance2.setDate(stringToDate(a.datee, "yyyy-MM-dd"));
                attendance2.setYear(a.yearr);
                attendance2.setCourseobj(course2);

                Toast.makeText(getApplicationContext()," ID : "+student2.getID()+a.yearr +status+a.COURSe+"The date"+ stringToDate(a.datee, "yyyy-MM-dd") ,Toast.LENGTH_LONG).show();

                AttenDB.insertattendance(status,student2.getID(), stringToDate(a.datee, "yyyy/MM/dd"), a.yearr);
               // dialog.dismiss();

            }
        });

      //  dialog.setCancelable(true);
       // dialog.show();

                /*Intent intent =new Intent(StudentActivity.this,ViewStudent.class);
                intent.putExtra("x",((TextView)view).getText().toString());
                startActivity(intent);*/

    }


    public Date stringToDate(String aDate, String aFormat) {

        if(aDate==null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(aFormat);
        Date stringDate = simpledateformat.parse(aDate, pos);
        return stringDate;

    }


}

