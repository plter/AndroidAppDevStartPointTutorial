package com.plter.card3d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

public class Card3D extends FrameLayout {

	public Card3D(Context context) {
		super(context);
		
		recto = new FrameLayout(getContext());
		addView(recto, -1, -1);
		verso = new FrameLayout(getContext());
		addView(verso, -1, -1);
		
		showRecto();
		
		from0To90.setFillAfter(true);
		from0To90.setDuration(500);
		from270To0.setFillAfter(true);
		from270To0.setDuration(500);
		from0To90.setAnimationListener(from270To0Listener);
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
			recto.startAnimation(from0To90);
		}
	}
	
	public void turnToRecto(){
		if (!isRectoVisible()) {
			verso.startAnimation(from0To90);
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
	private final Anim3D from0To90 = new Anim3D(0, 90,300,true);
	private final Anim3D from270To0 = new Anim3D(-90, 0,300,false);
	
	private final AnimationListener from270To0Listener=new AnimationListener() {
		
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
				verso.startAnimation(from270To0);
			}else{
				showRecto();
				
				recto.startAnimation(from270To0);
				verso.setAnimation(null);
			}
		}
	};

}
