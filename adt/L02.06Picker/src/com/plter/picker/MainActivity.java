package com.plter.picker;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	
	
	private TextView dateTv,timeTv;
	
	

	private OnClickListener btnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.changeDateBtn:
				showChangeDateDialog();
				break;
			case R.id.changeTimeBtn:
				showChangeTimeDialog();
				break;
			}
		}
	};
	
	
	private void showChangeDateDialog(){
		new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				dateTv.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
		}, 2013, 0, 1).show();
	}
	
	
	private void showChangeTimeDialog(){
		new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				timeTv.setText(hourOfDay+":"+minute);
			}
		}, 20, 10, true).show();
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateTv = (TextView) findViewById(R.id.dateTv);
		timeTv = (TextView) findViewById(R.id.timeTv);
		
		findViewById(R.id.changeDateBtn).setOnClickListener(btnClickListener);
		findViewById(R.id.changeTimeBtn).setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
