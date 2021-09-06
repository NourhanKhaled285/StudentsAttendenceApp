package com.example.attendance;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	 SQLiteOpenHelper ophelp;
     SQLiteDatabase db;
     Button reg,gotolog;
     EditText frn,lsn,passw,email,pho;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
        ophelp=new Database_reglog(this);
			
		
        frn=(EditText)findViewById(R.id.editText_reg_fn);
         lsn=(EditText)findViewById(R.id.editText_reg_ln);
        passw=(EditText)findViewById(R.id.editText_reg_pas);
        email=(EditText)findViewById(R.id.editText_reg_em);
        pho= (EditText)findViewById(R.id.editText_phone);
        
        reg=(Button)findViewById(R.id.button_reg);
        gotolog=(Button)findViewById(R.id.button_goto_log);
        
        reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			             
				   db=ophelp.getWritableDatabase();
				   String fn=frn.getText().toString();
				   String ln=lsn.getText().toString();
				   String pass=passw.getText().toString();
				   String em=email.getText().toString();
				   String ph=pho.getText().toString();
				   insertdata(fn,ln,pass,em,ph);
					Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();
				   
				
			}
		});
        gotolog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent=new Intent(Register.this,Login.class);
				startActivity(intent);
			}
		});
      
    }
    public void insertdata(String fn,String ln,String pass,String em,String ph){
    	ContentValues contentvalues=new ContentValues();
		contentvalues.put(Database_reglog.col_2,fn);
		contentvalues.put(Database_reglog.col_3,ln);
		contentvalues.put(Database_reglog.col_4,pass);
		contentvalues.put(Database_reglog.col_5,em);
		contentvalues.put(Database_reglog.col_6,ph);
		long ins=db.insert( Database_reglog.table_name, null ,contentvalues);
		
		
	}



}
