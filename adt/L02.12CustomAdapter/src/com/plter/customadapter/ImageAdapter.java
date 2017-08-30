package com.plter.customadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	
	
	public ImageAdapter(Context context) {
		this.context=context;
	}
	

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public ImageListCellData getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	
	public void add(ImageListCellData data){
		list.add(data);
		notifyDataSetChanged();
	}
	
	public void remove(ImageListCellData data){
		list.remove(data);
		notifyDataSetChanged();
	}
	
	
	public void remove(int index){
		list.remove(index);
		notifyDataSetChanged();
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView==null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.image_list_cell, null);
		}
		
		ImageView icon = (ImageView) convertView.findViewById(R.id.iconImageView);
		TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
		
		ImageListCellData data = getItem(position);
		
		icon.setImageResource(data.getIconResId());
		name.setText(data.getName());
		
		return convertView;
	}
	
	
	public Context getContext(){
		return context;
	}
	
	private final List<ImageListCellData> list = new ArrayList<ImageListCellData>();
	private Context context=null;
}
