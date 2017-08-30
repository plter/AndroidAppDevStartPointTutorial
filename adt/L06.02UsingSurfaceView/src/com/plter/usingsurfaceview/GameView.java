package com.plter.usingsurfaceview;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView {


	public GameView(Context context) {
		super(context);
		
		//setup the paint
		p.setColor(Color.RED);
		
		getHolder().addCallback(holdCallback);
	}
	
	private Paint p = new Paint();
	private Timer timer = new Timer();
	private TimerTask task=null;
	private float x=0,y=0,width=100,height=100,speedY=2;
	
	
	private void start(){
		
		if (task!=null) {
			return;
		}
		
		task = new TimerTask() {
			
			@Override
			public void run() {
				redraw();
			}
		};
		timer.schedule(task, 50, 50);
	}
	
	
	private void stop(){
		if (task==null) {
			return;
		}
		
		task.cancel();
		task=null;
	}
	
	private void redraw(){
		
		Canvas canvas = getHolder().lockCanvas();
		
		canvas.drawColor(Color.WHITE);
		
		canvas.drawRect(x, y, x+width, y+height, p);
		
		y+=speedY;
		
		getHolder().unlockCanvasAndPost(canvas);
		
	}
	

	private Callback holdCallback=new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			stop();
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
//			redraw();
			start();
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
		}
	};
}
