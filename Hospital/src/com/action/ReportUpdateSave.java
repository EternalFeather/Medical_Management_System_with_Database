package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReportUpdateSave extends ActionSupport {

	private String Report_ID ;
    private String Report_Disease ;
    private String Report_PatientName ;
    private String Report_Medicine ;
	public String getReport_ID() {
		return Report_ID;
	}

	public void setReport_ID(String cookID) {
		Report_ID = cookID;
	}

	public String getReport_Disease() {
		return Report_Disease;
	}

	public void setReport_Disease(String cookDisease) {
		Report_Disease = cookDisease;
	}

	public String getReport_PatientName() {
		return Report_PatientName;
	}

	public void setReport_PatientName(String cookPatientName) {
		Report_PatientName = cookPatientName;
	}

	public String getReport_Medicine() {
		return Report_Medicine;
	}

	public void setReport_Medicine(String cookMedicine) {
		Report_Medicine = cookMedicine;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<ReportBean> list=new ReportDao().GetList("Report_PatientName='"+Report_PatientName+"' and Report_ID!="+Report_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('病歷信息已經存在!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		ReportBean cnbean=new ReportBean();
		cnbean=new ReportDao().GetBean(Integer.parseInt(Report_ID));
		cnbean.setReport_Disease(Report_Disease);
		cnbean.setReport_PatientName(Report_PatientName);
		cnbean.setReport_Medicine(Report_Medicine);
		new ReportDao().Update(cnbean);
		    
		out.print("<script language='javascript'>alert('修改成功!');window.location='ReportManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}
