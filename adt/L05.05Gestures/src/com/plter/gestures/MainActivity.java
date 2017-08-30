package com.plter.gestures;

import java.util.ArrayList;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnGesturePerformedListener {
	
	
	private GestureOverlayView gov;
	private TextView tv;
	private GestureLibrary gl;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gl = GestureLibraries.fromRawResource(this, R.raw.gestures);
		gl.load();
		
		tv = (TextView) findViewById(R.id.textView1);
		gov = (GestureOverlayView) findViewById(R.id.gestureOverlayView1);
		
		gov.addOnGesturePerformedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
//		System.out.println("onGesturePerformed");
		
		ArrayList<Prediction> results =  gl.recognize(gesture);
		
		if (results.size()>0) {
			Prediction p = results.get(0);
			if (p.score>=1) {
				if ("close".equals(p.name)) {
					System.exit(0);
				}else{
					tv.setText(p.name);
				}
				
				return;
			}
		}
		
		Toast.makeText(this, "识别失败", Toast.LENGTH_SHORT).show();
		
//		for (Prediction p : results) {
//			System.out.println("name="+p.name+",score="+p.score);
//		}
	}

}
