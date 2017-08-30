package com.plter.usingimage;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.display.Image;
import com.plter.android.game2d.events.GameViewEvent;
import com.plter.android.game2d.events.TouchEvent;
import com.plter.android.game2d.tools.BitmapLoader;
import com.plter.lib.java.event.EventListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private GameView gameView;
	private Image img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gameView  =new GameView(this);
		setContentView(gameView);
		
		img = new Image(BitmapLoader.loadBitmap(this, R.drawable.ic_launcher));
		gameView.add(img);
		
		img.x=100;
		img.y=100;
		img.regX = img.getWidth()/2;
		img.regY = img.getHeight()/2;
		
		img.touchDown.add(new EventListener<TouchEvent>() {
			
			@Override
			public boolean onReceive(Object target, TouchEvent event) {
				System.out.println("Touch Down");
				Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		
		gameView.enterFrame.add(new EventListener<GameViewEvent>() {
			
			@Override
			public boolean onReceive(Object target, GameViewEvent event) {
				img.rotation+=1;
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
