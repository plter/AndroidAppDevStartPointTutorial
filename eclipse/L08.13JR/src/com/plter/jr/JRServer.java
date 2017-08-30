package com.plter.jr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JRServer {

	public void handle(HttpServletRequest request,HttpServletResponse response){
		String requestDataString = readRequestData(request);
		if (requestDataString==null) {
			writeOut(String.format("{\"state\":%d,\"msg\":\"无效的请求\"}", JRStatus.INVALID_REQUEST),response);
			return;
		}
		
		
		try {
			JSONObject methodJsonObj = new JSONObject(requestDataString);
			
			String methodName = methodJsonObj.getString("methodName");
			JSONArray jsonArgs = methodJsonObj.getJSONArray("args");
			Object[] args=null;
			if (jsonArgs.length()>0) {
				args = new Object[jsonArgs.length()];
				for (int i = 0; i < args.length; i++) {
					args[i]=jsonArgs.get(i);
				}
			}
			
			Method[] methods = getClass().getMethods();
			Method method=null;
			for (Method m : methods) {
				if (m.getName().equals(methodName)&&m.getParameterTypes().length==args.length) {
					method=m;
					break;
				}
			}
			if (method!=null) {
				try {
					Object result = method.invoke(this, args);
					
					JSONObject resultJsonObj = new JSONObject();
					resultJsonObj.put("state", JRStatus.SUCCESS);
					resultJsonObj.put("result", result);
					
					writeOut(resultJsonObj.toString(), response);
					
				} catch (Exception e) {
					e.printStackTrace();
					
					writeOut(String.format("{\"state\":%d,\"msg\":\"调用出错\"}", JRStatus.INVOKE_ERROR),response);
				}
			}else{
				writeOut(String.format("{\"state\":%d,\"msg\":\"调用出错\"}", JRStatus.METHOD_NOT_FOUNT),response);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			
			writeOut(String.format("{\"state\":%d,\"msg\":\"无效的请求\"}", JRStatus.INVALID_REQUEST),response);
		}
	}
	
	
	public void writeOut(String value,HttpServletResponse response){
		try {
			response.getWriter().append(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private String readRequestData(HttpServletRequest request){
		try {
			InputStream is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line=null;StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			is.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
