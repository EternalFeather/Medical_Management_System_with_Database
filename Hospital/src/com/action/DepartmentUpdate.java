package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DepartmentUpdate extends ActionSupport {

	private String Department_ID;
	private DepartmentBean cnbean;
	public String getDepartment_ID() {
		return Department_ID;
	}

	public void setDepartment_ID(String DepartmentID) {
		Department_ID = DepartmentID;
	}

	public DepartmentBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(DepartmentBean cnbean) {
		this.cnbean = cnbean;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		cnbean=new DepartmentDao().GetBean(Integer.parseInt(Department_ID));
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
