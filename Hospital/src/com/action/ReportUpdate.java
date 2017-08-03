package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReportUpdate extends ActionSupport {

	private String Report_ID;
	private ReportBean cnbean;
	public String getReport_ID() {
		return Report_ID;
	}

	public void setReport_ID(String ReportID) {
		Report_ID = ReportID;
	}

	public ReportBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(ReportBean cnbean) {
		this.cnbean = cnbean;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		cnbean=new ReportDao().GetBean(Integer.parseInt(Report_ID));
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
