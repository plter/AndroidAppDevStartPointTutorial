package com.plter.getrequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private EditText etNameInput;
	private TextView tvResult;
	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etNameInput = (EditText) findViewById(R.id.etNameInput);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		findViewById(R.id.btnCallServer).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Editable name = etNameInput.getText();
				
				if (TextUtils.isEmpty(name)) {
					Toast.makeText(MainActivity.this, "名字不能为空", Toast.LENGTH_SHORT).show();
					return;
				}
				
				pd = ProgressDialog.show(MainActivity.this, "加载中", "正在呼叫服务器...");
				
				new AsyncTask<String, Void, String>() {

					@Override
					protected String doInBackground(String... params) {
						
						String url = params[0];
						try {
							InputStream in = new URL(url).openConnection().getInputStream();
							BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
							String line=null;StringBuffer sb = new StringBuffer();
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
							tvResult.setText(result);
						}else{
							Toast.makeText(MainActivity.this, "通信失败", Toast.LENGTH_SHORT).show();
						}
					};
					
				}.execute("http://10.0.2.2:8080/L08.07Server/hello.jsp?name="+name.toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
