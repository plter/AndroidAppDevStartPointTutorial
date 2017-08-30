package com.plter.addappwidgetsconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AppWidgetButtonClickBcr extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "控件中的按钮被点击了", Toast.LENGTH_SHORT).show();
	}

}
