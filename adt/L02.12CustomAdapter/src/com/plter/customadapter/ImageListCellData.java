package com.plter.customadapter;

public class ImageListCellData {

	
	public ImageListCellData(String name,int iconResId) {
		setName(name);
		setIconResId(iconResId);
	}
	
	
	private String name="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getIconResId() {
		return iconResId;
	}

	public void setIconResId(int iconResId) {
		this.iconResId = iconResId;
	}

	private int iconResId=0;
	
}
