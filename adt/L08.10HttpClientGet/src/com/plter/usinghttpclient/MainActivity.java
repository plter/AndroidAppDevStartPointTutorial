package com.plter.usinghttpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private TextView tvOut;
	private ProgressDialog pd;
	private EditText etNameInput;
	private HttpClient hc=new DefaultHttpClient();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etNameInput=(EditText) findViewById(R.id.etNameInput);
		tvOut = (TextView) findViewById(R.id.tvOut);
		
		findViewById(R.id.btnLoad).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loadData();
			}
		});
		
	}
	
	
	
	private void loadData(){
		
		Editable name = etNameInput.getText();
		if (TextUtils.isEmpty(name)) {
			Toast.makeText(this, "名字不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		pd = ProgressDialog.show(this, "加载中", "正在加载数据，请稍候...");
		
		new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				
				String url = params[0];
				
				HttpGet hg = new HttpGet(url);
				try {
					HttpResponse hr = hc.execute(hg);
					InputStream in = hr.getEntity().getContent();
					BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
					String line=null;StringBuffer sb = new StringBuffer();
					while((line=br.readLine())!=null){
						sb.append(line);
					}
					in.close();
					
					return sb.toString();
					
				} catch (ClientProtocolException e) {
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
					Toast.makeText(MainActivity.this, "通信失败", Toast.LENGTH_SHORT).show();
				}
			};
			
		}.execute("http://10.0.2.2:8080/L08.07Server/hello.jsp?name="+name.toString());
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
