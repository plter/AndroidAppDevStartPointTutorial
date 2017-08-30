package com.plter.pgplugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

public class ShowToastPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		
		if ("show".equals(action)) {
			Toast.makeText(cordova.getActivity(), args.getString(0), Toast.LENGTH_SHORT).show();
		}
		
		
		return super.execute(action, args, callbackContext);
	}
	
}
