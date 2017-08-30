package com.plter.getactivityresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {


	public static final int REQUEST_CODE_QUESTION=1,REQUEST_CODE_GET_HELLO_WORDS=2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.showQuestionBtn).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivityForResult(new Intent(MainActivity.this, QuestionAty.class), REQUEST_CODE_QUESTION);

			}
		});
		
		findViewById(R.id.sayHiBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(MainActivity.this, HelloAty.class), REQUEST_CODE_GET_HELLO_WORDS);
			}
		});
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case REQUEST_CODE_QUESTION:
			
			System.out.println(data.getStringExtra("result"));
			
			switch (resultCode) {
			case QuestionAty.RESULT_B:
				System.out.println("结果正确");
				break;
			default:
				System.out.println("结果错误");
				break;
			}
			break;
		case REQUEST_CODE_GET_HELLO_WORDS:
			System.out.println("返回的信息是："+data.getStringExtra("result"));
			break;
		default:
			break;
		}

		super.onActivityResult(requestCode, resultCode, data);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
