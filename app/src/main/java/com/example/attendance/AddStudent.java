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

public class AddStudent extends AppCompatActivity {

    Button buttonAdd,buttonback;
    EditText Name,Age,Birthdate,Email,password;
    SQLiteDatabase sql;
    Studentdatabase StuDB;
    coursedatabase CourDB;
    student stu;
    //Spinner spinner;
    ArrayList<String> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        sql=openOrCreateDatabase("test",0,null);
        StuDB=new Studentdatabase(sql);
        stu=new student();
        CourDB=new coursedatabase(sql);

        buttonAdd= findViewById(R.id.addstdbtn2);
        buttonback= findViewById(R.id.backbtnstudent2);

        Name= findViewById(R.id.editText17);
        Birthdate= findViewById(R.id.editText18);
        Age= findViewById(R.id.editText19);

        password= findViewById(R.id.editText20);
        Email= findViewById(R.id.editText21);

        //spinner=(Spinner)findViewById(R.id.spinner);

        /*arr=CourDB.getAll();
                final ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"the student isn;;llllllllllllllllllllllllll added",Toast.LENGTH_LONG).show();

                stu.setName(Name.getText().toString());
                stu.setBirthdate(Birthdate.getText().toString());
                stu.setAge(Integer.valueOf(Age.getText().toString()));
                stu.setEmail(Email.getText().toString());
                stu.setPassword(password.getText().toString());

                StuDB.createTable();
                StuDB.insertstudent(stu.getName(),stu.getBirthdate(),stu.getAge(),stu.getPassword(),stu.getEmail());
                Toast.makeText(getApplicationContext(),"the student is added",Toast.LENGTH_LONG).show();
            }
        });
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddStudent.this,ViewStudents2.class);
                startActivity(intent);
            }
        });
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int ids=spinner.getSelectedItemPosition();
                if(ids==i){
                    Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

    }
}
