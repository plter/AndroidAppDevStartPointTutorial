package com.plter.usingpopupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	
	private ImageView popupImageView=null;
	private PopupWindow popupWindow=null;
	private RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		
		findViewById(R.id.showPopupWindowBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (getPopupWindow().isShowing()) {
					getPopupWindow().dismiss();
				}else{
					getPopupWindow().showAsDropDown(v);
//					getPopupWindow().showAtLocation(layout, Gravity.TOP|Gravity.LEFT, 100, 300);
				}
				
			}
		});
	}
	
	
	private PopupWindow getPopupWindow(){
		if (popupWindow==null) {
			popupWindow=new PopupWindow(getPopupImageView(), 50, 50);
		}
		return popupWindow;
	}
	
	
	private ImageView getPopupImageView(){
		if (popupImageView==null) {
			popupImageView = new ImageView(this);
			popupImageView.setImageResource(R.drawable.ic_launcher);
		}
		return popupImageView;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
