package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class HospitalUpdate extends ActionSupport {

	private String Hospital_ID;
	private HospitalBean cnbean;
	public String getHospital_ID() {
		return Hospital_ID;
	}

	public void setHospital_ID(String hospitalID) {
		Hospital_ID = hospitalID;
	}

	public HospitalBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(HospitalBean cnbean) {
		this.cnbean = cnbean;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		cnbean=new HospitalDao().GetBean(Integer.parseInt(Hospital_ID));
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
