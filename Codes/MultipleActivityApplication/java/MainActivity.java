package com.example.multipleactivityapplication;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Intent in;
	Button b1;
	
    @Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button1);

b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				in = new Intent(MainActivity.this, SecondActivity.class);
				
				startActivity(in);
			}
		});
}
}