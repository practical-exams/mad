package com.example.smsapplication;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {
	private EditText phoneNumber;
	private EditText smsBody;
	private Button smsSendToBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		phoneNumber = (EditText) findViewById(R.id.editText1);
		smsBody = (EditText) findViewById(R.id.editText2);
		smsSendToBtn = (Button) findViewById(R.id.button2);
		smsSendToBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				sendSmsBySIntent();
			}
		});
	}
	public void sendSmsByManager() {
		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNumber.getText().toString(),
			null,
			smsBody.getText().toString(),
			null,
			null);
			Toast.makeText(getApplicationContext(),
					"Your sms has successfully sent!",
					Toast.LENGTH_LONG).show();
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Your sms has failed...",
			Toast.LENGTH_LONG).show();
			ex.printStackTrace();
		}
	}
	public void sendSmsBySIntent() {
		Uri uri = Uri.parse("smsto:" + phoneNumber.getText().toString());
		Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
		smsSIntent.putExtra("sms_body", smsBody.getText().toString());
		try {
			startActivity(smsSIntent);
		} catch (Exception ex) {
			Toast.makeText(MainActivity.this, "Your sms has failed...",
			Toast.LENGTH_LONG).show();
			ex.printStackTrace();
			}
	}
	public void sendSmsByVIntent() {
		Intent smsVIntent = new Intent(Intent.ACTION_VIEW);
		smsVIntent.setType("vnd.android-dir/mms-sms");
		smsVIntent.putExtra("address", phoneNumber.getText().toString());
		smsVIntent.putExtra("sms_body", smsBody.getText().toString());
		try {
			startActivity(smsVIntent);
		} catch (Exception ex) {
			Toast.makeText(MainActivity.this, "Your sms has failed...",
			Toast.LENGTH_LONG).show();
			ex.printStackTrace();
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
