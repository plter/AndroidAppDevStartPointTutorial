package com.plter.appmanager;

import android.app.ActivityManager.RunningAppProcessInfo;

public class ListCellData {

	
	public ListCellData(RunningAppProcessInfo info) {
		this.info=info;
	}
	
	
	public String getProcessName(){
		return info.processName;
	}
	
	
	@Override
	public String toString() {
		return info.processName;
	}
	
	private RunningAppProcessInfo info;
	
}
