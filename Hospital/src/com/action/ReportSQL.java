package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReportSQL extends ActionSupport {

	private List<ReportBean> list;
	public List<ReportBean> getList() {
		return list;
	}
	public void setList(List<ReportBean> list) {
		this.list = list;
	}
	private String SearchSQL;
	public String getSearchSQL() {
		return SearchSQL;
	}
	public void setSearchSQL(String searchSQL) {
		SearchSQL = searchSQL;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		list = new ReportDao().GetSQL(SearchSQL);
		
		return SUCCESS;
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
