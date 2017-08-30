package com.plter.getactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuestionAty extends Activity {

	
	private Button okBtn;
	private RadioButton rbA,rbB,rbC,rbD;
	public static final int RESULT_A=1,RESULT_B=2,RESULT_C=3,RESULT_D=4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_aty);
		
		rbA = (RadioButton) findViewById(R.id.rbA);
		rbB = (RadioButton) findViewById(R.id.rbB);
		rbC = (RadioButton) findViewById(R.id.rbC);
		rbD = (RadioButton) findViewById(R.id.rbD);
		okBtn = (Button) findViewById(R.id.okBtn);
		okBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int code = 0;
				if (rbA.isChecked()) {
					code=RESULT_A;
				}else if (rbB.isChecked()) {
					code=RESULT_B;
				}else if (rbC.isChecked()) {
					code=RESULT_C;
				}else if (rbD.isChecked()) {
					code=RESULT_D;
				}
//				setResult(code);
				
				String resultStr = "";
				if (rbA.isChecked()) {
					resultStr="A";
				}else if (rbB.isChecked()) {
					resultStr="B";
				}else if (rbC.isChecked()) {
					resultStr="C";
				}else if (rbD.isChecked()) {
					resultStr="D";
				}
				
				Intent i = new Intent();
				i.putExtra("result", resultStr);
				setResult(code, i);
				
				finish();
			}
		});
	}
	
}
