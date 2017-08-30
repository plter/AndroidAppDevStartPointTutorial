package com.plter.drawlines;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

public class MyView extends SurfaceView implements View.OnTouchListener, Callback {

	public MyView(Context context) {
		super(context);
		
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.STROKE);
		
		setOnTouchListener(this);
		
		getHolder().addCallback(this);
	}
	
	
	public void redraw(){
		
		Canvas canvas = getHolder().lockCanvas();
		
		canvas.drawColor(Color.WHITE);
		canvas.drawPath(path, paint);
		
		getHolder().unlockCanvasAndPost(canvas);
		
	}
	
	
	private final Path path=new Path();
	private final Paint paint = new Paint();
	

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(), event.getY());
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			redraw();
			break;
		}
		return true;
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		redraw();
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
//		redraw();
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
