package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewStudents extends AppCompatActivity {


    SQLiteDatabase sql;
    Studentdatabase studentDB;
    attendancedatabase attendanceDB;


    ListView listView1 ;
    ArrayAdapter<String> listAdapter1;
    ArrayList<String> arraylist1;
    attendance attendance1;
    student student1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);


        sql=openOrCreateDatabase("test",0,null);
        studentDB =new Studentdatabase(sql);
        attendance1 = new attendance();
        student1 = new student();





        studentDB.createTable();
        listView1 = findViewById(R.id.lstviewstd);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,studentDB.getAllStudent());
        arraylist1 = studentDB.getAllStudent();


        listView1.setAdapter(adapter1);
        ArrayAdapter<String>adapter= (ArrayAdapter<String>) listView1.getAdapter();//////////////////////////////////////////////////88888888/
        adapter.notifyDataSetChanged();
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),"STUDENT Name : "+((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
                Intent intent1 =new Intent(ViewStudents.this, Teststatus.class);
                intent1.putExtra("StdName", ((TextView)view).getText().toString());
                startActivity(intent1);




                /*adapterView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                //arg0.setBackgroundColor(234567);
                view.setBackgroundColor(Color.blue(0));
                final Dialog dialog = new Dialog(ViewStudents.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//...........
                dialog.setContentView(R.layout.activity_teststatus);

                radioGroup = dialog.findViewById(R.id.radigrbbtn);
                present = dialog.findViewById(R.id.radiobtn1);
                absent = dialog.findViewById(R.id.radiobtn2);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.radiobtn1) {

                            status = "Present";
                        } else if(checkedId == R.id.radiobtn2) {

                            status = "Absent";
                        } else {
                        }
                    }
                });*/



                /*attendanceSubmit = dialog.findViewById(R.id.btnsubmit);
                attendanceSubmit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        attenDB.createTable();


                        attendance.setAttendance_status(status);
                        attendance.setStudent_id(stdName.getID());
                        attendance.setAttendance_status(status);
                        attendance.setDate( stringToDate(date,"yyyy-MM-dd" ));
                        attendance.setYear(yearr);

                       attenDB.insertattendance(status ,stdName.getID() ,stringToDate(date, "yyyy/MM/dd") ,yearr);
                        dialog.dismiss();

                    }
                });*/


                //dialog.setCancelable(true);
                //dialog.show();

                /*Intent intent =new Intent(StudentActivity.this,ViewStudent.class);
                intent.putExtra("x",((TextView)view).getText().toString());
                startActivity(intent);*/

            }


        });



       /* buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"the student isn;;llllllllllllllllllllllllll added",Toast.LENGTH_LONG).show();

                Intent intent =new Intent(StudentActivity.this,addStudent.class);
                startActivity(intent);
            }
        });*/
    }

    public Date stringToDate(String aDate,String aFormat) {

        if(aDate==null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(aFormat);
        Date stringDate = simpledateformat.parse(aDate, pos);
        return stringDate;

    }
}


