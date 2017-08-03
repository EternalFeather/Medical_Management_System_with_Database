package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DoctorUpdateSave extends ActionSupport {

	private String Doctor_ID ;
    private int Doctor_Age ;
    private String Doctor_Name ;
    private String Doctor_Specialty ;
	public String getDoctor_ID() {
		return Doctor_ID;
	}

	public void setDoctor_ID(String cookID) {
		Doctor_ID = cookID;
	}

	public int getDoctor_Age() {
		return Doctor_Age;
	}

	public void setDoctor_Age(int cookAge) {
		Doctor_Age = cookAge;
	}

	public String getDoctor_Name() {
		return Doctor_Name;
	}

	public void setDoctor_Name(String cookName) {
		Doctor_Name = cookName;
	}

	public String getDoctor_Specialty() {
		return Doctor_Specialty;
	}

	public void setDoctor_Specialty(String cookSpecialty) {
		Doctor_Specialty = cookSpecialty;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<DoctorBean> list=new DoctorDao().GetList("Doctor_Name='"+Doctor_Name+"' and Doctor_ID!="+Doctor_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('醫院信息已經存在!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		DoctorBean cnbean=new DoctorBean();
		cnbean=new DoctorDao().GetBean(Integer.parseInt(Doctor_ID));
		cnbean.setDoctor_Age(Doctor_Age);
		cnbean.setDoctor_Name(Doctor_Name);
		cnbean.setDoctor_Specialty(Doctor_Specialty);
		new DoctorDao().Update(cnbean);
		    
		out.print("<script language='javascript'>alert('修改成功!');window.location='DoctorManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}
