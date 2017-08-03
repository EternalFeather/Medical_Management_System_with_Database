package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class PatientUpdate extends ActionSupport {

	private String Patient_ID;
	private PatientBean cnbean;
	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String PatientID) {
		Patient_ID = PatientID;
	}

	public PatientBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(PatientBean cnbean) {
		this.cnbean = cnbean;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		cnbean=new PatientDao().GetBean(Integer.parseInt(Patient_ID));
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
