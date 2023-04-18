package com.example.datapassingapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {


	EditText uname, pass;
	Button blog, bclear;
	Intent in;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        uname=(EditText)findViewById(R.id.editText1);
        pass=(EditText)findViewById(R.id.editText2);
        blog=(Button)findViewById(R.id.button1);
        bclear=(Button)findViewById(R.id.button2);
        
        blog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String na=uname.getText().toString();
				String p=pass.getText().toString();
				if(na.equals("admin") && p.equals("admin"))
				{
					Toast.makeText(getApplicationContext(), "Authenticated...", Toast.LENGTH_LONG).show();
					in=new Intent(getApplicationContext(),SecondActivity.class);
					in.putExtra("myName", na);
					startActivity(in);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Un Authenticated...", Toast.LENGTH_LONG).show();
					uname.setText("");
					pass.setText("");
				}
				
			}
		});
        bclear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				uname.setText("");
				pass.setText("");
			}
		});
        
        
    }
    
}
