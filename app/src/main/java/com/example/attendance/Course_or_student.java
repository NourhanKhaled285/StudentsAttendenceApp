package com.example.attendance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Course_or_student extends Activity {
Button c;
Button s,a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course_or_student);


		c= findViewById(R.id.button_go_cou);
		s= findViewById(R.id.button_g0_stu);
		a =findViewById(R.id.attbtnnn);

		c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Course_or_student.this,AddCourse.class);
				startActivity(intent);
				
			}
		});
		s.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent(Course_or_student.this,AddStudent.class);
				startActivity(intent);
			}
		});

		a.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i =new Intent(Course_or_student.this, admin.class);
				startActivity(i);
			}
		});
	}



}
