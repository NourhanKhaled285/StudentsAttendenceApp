package com.example.attendance;



import com.example.attendance.Database_reglog;
import com.example.attendance.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {


		Button login;

		
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);




		final SQLiteOpenHelper openhelp;
		openhelp =new Database_reglog(this);
		
		
		login = findViewById(R.id.button_log);
		
		login.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				//RadioButton r1=(RadioButton)findViewById(R.id.radioButton1);
				//RadioButton r2=(RadioButton)findViewById(R.id.radioButton2);
			 SQLiteDatabase db;

			     db=openhelp.getReadableDatabase();
				 EditText em;
				 EditText pass;
				 Cursor cursor;
				 em=(EditText)findViewById(R.id.editText_em);
				 pass=(EditText)findViewById(R.id.editText_pas);
				 
				 String e=em.getText().toString();
				 String p=pass.getText().toString();
				
				// Gender gen=new Gender();

				Gender2 gen=new Gender2();
				  //  if(gen.r1.isChecked() ){
				   if(gen.radio_id==R.id.radio0 ){
				 
			                if(e.equals("admin")&&p.equals("123")){
				   
				                 Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();
				                 Intent i=new Intent(Login.this, Course_or_student.class);
			                     startActivity(i);
                                 }
			             else{
				            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
			                 }
				    }
		 
						    
				   //else if(gen.r2.isChecked()){
				    else if(gen.radio_id==R.id.radio1){
				   
				  cursor=db.rawQuery("SELECT * FROM "+ Database_reglog.table_name + " WHERE " + Database_reglog.col_5 + "=? AND "+ Database_reglog.col_4 + "=?", new String[]{e,p});
				  if(cursor!=null){
				  if(cursor.getCount()>0){
					  cursor.moveToNext();
					  Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();
					  Intent i=new Intent(Login.this, ViewTotalAttendance.class);
					  startActivity(i);
					//  Intent i=new Intent(Login.this, .class);
			          //   startActivity(i);
				   
						   
					   }
					  
				  else{
					  Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
					   
				       } 
				  }
				 
				  }
			
				
			
			}
		});
		
		
	}



}
