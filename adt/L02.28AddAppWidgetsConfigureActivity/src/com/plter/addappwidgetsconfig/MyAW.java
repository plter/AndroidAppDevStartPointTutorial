package com.plter.addappwidgetsconfig;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class MyAW extends AppWidgetProvider {

	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		
		RemoteViews rv;
		
		for (int i = 0; i < appWidgetIds.length; i++) {
			rv = new RemoteViews(context.getPackageName(), R.layout.my_aw_layout);
			rv.setTextViewText(R.id.btn, "Click me");
			
			appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
		}
		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
}
