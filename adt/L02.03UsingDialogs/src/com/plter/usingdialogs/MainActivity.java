package com.plter.usingdialogs;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private OnClickListener btnClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.showSimpleDialog:
				showSimpleDialog();
				break;
			case R.id.showQuestionDialog:
				showQuestionDialog();
				break;
			case R.id.showSingleChoiceDialog:
				showSCDialog();
				break;
			default:
				break;
			}
		}
	};
	
	
	private void showSCDialog(){
		new AlertDialog.Builder(this).setTitle("中国最大的城市是？").setSingleChoiceItems(new CharSequence[]{"北京","上海","广州","深圳"}, -1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
				switch (which) {
				case 0:
					Toast.makeText(MainActivity.this, "您选择的是北京", Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(MainActivity.this, "您选择的是上海", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(MainActivity.this, "您选择的是广州", Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, "您选择的是深圳", Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}).show();
	}
	
	
	private void showQuestionDialog(){
		new AlertDialog.Builder(this).setTitle("你好").setMessage("你今天吃饭了吗？").setPositiveButton("吃了", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "已经吃过了", Toast.LENGTH_SHORT).show();
			}
		}).setNegativeButton("还没", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "还没吃饭", Toast.LENGTH_SHORT).show();
			}
		}).setNeutralButton("不知道", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "不知道是否吃饭了，可能已经饿晕了", Toast.LENGTH_SHORT).show();
			}
		}).show();
	}
	
	private void showSimpleDialog(){
		new AlertDialog.Builder(this).setPositiveButton("确定", null).setTitle("你好").setMessage("我一天不在，你们就把世界搞成这个样子？").show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.showSimpleDialog).setOnClickListener(btnClickListener);
		findViewById(R.id.showQuestionDialog).setOnClickListener(btnClickListener);
		findViewById(R.id.showSingleChoiceDialog).setOnClickListener(btnClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
