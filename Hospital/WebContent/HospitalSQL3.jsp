<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>醫療管理系統</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="104" background="Images/hospital.png" style="color:#FFFFFF; font-size:22px; font-weight:bolder; padding-left:50px;">
      <img border="0" src="Images/logo.png" width="280" height="54" alt="成大醫院" title="成大醫院"></td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top">
      <table width="1500" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="200" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="1320" align="center" valign="top" bgcolor="#F6F9FE">
          <table width="1320" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">醫院信息管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="HospitalManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="100" style="padding-left:20px;"> 功能導航： <u><a href="HospitalAdd.jsp">添加醫院信息</a></u></td>
                    <td width="36%">Search：
                      <select name="SearchRow" id="SearchRow">
                        <option value="Hospital_Address">地區</option>
                        <option value="Hospital_Name">醫院名</option>
                        <option value="Hospital_Scale">規模</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="點擊查詢"></td>
                     <td width="36">
                     <a href="HospitalSQL2.jsp" onClick="return confirm('切換成手動修改!')">
                     <input type="button" name="button" id="button" value="跳轉至手動修改"></a></td>
                     <td width="36">
                     <a href="HospitalSQL.jsp" onClick="return confirm('切換成手動查詢!')">
                     <input type="button" name="button" id="button" value="跳轉至手動查詢"></a></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>地區</strong></td>
                    <td bgcolor="#D5E4F4"><strong>醫院名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>規模</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Hospital_Address}</td>
                      <td align="center">${Hospital_Name}</td>
                      <td align="center">${Hospital_Scale}</td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
    <tr>
    	<td width="1500" align="left" height="25" valign="middle"><h1 style="font-size:15px">成大資工研究所</h1><h2>Medical management System Project</h2>
    </tr>
  </table>

</center>
</body>
</html>
