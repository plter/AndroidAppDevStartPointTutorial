package com.plter.getactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HelloAty extends Activity {

	
	private EditText input;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_aty);
		
		input=(EditText) findViewById(R.id.input);
		
		findViewById(R.id.returnBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String resultStr = input.getText().toString();
				Intent i = new Intent();
				i.putExtra("result", resultStr);
				
				setResult(1, i);
				finish();
			}
		});
	}
	
}
