package com.plter.usingasynctask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private TextView tvOut;
	private ProgressDialog pd;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvOut = (TextView) findViewById(R.id.tvOut);
		
		findViewById(R.id.btnLoadWebData).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loadWebData();
			}
		});
	}
	
	
	private void loadWebData() {
		
		pd = ProgressDialog.show(this, "加载中", "正在加载数据，请稍候...");
		
		new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				
				String url = params[0];
				try {
					URLConnection uc = new URL(url).openConnection();
					InputStream in = uc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String line;StringBuffer sb = new StringBuffer();
					while((line=br.readLine())!=null){
						sb.append(line);
					}
					in.close();
					
					return sb.toString();
				} catch (MalformedURLException e) {
					e.printStackTrace(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return null;
			}
						
			protected void onPostExecute(String result) {
				pd.dismiss();
				
				if (result!=null) {
					tvOut.setText(result);
				}else{
					Toast.makeText(MainActivity.this, "加载数据出错", Toast.LENGTH_SHORT).show();
				}
				
			};
		}.execute("http://www.adobe.com");
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
