package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AggInSave extends ActionSupport {

	private List<DoctorBean> list;
	public List<DoctorBean> getList() {
		return list;
	}
	public void setList(List<DoctorBean> list) {
		this.list = list;
	}
	private String SearchRowI;
	private String SearchKeyI;
	public String getSearchRowI() {
		return SearchRowI;
	}
	public void setSearchRowI(String searchRowI) {
		SearchRowI = searchRowI;
	}
	public String getSearchKeyI() {
		return SearchKeyI;
	}
	public void setSearchKeyI(String searchKeyI) {
		SearchKeyI = searchKeyI;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		list=new DoctorDao().GetAggIn(SearchRowI,SearchKeyI);
	
		return SUCCESS;
		
		//SELECT * FROM employee WHERE Doctor_Name IN ('Lisa')
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
