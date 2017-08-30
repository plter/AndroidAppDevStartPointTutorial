<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	out.clear();

	InputStream in = request.getInputStream();
	if (in != null) {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				in, "utf-8"));

		String line = null;
		StringBuffer sb = new StringBuffer();

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		in.close();

		JSONObject obj = null;
		try {
			obj = new JSONObject(sb.toString());
		} catch (Exception e) {
		}

		if (obj != null) {

			String name = obj.getString("name");
			if (name != null) {
				out.print("Hello " + name);
			} else {
				out.print("参数错误");
			}
		} else {
			out.print("无效的请求");
		}

	} else {
		out.print("无效的请求");
	}
%>