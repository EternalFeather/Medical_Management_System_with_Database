package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DepartmentSQL2 extends ActionSupport {

	private String Department_ID;
    private int  Department_People ;
    private String  Department_Subject ;
    private String Field ;
    private String SearchSQL2;
	public String getDepartment_ID() {
		return Department_ID;
	}

	public void setDepartment_ID(String DepartmentID) {
		Department_ID = DepartmentID;
	}
	
	public String getSearchSQL2() {
		return SearchSQL2;
	}

	public void setSearchSQL2(String searchSQL2) {
		SearchSQL2 = searchSQL2;
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

	public void setField(String cookSpecialty) {
		Field = cookSpecialty;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<DepartmentBean> list=new DepartmentDao().GetList("Department_Subject='"+Department_Subject+"' and Department_ID!=" + Department_ID, "");
		if(list.size()>0)
		{
			out.print("<script languPeople='javascript'>alert('���T��Ϣ�ѽ�����');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		DepartmentBean cnbean=new DepartmentBean();
		cnbean.setDepartment_People(Department_People);
		cnbean.setDepartment_Subject(Department_Subject);
		cnbean.setField(Field);
		new DepartmentDao().SQL2(cnbean, SearchSQL2);
		    
		out.print("<script languPeople='javascript'>alert('�޸ĳɹ�!');window.location='DepartmentManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}