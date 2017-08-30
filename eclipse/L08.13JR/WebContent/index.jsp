<%@page import="com.plter.usingjr.MyServer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

MyServer s = new MyServer();
s.handle(request, response);

%>