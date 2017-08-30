package com.plter.browser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	
	private EditText urlInput;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		urlInput=(EditText) findViewById(R.id.urlInput);
		webView = (WebView) findViewById(R.id.webview);
		
		findViewById(R.id.goBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goUrlByInput();
			}
		});
	}
	
	
	private void goUrlByInput(){
		String url = urlInput.getText().toString();
		webView.loadUrl(url);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
