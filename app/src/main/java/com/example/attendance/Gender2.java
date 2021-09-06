package com.example.attendance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Gender2 extends Activity {
      RadioGroup radioGroup;
      RadioButton admin, student;
      Button go;
     public static int radio_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gender2);
		
		
		radioGroup =(RadioGroup)findViewById(R.id.radioGroup1);
		
		
		admin=(RadioButton) findViewById(R.id.radio0);
		student=(RadioButton) findViewById(R.id.radio1);
		
		 radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	            	radio_id=checkedId;
	                if (checkedId == R.id.radio0) {
	                	Intent i= new Intent(Gender2.this, Login.class);
	                	startActivity(i);


	                } else if (checkedId == R.id.radio1) {

	                	Intent i= new Intent(Gender2.this, Register.class);
	                	startActivity(i);
	                	
	                } else {
	                	Toast.makeText(getApplicationContext()," Please select !",Toast.LENGTH_LONG).show();
	                }
	            }
	        });
		
		
	}



}
