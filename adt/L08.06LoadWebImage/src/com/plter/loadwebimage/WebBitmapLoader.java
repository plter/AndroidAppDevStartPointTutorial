package com.plter.loadwebimage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class WebBitmapLoader extends AsyncTask<String, Float, Bitmap> {

	@Override
	protected Bitmap doInBackground(String... params) {
		
		String url = params[0];
		try {
			URLConnection uc = new URL(url).openConnection();
			InputStream in = uc.getInputStream();
			
			int size = uc.getContentLength();
			if (size<=0) {
				return BitmapFactory.decodeStream(in);
			}else{
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] bytes = new byte[1024];
				int count = 0,readed=0;
				while((count=in.read(bytes))>-1){
					bos.write(bytes, 0, count);
					readed+=count;
					publishProgress((float)readed/size);
				}
				bytes = bos.toByteArray();
				bos.close();
				return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	protected void onPostExecute(Bitmap result) {
		
		if (listener!=null) {
			listener.onComplete(result);
		}
		
		super.onPostExecute(result);
	}
	
	
	@Override
	protected void onProgressUpdate(Float... values) {
		
		if (listener!=null) {
			listener.onProgress(values[0]);
		}
		
		super.onProgressUpdate(values);
	}
	
	
	public void load(String url){
		execute(url);
	}
	
	
	public Listener getListener() {
		return listener;
	}


	public void setListener(Listener listener) {
		this.listener = listener;
	}


	private Listener listener=null;
	
	
	public static interface Listener{
		
		void onComplete(Bitmap bitmap);
		
		void onProgress(float progress);
	}

}
