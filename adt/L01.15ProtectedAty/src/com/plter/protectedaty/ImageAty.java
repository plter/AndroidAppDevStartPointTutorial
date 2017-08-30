package com.plter.protectedaty;

import android.app.Activity;
import android.os.Bundle;

public class ImageAty extends Activity {

	
	public static final String ACTION="com.plter.protectedaty.intent.action.ImageAty";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_aty);
	}
}
