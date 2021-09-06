package com.example.attendance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class admin extends AppCompatActivity {

    private ImageButton date;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    private EditText dateEditText;
    Button addattendance, viewTotalAttendance;
    Spinner spinneryear,spinnercourse;
    public static String COURSe = "";
    public static String yearr = "";
    public static String datee = "";

    ArrayList<String> Arr;

    attendancedatabase attendanceDB;
    coursedatabase CourDB;
    SQLiteDatabase sql;
    course courseobj;
    student studentobj;
    attendance attendanceobj;




    private String[] yearString = new String[] {"First year","Second Year","Third Year"};
    private String[] courseString = new String[] {"File","OOP","Math4","OR","Statistics","Ethics"};


    //private String[] subjectFinal = new String[] {"M3","DS","M4","CN","M5","NS"};
    //AttendanceSessionBean attendanceSessionBean;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        sql=openOrCreateDatabase("test",0,null);
        attendanceDB = new attendancedatabase(sql);
        Toast.makeText(getApplicationContext(),"I am hereeeeeeeee",Toast.LENGTH_LONG).show();

        spinnercourse = findViewById(R.id.spinn1);
        spinneryear = findViewById(R.id.spinn2);
        addattendance = findViewById(R.id.addattenbtn);
        viewTotalAttendance = findViewById(R.id.totalattenbtn);


        studentobj = new student();
        //Arr= attendanceDB.ReturnAnAttendance(s);
       /* ID.setText(arr.get(0));
        Name.setText(arr.get(1));
        cridethours.setText(arr.get(2));
        bookTitle.setText(arr.get(3));*/

        addattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(admin.this ,ViewStudents.class);
                ii.putExtra("The Year" , spinneryear.getSelectedItem().toString());
                ii.putExtra("Date" ,dateEditText.getText());
                ii.putExtra("COURSE", spinnercourse.getSelectedItem().toString());
                startActivity(ii);






            }
        });




        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////spinner1
        CourDB =new coursedatabase(sql);
        Arr = CourDB.getAll();
        ArrayAdapter<String> adaptercourse = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Arr);
        adaptercourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercourse.setAdapter(adaptercourse);


        spinnercourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                COURSe =(String) spinnercourse.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });





        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////spinner2
        ArrayAdapter<String> yearadapter =new ArrayAdapter<String>(this ,android.R.layout.simple_spinner_item, yearString);
        yearadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinneryear.setAdapter(yearadapter);

        spinneryear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                yearr =(String) spinneryear.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {



            }
        });


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////dateButton

        date = findViewById(R.id.btncalen);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        dateEditText = findViewById(R.id.edittxtcal);
        datee =dateEditText.getText().toString();

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(0);
            }
        });




        /////////////////////////////////////////////////////////////////////////////////////////////////////TotalAttendanceButton
        viewTotalAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(admin.this, ViewTotalAttendance.class);
                startActivity(i);

            }
        });





    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // return super.onCreateDialog(id);
        return new DatePickerDialog(this , datePickerListener ,year, month ,day);

    }
    private DatePickerDialog.OnDateSetListener datePickerListener =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dateEditText.setText(i2 + "/" + (i1+1) +"/" + i );

        }
    };




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////BackButton


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("You Want EXIT ? ").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }





}



    /*public void checkButton(View view)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radiobutton =findViewById(radioId);

        if(radiobutton.getText().toString()== "admin") {

            Toast.makeText(getApplicationContext(), "You 're : " +radiobutton.getText() ,Toast.LENGTH_SHORT).show();
            Intent n = new Intent(MainActivity.this, admin.class);
            startActivity(n);


        }
        else if (radiobutton.getText()== "student")
        {
            Toast.makeText(getApplicationContext(), "You 're : " + radiobutton.getText() ,Toast.LENGTH_SHORT).show();
            //finish();

        }
        else
            Toast.makeText(getApplicationContext(), "Heeeeeeeeey"  ,Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(), "I am Here ........." +radiobutton.getText() ,Toast.LENGTH_SHORT).show();


    }*/