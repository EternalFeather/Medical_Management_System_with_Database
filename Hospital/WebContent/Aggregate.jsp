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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">Aggregate醫生信息管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="HospitalManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="25%" height="100" style="padding-left:20px;"> Exists： <u><a href="AggExists.jsp">點擊切換</a></u></td>
                    <td width="25%" height="100" style="padding-left:20px;"> Not Exists： <u><a href="AggNotExists.jsp">點擊切換</a></u></td>
                    <td width="25%" height="100" style="padding-left:20px;"> In： <u><a href="AggIn.jsp">點擊切換</a></u></td>
                    <td width="25%" height="100" style="padding-left:20px;"> Not In： <u><a href="AggNotIn.jsp">點擊切換</a></u></td>
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
                      <td height="25" align="center">${Doctor_Name}</td>
                      <td align="center">${Doctor_Age}</td>
                      <td align="center">${Doctor_Specialty}</td>
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
