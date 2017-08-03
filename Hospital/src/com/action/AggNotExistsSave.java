package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AggNotExistsSave extends ActionSupport {

	private List<DoctorBean> list;
	public List<DoctorBean> getList() {
		return list;
	}
	public void setList(List<DoctorBean> list) {
		this.list = list;
	}
	private String SearchRowNE;
	private String SearchKeyNE;
	public String getSearchRowNE() {
		return SearchRowNE;
	}
	public void setSearchRowNE(String searchRowNE) {
		SearchRowNE = searchRowNE;
	}
	public String getSearchKeyE() {
		return SearchKeyNE;
	}
	public void setSearchKeyE(String searchKeyNE) {
		SearchKeyNE = searchKeyNE;
	}

	public String execute() throws Exception {
		
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String strWhere=null;
		if(!(isInvalid(SearchKeyNE)))
		{
			strWhere =SearchRowNE+"='"+SearchKeyNE+"'";
		}

		list=new DoctorDao().GetAggNotExists(strWhere);
	
		return SUCCESS;
		
		//SELECT * FROM employee WHERE EXISTS (SELECT * FROM department WHERE FIELD=Specialty AND Specialty="¿´×o")
		
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
	
}
