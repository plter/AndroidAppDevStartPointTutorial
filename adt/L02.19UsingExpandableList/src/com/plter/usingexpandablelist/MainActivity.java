package com.plter.usingexpandablelist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	private ExpandableListView expandableListView;
	private BaseExpandableListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new BaseExpandableListAdapter() {
			
			
			private String[] groups = new String[]{"北京","河北","河南"};
			private String[][] children = {{"石景山","东城区","西城区","昌平区","海淀区"},
					{"石家庄","邢台","唐山"},
					{"郑州","周口","开封","信阳"}};
			
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				TextView tv;
				
				if (convertView==null) {
					tv = new TextView(MainActivity.this);
					tv.setPadding(50, 10, 0, 10);
				}else{
					tv = (TextView) convertView;
				}
				
				tv.setText(groups[groupPosition]);
				
				return tv;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				return groups.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				return groups[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				return children[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				
				TextView tv;
				
				if (convertView==null) {
					tv = new TextView(MainActivity.this);
					tv.setPadding(50, 10, 0, 10);
				}else{
					tv=(TextView) convertView;
				}
				
				tv.setText(children[groupPosition][childPosition]);
				
				return tv;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return children[groupPosition][childPosition];
			}
		};
		
		expandableListView = (ExpandableListView) findViewById(R.id.elv);
		expandableListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
