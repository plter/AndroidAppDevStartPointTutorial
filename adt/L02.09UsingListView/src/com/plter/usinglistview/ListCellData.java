package com.plter.usinglistview;

public class ListCellData {

	
	public ListCellData(String label,int peopleNum) {
		setLabel(label);
		setPeopleNum(peopleNum);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String label="";
	
	private int peopleNum=10;
	
	@Override
	public String toString() {
		return getLabel();
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	
}
