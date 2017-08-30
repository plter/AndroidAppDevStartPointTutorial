package com.plter.puzzle;

import java.util.ArrayList;
import java.util.List;

import com.plter.android.game2d.display.GameView;
import com.plter.android.game2d.display.Image;
import com.plter.android.game2d.events.TouchEvent;
import com.plter.android.game2d.tools.BitmapLoader;
import com.plter.android.game2d.tween.TranslateTween;
import com.plter.lib.java.event.EventListener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Bitmap srcBitmap;
	private GameView gameView;
	private Image img;
	private static final int H_NUM=4,V_NUM=6;
	private int picWidth=0,picHeight=0;
	private TranslateTween movePicTween = new TranslateTween();
	private List<Pic> allPics = new ArrayList<Pic>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		srcBitmap = BitmapLoader.loadBitmap(this, R.drawable.img);
		picWidth=srcBitmap.getWidth()/H_NUM;
		picHeight=srcBitmap.getHeight()/V_NUM;
		
		movePicTween.setFrames(5);
		
		gameView=new GameView(this);
//		gameView.setFps(50);
		setContentView(gameView);
		
//		img = new Image(srcBitmap);
//		gameView.add(img);
		
		cutImage();
	}
	
	
	private void cutImage(){
		
		Pic pic;
		
		for (int i = 0; i < H_NUM; i++) {
			for (int j = 0; j < V_NUM; j++) {
				
				if (i==H_NUM-1&&j==V_NUM-1) {
					picsMap[i][j]=null;
					continue;
				}
				pic = new Pic(Bitmap.createBitmap(srcBitmap, i*picWidth, j*picHeight, picWidth, picHeight));
				pic.x=i*(picWidth);
				pic.y=j*(picHeight);
				pic.currentIndexI=i;
				pic.currentIndexJ=j;
				pic.rightIndexI=i;
				pic.rightIndexJ=j;
				gameView.add(pic);
				pic.touchDown.add(picTouchDownHandler);
				
				allPics.add(pic);
				picsMap[i][j]=pic;
			}
		}
	}
	
	private final EventListener<TouchEvent> picTouchDownHandler=new EventListener<TouchEvent>() {
		
		@Override
		public boolean onReceive(Object target, TouchEvent event) {
			
			if (!movePicTween.isRunning()) {
				checkToMovePic((Pic) target);
			}
			
			return false;
		}
	};
	
	
	
	
	
	public void checkAllPicOnRightPlace(){
		boolean allOnRightPlace = true;
		
		for (Pic pic : allPics) {
			if (!pic.onRightPlace()) {
				allOnRightPlace=false;
				break;
			}
		}
		
		if (allOnRightPlace) {
			Toast.makeText(this, "成功了", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	private void checkToMovePic(Pic pic){
		switch (getPicDir(pic)) {
		case Dir.LEFT:
			movePicTween.setStartX(pic.x);
			movePicTween.setEndX(pic.x-picWidth);
			movePicTween.setStartY(pic.y);
			movePicTween.setEndY(pic.y);
			movePicTween.setTarget(pic);
			movePicTween.start();
			
			picsMap[pic.currentIndexI][pic.currentIndexJ]=null;
			pic.currentIndexI--;
			picsMap[pic.currentIndexI][pic.currentIndexJ]=pic;
			checkAllPicOnRightPlace();
			break;
		case Dir.UP:
			movePicTween.setStartX(pic.x);
			movePicTween.setEndX(pic.x);
			movePicTween.setStartY(pic.y);
			movePicTween.setEndY(pic.y-picHeight);
			movePicTween.setTarget(pic);
			movePicTween.start();
			
			picsMap[pic.currentIndexI][pic.currentIndexJ]=null;
			pic.currentIndexJ--;
			picsMap[pic.currentIndexI][pic.currentIndexJ]=pic;
			checkAllPicOnRightPlace();
			break;
		case Dir.RIGHT:
			movePicTween.setStartX(pic.x);
			movePicTween.setEndX(pic.x+picWidth);
			movePicTween.setStartY(pic.y);
			movePicTween.setEndY(pic.y);
			movePicTween.setTarget(pic);
			movePicTween.start();
			
			picsMap[pic.currentIndexI][pic.currentIndexJ]=null;
			pic.currentIndexI++;
			picsMap[pic.currentIndexI][pic.currentIndexJ]=pic;
			
			checkAllPicOnRightPlace();
			break;
		case Dir.DOWN:
			movePicTween.setStartX(pic.x);
			movePicTween.setEndX(pic.x);
			movePicTween.setStartY(pic.y);
			movePicTween.setEndY(pic.y+picHeight);
			movePicTween.setTarget(pic);
			movePicTween.start();
			
			picsMap[pic.currentIndexI][pic.currentIndexJ]=null;
			pic.currentIndexJ++;
			picsMap[pic.currentIndexI][pic.currentIndexJ]=pic;
			checkAllPicOnRightPlace();
			break;
		}
	}
	
	
	public int getPicDir(Pic pic){
		if (pic.currentIndexI>0&&picsMap[pic.currentIndexI-1][pic.currentIndexJ]==null) {
			return Dir.LEFT;
		}
		if (pic.currentIndexJ>0&&picsMap[pic.currentIndexI][pic.currentIndexJ-1]==null) {
			return Dir.UP;
		}
		if (pic.currentIndexI<H_NUM-1&&picsMap[pic.currentIndexI+1][pic.currentIndexJ]==null) {
			return Dir.RIGHT;
		}
		if (pic.currentIndexJ<V_NUM-1&&picsMap[pic.currentIndexI][pic.currentIndexJ+1]==null) {
			return Dir.DOWN;
		}
		return Dir.NONE;
	}
	
	
	private Pic[][] picsMap = new Pic[H_NUM][V_NUM];

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
