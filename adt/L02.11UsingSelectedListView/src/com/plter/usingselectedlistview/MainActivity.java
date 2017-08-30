package com.plter.usingselectedlistview;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	
	private ArrayAdapter<ListCellData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter=new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_multiple_choice){
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				CheckedTextView ctv = (CheckedTextView) super.getView(position, convertView, parent);
				ListCellData data = getItem(position);
				
				ctv.setChecked(data.isChecked());
				
				return ctv;
			}
			
		};
		setListAdapter(adapter);
		
		adapter.add(new ListCellData("北京"));
		adapter.add(new ListCellData("上海"));
		adapter.add(new ListCellData("广州"));
		adapter.add(new ListCellData("深圳"));
		adapter.add(new ListCellData("香港"));
		adapter.add(new ListCellData("澳门"));
		adapter.add(new ListCellData("西安"));
		adapter.add(new ListCellData("长沙"));
		adapter.add(new ListCellData("桂林"));
		adapter.add(new ListCellData("郑州"));
		adapter.add(new ListCellData("石家庄"));
		adapter.add(new ListCellData("大连"));
		adapter.add(new ListCellData("渤海"));
		
		findViewById(R.id.okBtn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ListCellData data;
				String str="喜欢的城市有\n";
				
				for (int i = 0; i < adapter.getCount(); i++) {
					data = adapter.getItem(i);
					
					if (data.isChecked()) {
						str=str.concat(data.getLabel()).concat("\n");
					}
				}
				
				new AlertDialog.Builder(MainActivity.this).setTitle("结果").setMessage(str).setPositiveButton("OK", null).show();
			}
		});
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		ListCellData data = adapter.getItem(position);
		
		data.setChecked(!data.isChecked());
		
		adapter.notifyDataSetChanged();
		
		super.onListItemClick(l, v, position, id);
	}


}
