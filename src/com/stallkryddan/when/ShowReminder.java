package com.stallkryddan.when;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowReminder extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_reminder);
		TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
		Reminder info = new Reminder(this);
		
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
	}

	
}