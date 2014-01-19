package com.stallkryddan.when;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class Welcome extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					Intent OpenMainActivity = new Intent("com.stallkryddan.when.MENU");
					startActivity(OpenMainActivity);
				}
			}
		};
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
