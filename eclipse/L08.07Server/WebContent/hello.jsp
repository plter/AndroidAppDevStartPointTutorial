<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

out.clear();

String name = request.getParameter("name");
if(name!=null){
	out.print("Hello ".concat(name));
}else{
	out.print("参数错误");
}


%>