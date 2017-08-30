package com.plter.usingcamera;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Custom3DAnim extends Animation {

	
	private Camera camera;
	private int targetWidth=0,targetHeight=0;
	
	
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		
		targetWidth=width;
		targetHeight=height;
		camera = new Camera();
		
		super.initialize(width, height, parentWidth, parentHeight);
	}
	
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
		camera.save();
		
		camera.rotateY(360*interpolatedTime);
//		camera.rotateX(360*interpolatedTime);
//		camera.rotateZ(360*interpolatedTime);
		
		camera.getMatrix(t.getMatrix());
		
		camera.restore();
		
		t.getMatrix().preTranslate(-targetWidth/2, -targetHeight/2);
		t.getMatrix().postTranslate(targetWidth/2, targetHeight/2);
		
		super.applyTransformation(interpolatedTime, t);
	}
	
}
