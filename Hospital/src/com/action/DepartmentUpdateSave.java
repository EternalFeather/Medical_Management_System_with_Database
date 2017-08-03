package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DepartmentUpdateSave extends ActionSupport {

	private String Department_ID ;
    private int Department_People ;
    private String Department_Subject ;
    private String Field ;
	public String getDepartment_ID() {
		return Department_ID;
	}

	public void setDepartment_ID(String cookID) {
		Department_ID = cookID;
	}

	public int getDepartment_People() {
		return Department_People;
	}

	public void setDepartment_People(int cookPeople) {
		Department_People = cookPeople;
	}

	public String getDepartment_Subject() {
		return Department_Subject;
	}

	public void setDepartment_Subject(String cookSubject) {
		Department_Subject = cookSubject;
	}

	public String getField() {
		return Field;
	}

	public void setField(String cookField) {
		Field = cookField;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<DepartmentBean> list=new DepartmentDao().GetList("Department_Subject='"+Department_Subject+"' and Department_ID!="+Department_ID, "");
		if(list.size()>0)
		{
			out.print("<script languPeople='javascript'>alert('部門信息已經存在!');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		DepartmentBean cnbean=new DepartmentBean();
		cnbean=new DepartmentDao().GetBean(Integer.parseInt(Department_ID));
		cnbean.setDepartment_People(Department_People);
		cnbean.setDepartment_Subject(Department_Subject);
		cnbean.setField(Field);
		new DepartmentDao().Update(cnbean);
		    
		out.print("<script languPeople='javascript'>alert('修改成功!');window.location='DepartmentManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}
