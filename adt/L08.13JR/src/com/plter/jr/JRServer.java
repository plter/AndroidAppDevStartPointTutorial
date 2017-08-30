package com.plter.jr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class JRServer {

	private HttpClient hc = new DefaultHttpClient();

	public JRServer(String url) {
		setUrl(url);
	}


	public void call(String methodName,Object... args){

		new AsyncTask<Object, Void, String>() {

			@Override
			protected String doInBackground(Object... params) {

				try {
					String methodName = (String) params[0];
					Object[] objs = (Object[]) params[1];
					
					//build method
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("methodName", methodName);
					JSONArray jsonArgs = new JSONArray();
					for (Object obj : objs) {
						jsonArgs.put(obj);
					}
					jsonObj.put("args",jsonArgs);
					
					HttpPost hp = new HttpPost(getUrl());
					hp.setEntity(new StringEntity(jsonObj.toString(),"utf-8"));
					
					HttpResponse hr = hc.execute(hp);
					InputStream in = hr.getEntity().getContent();
					BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
					String line=null;StringBuffer sb = new StringBuffer();
					while((line=br.readLine())!=null){
						sb.append(line);
					}
					in.close();
					return sb.toString();
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			protected void onPostExecute(String result) {
				if (result!=null) {
					try {
						JSONObject jsonResult = new JSONObject(result);
						
						if (getOnSuccessListener()!=null) {
							try{
								Object re = jsonResult.get("result");
								getOnSuccessListener().onSuccess(re);
							}catch(Exception e){
								getOnSuccessListener().onSuccess(null);
							}
						}
					} catch (JSONException e) {
						e.printStackTrace();
						
						if (getOnErrorListener()!=null) {
							getOnErrorListener().onError();
						}
					}
				}else{
					if (getOnErrorListener()!=null) {
						getOnErrorListener().onError();
					}
				}
			};

		}.execute(methodName,args);

	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public OnErrorListener getOnErrorListener() {
		return onErrorListener;
	}


	public void setOnErrorListener(OnErrorListener onErrorListener) {
		this.onErrorListener = onErrorListener;
	}
	public OnSuccessListener getOnSuccessListener() {
		return onSuccessListener;
	}


	public void setOnSuccessListener(OnSuccessListener onSuccessListener) {
		this.onSuccessListener = onSuccessListener;
	}
	private String url=null;
	
	private OnErrorListener onErrorListener=null;
	private OnSuccessListener onSuccessListener=null;


	public static interface OnSuccessListener{
		void onSuccess(Object obj);
	}
	public static interface OnErrorListener{
		void onError();
	}
}
