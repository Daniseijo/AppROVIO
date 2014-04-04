package com.example.wowweelisw;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.accesoURL.RovioModel;

public class MainActivity extends Activity {

	private Button bForward, bBack, bLeft, bRight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Linkeo de los botones
		bForward = (Button)findViewById(R.id.buttonUp);
		bForward.setOnClickListener(oclForward);
		
		
		
		if (savedInstanceState == null) {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Listeners
	
	/**
	private OnTouchListener oclForward = new OnTouchListener(){
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction() == MotionEvent.ACTION_DOWN){
				RovioModel.moveForward();				
				return true;
			}
			return false;
		}
	};
	*/
	
	
	private OnClickListener oclForward = new OnClickListener(){
		@Override
		public void onClick(View v) {
			int i = 0;
			while(i<20){
				RovioModel.moveForward();
				try{
					Thread.sleep(350);
				}catch(Exception e){
				}				
				i++;
			}
		}
	};
	
}
