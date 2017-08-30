package com.plter.memorygame;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {
	
	
	public static final int CARD_WIDTH=100;
	public static final int CARD_HEIGHT=100;
	

	public Card(Context context,int num) {
		super(context);
		
		this.num=num;
		
		label=new TextView(getContext());
		label.setText(num+"");
		label.setTextSize(48);
		label.setGravity(Gravity.CENTER);
		backgound=new FrameLayout(getContext());
		backgound.setBackgroundColor(Color.WHITE);
		addView(backgound,-1,-1);
		addView(label,-1,-1);
		
		showText();
	}
	
	
	public void showText(){
		label.setVisibility(View.VISIBLE);
		backgound.setVisibility(View.GONE);
	}
	
	
	public void showBackground(){
		label.setVisibility(View.GONE);
		backgound.setVisibility(View.VISIBLE);
	}
	
	
	public boolean isTextVisible(){
		return label.getVisibility()==View.VISIBLE;
	}
	
	public int getNum(){
		return num;
	}
	
	private int num=0;
	private TextView label;
	private FrameLayout backgound;

}
