package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DoctorUpdate extends ActionSupport {

	private String Doctor_ID;
	private DoctorBean cnbean;
	public String getDoctor_ID() {
		return Doctor_ID;
	}

	public void setDoctor_ID(String DoctorID) {
		Doctor_ID = DoctorID;
	}

	public DoctorBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(DoctorBean cnbean) {
		this.cnbean = cnbean;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		cnbean=new DoctorDao().GetBean(Integer.parseInt(Doctor_ID));
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
