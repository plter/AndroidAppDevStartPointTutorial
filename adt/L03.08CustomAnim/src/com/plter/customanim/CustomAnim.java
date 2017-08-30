package com.plter.customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CustomAnim extends Animation {

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
//		System.out.println(interpolatedTime);
		
//		t.setAlpha(interpolatedTime);
//		t.getMatrix().setTranslate(0, 100*interpolatedTime);
		
		t.getMatrix().setTranslate((float)(20* Math.sin(interpolatedTime*1440/180*Math.PI)) , 0);
		
		
		super.applyTransformation(interpolatedTime, t);
	}
	
}
