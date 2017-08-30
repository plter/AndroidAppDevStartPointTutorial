package com.plter.memorygame;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {
	
	
	private RelativeLayout layout;
	private List<Point> allPoints=new ArrayList<Point>();
	private List<Card> cards = new ArrayList<Card>();
	private int currentNum=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout=(RelativeLayout) findViewById(R.id.layout);
		
//		final Card c = new Card(this, 2);
//		layout.addView(c,Card.CARD_WIDTH,Card.CARD_HEIGHT);
//		
//		c.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				if (c.isTextVisible()) {
//					c.showBackground();
//				}else{
//					c.showText();
//				}
//			}
//		});
		
		
		restartGame();
	}

	private OnClickListener cardClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Card c = (Card) v;
			
			if (c.getNum()==currentNum) {
				layout.removeView(v);
				cards.remove(c);
				
				currentNum++;
				
				if (cards.size()<=0) {
					new AlertDialog.Builder(MainActivity.this).setTitle("恭喜您").setMessage("你成功了").setPositiveButton("OK", null).show();
				}
				
				turnAllCardsToBackground();
			}else{
				Toast.makeText(MainActivity.this, "您点错了", Toast.LENGTH_SHORT).show();
			}
			
		}
	};

	private void restartGame() {
		currentNum=1;
		
		genAllPoint();
		addCards();
	}

	
	private void addCards(){
		
		clearCards();
		
		Card c;
		RelativeLayout.LayoutParams lp;
		Point p;
		
		for (int i = 1; i <= 9; i++) {
			c = new Card(this, i);
			layout.addView(c, Card.CARD_WIDTH, Card.CARD_HEIGHT);
			lp = (LayoutParams) c.getLayoutParams();
			
			p = allPoints.remove((int)(Math.random()*allPoints.size()));
			lp.leftMargin=p.x;
			lp.topMargin=p.y;
			c.setLayoutParams(lp);
			c.setOnClickListener(cardClickListener);
			
			cards.add(c);
		}
	}
	
	
	private void turnAllCardsToBackground(){
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).showBackground();
		}
	}


	private void clearCards() {
		for (int i = 0; i < cards.size(); i++) {
			layout.removeView(cards.get(i));
		}
		cards.clear();
	}


	private void genAllPoint() {
		
		allPoints.clear();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				allPoints.add(new Point(i*100, j*100));
			}
		}
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
