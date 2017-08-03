package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class FuncSearch extends ActionSupport {

	private List<DoctorBean> list;
	public List<DoctorBean> getList() {
		return list;
	}
	public void setList(List<DoctorBean> list) {
		this.list = list;
	}
	private String SearchRowF1;
	private String SearchRowF2;
	public String getSearchRowF1() {
		return SearchRowF1;
	}
	public void setSearchRowF1(String searchRowF1) {
		SearchRowF1 = searchRowF1;
	}
	public String getSearchRowF2() {
		return SearchRowF2;
	}
	public void setSearchRowF2(String searchRowF2) {
		SearchRowF2 = searchRowF2;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
				
		list=new DoctorDao().GetFunc(SearchRowF1,SearchRowF2);
	
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
