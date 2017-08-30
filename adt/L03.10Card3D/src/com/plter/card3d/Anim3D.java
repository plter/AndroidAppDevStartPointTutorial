package com.plter.card3d;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Anim3D extends Animation {

	
	public Anim3D(float startAngle,float endAngle,float maxZ,boolean isGoFar) {
		this.startAngle=startAngle;
		this.endAngle=endAngle;
		distance=endAngle-startAngle;
		this.maxZ=maxZ;
		this.isGoFar=isGoFar;
	}
	
	private float startAngle,endAngle,distance,maxZ;
	private int width,height,halfWidth,halfHeight;
	private boolean isGoFar=false;
	private final Camera camera =new Camera();
	
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		
		this.width=width;
		this.height=height;
		halfWidth=this.width/2;
		halfHeight=this.height/2;
		
		super.initialize(width, height, parentWidth, parentHeight);
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
		camera.save();
		
		if (isGoFar) {
			camera.translate(0, 0, maxZ*interpolatedTime);
		}else{
			camera.translate(0, 0, maxZ*(1-interpolatedTime));
		}
		camera.rotateY(startAngle+interpolatedTime*distance);
		camera.getMatrix(t.getMatrix());
		camera.restore();
		
		t.getMatrix().preTranslate(-halfWidth, -halfHeight);
		t.getMatrix().postTranslate(halfWidth, halfHeight);
		
		super.applyTransformation(interpolatedTime, t);
	}
}
