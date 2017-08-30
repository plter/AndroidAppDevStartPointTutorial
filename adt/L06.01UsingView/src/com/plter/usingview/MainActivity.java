package com.plter.usingview;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		view = new View(this){
			
			private float speedY=1,width=100,height=100,x=0,y=0;
			private Paint p = new Paint();
			
			
			@Override
			protected void onDraw(Canvas canvas) {
				
				p.setColor(0xFFFF0000);
				canvas.drawRect(x, y, width+x, height+y, p);
				
				y+=speedY;
				
//				canvas.drawRect(new Rect(10, 10, 110, 110), p);
				
				super.onDraw(canvas);
				
				invalidate();
			}
		};
		setContentView(view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
