<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="com.Facade"%>
<%@ page import="java.util.*" %>

<%
WebApplicationContext wac = (WebApplicationContext)pageContext.getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.spring");
Facade facade = (Facade)wac.getBean("facade");
facade.getManagerOneName();
//out.println(facade.getAlarmColumnList());
//out.println(facade.getAlarmFilterInfoList());
//out.println(facade.getAlarmFilterRuleById("601001"));
//out.println(facade.addAlarmRemark("11111111", "sss"));
//out.println(facade.getAlarmAckRuleById("000003"));
//out.println(facade.ackAlarm("111111", "", ""));
//out.println("system memory " + Long.toString(Runtime.getRuntime().totalMemory()/(1024*1024)) + "M");
//List<String> typeIds = new ArrayList<String>();
//0100100, 0300100, 0320120, 1000102
//typeIds.add("0600400");
//typeIds.add("0300100");
//out.println(facade.getTotalWindowAlarmSearch("alarmTable","0400200,0402200","deviceLevel1", 100));
//out.println(facade.getAllAlarmBoardForwardRule());
//ShortMessageTemplate template = new ShortMessageTemplate();
//template.setName("test");
//template.setContext("@a");
//facade.addShortMessageTemplate(template);
//out.println(facade.getShortMessageTemplateConfig());

//out.println(facade.getManagerOneName());
%>
