package com.plter.helloc;

public class HelloC {

	
	public native int max(int a,int b);
	
	
	static{
		System.loadLibrary("HelloC");
	}
}
