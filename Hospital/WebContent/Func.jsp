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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">醫生信息管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="FuncSearch.action">
                <table width="50%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="14%" height="100" style="padding-left:20px;"> Age Management：</td>
                    <td width="36%">Group By:
                      <select name="SearchRowF1" id="SearchRowF1">
                        <option value="Doctor_Specialty">專長</option>
                        <option value="Doctor_Name">姓名</option>
                      </select>
                      <select name="SearchRowF2" id="SearchRowF2">
                        <option value="count(Doctor_Age)">COUNT</option>
                        <option value="sum(Doctor_Age)">SUM</option>
                        <option value="min(Doctor_Age)">MIN</option>
                        <option value="max(Doctor_Age)">MAX</option>
                        <option value="avg(Doctor_Age)">AVG</option>
                      </select>
                      <input type="submit" name="button" id="button" value="點擊查詢"></td>
                  </tr>
                </table>
              </form>
              <form name="form2" method="post" action="FuncSQL.action" onSubmit="return mycheck()" >
              	<table width="100%" border="0" cellspacing="0" cellpadding="0">
              	<tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
              	<tr>
                    <td height="30" align="right"><span style="color:red;">*</span>SQL：</td>
                    <td>
                      <input name="SearchFSQL" type="text" class="text1" style="width:400; height:50" id="SearchFSQL"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="查詢">
                   </td>
                  </tr>
                  </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>Group By</strong></td>
                    <td bgcolor="#D5E4F4"><strong>Result</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Group}</td>
                      <td align="center">${Result}</td>
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
