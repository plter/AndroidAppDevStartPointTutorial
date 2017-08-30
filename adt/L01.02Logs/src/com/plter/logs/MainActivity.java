package com.plter.logs;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	
	private static final String TAG="MainActivity";
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        System.out.println("Hello Android");
        
        Log.i(TAG, "Hello Android");
        Log.e(TAG, "This is a error log");
        Log.w(TAG, "This is a warning log ");
        Log.d(TAG, "This is a debug log");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
