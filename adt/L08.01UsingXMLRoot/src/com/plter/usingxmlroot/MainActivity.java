package com.plter.usingxmlroot;

import com.plter.lib.java.xml.XML;
import com.plter.lib.java.xml.XMLList;
import com.plter.lib.java.xml.XMLRoot;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		XMLRoot root = XMLRoot.parse(getResources().openRawResource(R.raw.data));
		if (root!=null) {
			
			XMLList list = (XMLList) root.getChild("people");
			XML xml;
			
			for (int i = 0; i < list.length(); i++) {
				xml=list.get(i);
				System.out.println(String.format("name=%s,sex=%s,age=%s", xml.getText(),xml.getAttr("sex"),xml.getAttr("age")));
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
