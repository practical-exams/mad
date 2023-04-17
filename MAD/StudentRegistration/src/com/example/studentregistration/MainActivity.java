package com.example.studentregistration;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	EditText txt1, txt2, txt3, txt4, txt5;
	Button b1, b2;

	RadioGroup rg;
	RadioButton r;

	Spinner sp;

	String dept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txt1 = (EditText) findViewById(R.id.txtRegNo);
		txt2 = (EditText) findViewById(R.id.txtName);
		txt3 = (EditText) findViewById(R.id.txt10th);
		txt4 = (EditText) findViewById(R.id.txt12th);
		txt5 = (EditText) findViewById(R.id.txtug);

		b1 = (Button) findViewById(R.id.btnSubmit);
		b2 = (Button) findViewById(R.id.btnClear);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);

		rg = (RadioGroup) findViewById(R.id.radioGroup);

		sp = (Spinner) findViewById(R.id.sprDepts);
		sp.setOnItemSelectedListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DatabaseHandler db = new DatabaseHandler(this);

		switch (arg0.getId()) {
		case R.id.btnSubmit:
			int reg = Integer.parseInt(txt1.getText().toString());
			String n = txt2.getText().toString();
			int rid = rg.getCheckedRadioButtonId();
			r = (RadioButton) findViewById(rid);
			String gen = r.getText().toString();
			// department
			float ten = Float.parseFloat(txt3.getText().toString());
			float twele = Float.parseFloat(txt4.getText().toString());
			float ug = Float.parseFloat(txt5.getText().toString());
			// Toast.makeText(getApplicationContext(),
			// "The Values are:\n Reg.no:"+reg+"\nName:"+n+"\nGender:"+gen+"\nDepartment:"+dept+"\n10Tth Mark:"+ten+"\n12th Mark:"+twele+"\nUG Mark:"+ug,
			// Toast.LENGTH_LONG).show();
			db.insertEntry(reg, n, gen, dept, ten, twele, ug);
			Toast.makeText(getApplicationContext(),
					"Record inserted successfully...", Toast.LENGTH_LONG)
					.show();
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			break;
		case R.id.btnClear:
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			break;

		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		dept = sp.getSelectedItem().toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
