package com.example.datapassingapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends Activity {
	
	TextView tv;
	String na;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		
		tv=(TextView)findViewById(R.id.textView1);
		
		Intent in=getIntent();
		
		na=in.getStringExtra("myName");
		
		tv.setText("welcome"+" \t"+na);
		
		
	}
}