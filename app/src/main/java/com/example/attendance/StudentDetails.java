package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {

    Button buttonDelete,buttonUpdate,buttonback;
    EditText ID,Name,Birthdate,age,password,email;
    ArrayList<String> arr;
    Spinner spinner;
    SQLiteDatabase sql;
    Studentdatabase stuDB;
    coursedatabase courseDB;
    course cour;
    student stu;
    Boolean flage=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        buttonDelete= findViewById(R.id.deletebtnstudent);
        buttonUpdate= findViewById(R.id.updatebtnstudent);
        buttonback= findViewById(R.id.backbtnstudent);
//spinner=(Spinner)findViewById(R.id.spinner2);

        ID= findViewById(R.id.editText11);
        Name= findViewById(R.id.editText12);
        Birthdate= findViewById(R.id.editText13);
        age= findViewById(R.id.editText14);
        password= findViewById(R.id.editText15);
        email=(EditText)findViewById(R.id.editText16);

        stu=new student();
        sql=openOrCreateDatabase("test",0,null);
        stuDB=new Studentdatabase(sql);
        Intent inttent=getIntent();
        String s=inttent.getExtras().getString("x");

        cour=new course();
        courseDB=new coursedatabase(sql);
        arr= stuDB.returnSelectedstudent(s);
        ID.setText(arr.get(0));
        Name.setText(arr.get(1));
        Birthdate.setText(arr.get(3));
        age.setText(arr.get(2));
        password.setText(arr.get(4));
        email.setText(arr.get(5));
        /*arr=courseDB.getAll();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int ids=spinner.getSelectedItemPosition();
                if(ids==i){
                    courseName.setText( spinner.getSelectedItem().toString());
                    Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(StudentDetails.this,ViewStudents2.class);
                startActivity(intent);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stuDB.deletestudent(Integer.valueOf(ID.getText().toString()));

                Toast.makeText(getApplicationContext(),"the student is deleted",Toast.LENGTH_LONG).show();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<String>arr=courseDB.getAll();
                // for(int i=0;i<4;i++){
                // if(arr.get(i)==courseName.getText().toString()) {
                // flage = true;
                //Toast.makeText(getApplicationContext(),arr.get(i) , Toast.LENGTH_LONG).show();

                // }


                stu.setID(Integer.valueOf(ID.getText().toString()));
                stu.setName(Name.getText().toString());
                stu.setBirthdate(Birthdate.getText().toString());
                stu.setAge(Integer.valueOf(age.getText().toString()));
                stu.setPassword(password.getText().toString());
                stu.setEmail(email.getText().toString());
                stuDB.Updatestudent(stu.getID(), stu.getName(), stu.getAge(), stu.getBirthdate(),stu.getPassword(),stu.getEmail());
                Toast.makeText(getApplicationContext(), "the student is Updated", Toast.LENGTH_LONG).show();


            }
        });







    }
}
