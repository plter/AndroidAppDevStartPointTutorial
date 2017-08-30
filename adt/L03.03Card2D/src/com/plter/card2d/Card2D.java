package com.plter.card2d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

public class Card2D extends FrameLayout {

	public Card2D(Context context) {
		super(context);
		
		recto = new FrameLayout(getContext());
		addView(recto, -1, -1);
		verso = new FrameLayout(getContext());
		addView(verso, -1, -1);
		
		showRecto();
		
		saTo0.setFillAfter(true);
		saTo0.setDuration(500);
		saTo1.setFillAfter(true);
		saTo1.setDuration(500);
		saTo0.setAnimationListener(saTo0Listener);
	}
	
	public void showRecto(){
		recto.setVisibility(View.VISIBLE);
		verso.setVisibility(View.INVISIBLE);
	}
	
	public void showVerso(){
		recto.setVisibility(View.INVISIBLE);
		verso.setVisibility(View.VISIBLE);
	}
	
	
	public void turnToVerso(){
		if (isRectoVisible()) {
			recto.startAnimation(saTo0);
		}
	}
	
	public void turnToRecto(){
		if (!isRectoVisible()) {
			verso.startAnimation(saTo0);
		}
	}
	
	
	public FrameLayout getRecto(){
		return recto;
	}
	
	public FrameLayout getVerso(){
		return verso;
	}
	
	public boolean isRectoVisible(){
		return recto.getVisibility()==View.VISIBLE;
	}
	
	private FrameLayout recto,verso;
	private final ScaleAnimation saTo0= new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
	private final ScaleAnimation saTo1= new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0);
	private final AnimationListener saTo0Listener=new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			if (isRectoVisible()) {
				showVerso();
				
				recto.setAnimation(null);
				verso.startAnimation(saTo1);
			}else{
				showRecto();
				
				recto.startAnimation(saTo1);
				verso.setAnimation(null);
			}
		}
	};

}
