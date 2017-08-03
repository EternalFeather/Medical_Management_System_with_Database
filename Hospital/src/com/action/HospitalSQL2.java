package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class HospitalSQL2 extends ActionSupport {

	private String Hospital_ID;
    private String  Hospital_Address ;
    private String  Hospital_Name ;
    private String Hospital_Scale ;
    private String SearchSQL2;
	public String getHospital_ID() {
		return Hospital_ID;
	}

	public void setHospital_ID(String hospitalID) {
		Hospital_ID = hospitalID;
	}
	
	public String getSearchSQL2() {
		return SearchSQL2;
	}

	public void setSearchSQL2(String searchSQL2) {
		SearchSQL2 = searchSQL2;
	}
	
	public String getHospital_Address() {
		return Hospital_Address;
	}

	public void setHospital_Address(String cookAddress) {
		Hospital_Address = cookAddress;
	}

	public String getHospital_Name() {
		return Hospital_Name;
	}

	public void setHospital_Name(String cookName) {
		Hospital_Name = cookName;
	}

	public String getHospital_Scale() {
		return Hospital_Scale;
	}

	public void setHospital_Scale(String cookScale) {
		Hospital_Scale = cookScale;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<HospitalBean> list=new HospitalDao().GetList("Hospital_Name='"+Hospital_Name+"' and Hospital_ID!=" + Hospital_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('醫院信息已經存在');history.back(-1);</script>");
			out.flush();out.close();return null;
		}

		HospitalBean cnbean=new HospitalBean();
		cnbean.setHospital_Address(Hospital_Address);
		cnbean.setHospital_Name(Hospital_Name);
		cnbean.setHospital_Scale(Hospital_Scale);
		new HospitalDao().SQL2(cnbean, SearchSQL2);
		    
		out.print("<script language='javascript'>alert('修改成功!');window.location='HospitalManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public static void main(String[] args) {
		System.out.println();
	}
	
}
