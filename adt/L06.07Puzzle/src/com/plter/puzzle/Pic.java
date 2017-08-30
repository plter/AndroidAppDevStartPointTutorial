package com.plter.puzzle;

import android.graphics.Bitmap;

import com.plter.android.game2d.display.Image;

public class Pic extends Image {

	public Pic(Bitmap bitmap) {
		super(bitmap);
	}

	public boolean onRightPlace(){
		return currentIndexI==rightIndexI&&currentIndexJ==rightIndexJ;
	}
	
	
	public int currentIndexI=0,currentIndexJ=0,rightIndexI=0,rightIndexJ=0;
}
