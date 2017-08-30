package com.plter.usingselectedlistview;

public class ListCellData {
	
	public ListCellData(String label) {
		setLabel(label);
	}

	private String label="";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	private boolean checked=false;
	
	
	@Override
	public String toString() {
		return getLabel();
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
