package com.plter.loadwebimage;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	
	private ImageView imageView;
	private ProgressDialog pd;
	private WebBitmapLoader loader;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		pd = ProgressDialog.show(this, "加载中", "已加载0%");
		loader = new WebBitmapLoader();
		loader.setListener(new WebBitmapLoader.Listener() {
			
			@Override
			public void onComplete(Bitmap bitmap) {
				imageView.setImageBitmap(bitmap);
				
				pd.dismiss();
			}
			
			@Override
			public void onProgress(float progress) {
				pd.setMessage("已加载"+Math.floor(progress*10000)/100+"%");
			}
		});
		loader.load("http://pic4.nipic.com/20090826/2636558_182811034909_2.jpg");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
