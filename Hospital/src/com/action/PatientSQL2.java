package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class PatientSQL2 extends ActionSupport {

	private String Patient_ID;
    private int  Patient_Age ;
    private String  Patient_Name ;
    private String Patient_Disease ;
    private String SearchSQL2;
	public String getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(String PatientID) {
		Patient_ID = PatientID;
	}
	
	public String getSearchSQL2() {
		return SearchSQL2;
	}

	public void setSearchSQL2(String searchSQL2) {
		SearchSQL2 = searchSQL2;
	}
	
	public int getPatient_Age() {
		return Patient_Age;
	}

	public void setPatient_Age(int cookAge) {
		Patient_Age = cookAge;
	}

	public String getPatient_Name() {
		return Patient_Name;
	}

	public void setPatient_Name(String cookName) {
		Patient_Name = cookName;
	}

	public String getPatient_Disease() {
		return Patient_Disease;
	}

	public void setPatient_Disease(String cookDisease) {
		Patient_Disease = cookDisease;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<PatientBean> list=new PatientDao().GetList("Patient_Name='"+Patient_Name+"' and Patient_ID!=" + Patient_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('病人信息已經存在');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		PatientBean cnbean=new PatientBean();
		cnbean.setPatient_Age(Patient_Age);
		cnbean.setPatient_Name(Patient_Name);
		cnbean.setPatient_Disease(Patient_Disease);
		new PatientDao().SQL2(cnbean, SearchSQL2);
		    
		out.print("<script language='javascript'>alert('修改成功!');window.location='PatientManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}
