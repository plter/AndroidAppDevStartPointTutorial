package com.plter.usingtt;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.display.Shape;
import com.plter.android.game2d.events.TouchEvent;
import com.plter.android.game2d.tween.TranslateTween;
import com.plter.lib.java.event.EventListener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Path.Direction;
import android.view.Menu;

public class MainActivity extends Activity {
	
	
	private GameView gameView;
	private Shape shape;
	private TranslateTween tt = new TranslateTween(null, 0, 0, 100, 100);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gameView = new GameView(this);
		setContentView(gameView);
		
		shape = new Shape();
		shape.getPath().addRect(0, 0, 100, 100, Direction.CW);
		tt.setTarget(shape);
		gameView.add(shape);
		
		shape.touchDown.add(new EventListener<TouchEvent>() {
			
			@Override
			public boolean onReceive(Object target, TouchEvent event) {
				tt.start();
				return false;
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
