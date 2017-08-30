package com.plter.readxml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getResources().openRawResource(R.raw.data));
			NodeList nl = doc.getElementsByTagName("people");
			Node n;
			NamedNodeMap nnm;
			
			for (int i = 0; i < nl.getLength(); i++) {
				n=nl.item(i);
				nnm=n.getAttributes();
				System.out.println(String.format("name=%s,sex=%s,age=%s", n.getTextContent(),nnm.getNamedItem("sex").getNodeValue(),nnm.getNamedItem("age").getNodeValue()));
			}
			
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
