package com.stallkryddan.when;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewReminder extends Activity implements OnClickListener{

	Button sqlUpdate, sqlView;
	EditText sqlName, sqlComment;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_reminder);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlComment = (EditText) findViewById(R.id.etSQLComment);

		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	}
}