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
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Report_PatientName.value)){  
   alert("請輸入病人姓名!"); 
   return false;
   }
   if(isNull(form1.Report_Disease.value)){
   alert("請輸入病人癥狀!");
   return false;
   }
   if(isNull(form1.Report_Medicine.value)){
   alert("請選擇藥品記錄!");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改病歷信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ReportUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Report_ID" type="text" class="noshow" id="Report_ID" value="<s:property value='cnbean.Report_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Patient_Name：</td>
                    <td><input name="Report_PatientName" type="text" class="text2" id="Report_PatientName" value="<s:property value='cnbean.Report_PatientName'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Disease：</td>
                    <td><input name="Report_Disease" type="text" class="text2" id="Report_Disease" value="<s:property value='cnbean.Report_Disease'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Medicine：</td>
                    <td><input name="Report_Medicine" type="text" class="text2" id="Report_Medicine" value="<s:property value='cnbean.Report_Medicine'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改病歷信息">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上頁" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
