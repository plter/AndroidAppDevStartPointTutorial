package com.plter.touchpoints;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {
	
	
	private RelativeLayout layout;
	private static final String TAG = "MainAty";
	private ImageView img;
	private RelativeLayout.LayoutParams imgLp;
	private float x1,y1,x2,y2,dis_x,dis_y,dis,last_dis=-1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img = (ImageView) findViewById(R.id.img);
		
		img.setLayoutParams(new RelativeLayout.LayoutParams(100, 100));
		
		layout = (RelativeLayout) findViewById(R.id.layout);
		layout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
//					Log.i(TAG,"down,pointer count:"+event.getPointerCount());
					
					last_dis=-1;
					break;
				case MotionEvent.ACTION_MOVE:
//					Log.i(TAG,"move,pointer count:"+event.getPointerCount());
//					if (event.getPointerCount()>=2) {
//						Log.i(TAG, String.format("(x1:%s,y1:%s),(x2:%s,y2:%s)", event.getX(0),event.getY(0),event.getX(1),event.getY(1)));
//					}
					
					if (event.getPointerCount()>=2) {
						x1=event.getX(0);
						y1=event.getY(0);
						x2=event.getX(1);
						y2=event.getY(1);
						
						dis_x=x1-x2;
						dis_y=y1-y2;
						
						dis = (float) Math.sqrt(dis_x*dis_x+dis_y*dis_y);
						
						if (last_dis>0) {
							if (dis-last_dis>5) {
								Log.i(TAG, "放大");
								
								imgLp = (LayoutParams) img.getLayoutParams();
								imgLp.width= (int)(1.2f * imgLp.width);
								imgLp.height=imgLp.width;
								img.setLayoutParams(imgLp);
								
							}else if(last_dis-dis>5){
								Log.i(TAG, "缩小");
								
								imgLp = (LayoutParams) img.getLayoutParams();
								imgLp.width= (int)(0.8f * imgLp.width);
								imgLp.height=imgLp.width;
								img.setLayoutParams(imgLp);
							}
							
						}
						
						last_dis = dis;
					}
					
					break;
				case MotionEvent.ACTION_UP:
//					Log.i(TAG,"up,pointer count:"+event.getPointerCount());
					break;

				default:
					break;
				}
				
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
