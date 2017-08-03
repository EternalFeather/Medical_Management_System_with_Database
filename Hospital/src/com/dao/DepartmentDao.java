package com.dao;

import com.db.DBHelper;
import com.bean.DepartmentBean;

import java.util.*;
import java.sql.*;

public class DepartmentDao {
	

	public List<DepartmentBean> GetList(String strwhere,String strorder){
		String sql="select * from department";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DepartmentBean> list=new ArrayList<DepartmentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DepartmentBean cnbean=new DepartmentBean();
				cnbean.setDepartment_ID(rs.getInt("Department_ID"));
				cnbean.setDepartment_People(rs.getInt("Department_People"));
				cnbean.setDepartment_Subject(rs.getString("Department_Subject"));
				cnbean.setField(rs.getString("Field"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public DepartmentBean GetBean(int id){
		String sql="select * from department where Department_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DepartmentBean cnbean=new DepartmentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setDepartment_ID(rs.getInt("Department_ID"));
				cnbean.setDepartment_People(rs.getInt("Department_People"));
				cnbean.setDepartment_Subject(rs.getString("Department_Subject"));
				cnbean.setField(rs.getString("Field"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	public void Add(DepartmentBean cnbean){
		String sql="insert into department (";
		sql+="Department_People,Department_Subject,Field";
		sql+=") values(";
		sql+="'"+cnbean.getDepartment_People()+"','"+cnbean.getDepartment_Subject()+"','"+cnbean.getField()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List GetSQL(String str){
		String sql=str;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List list=new ArrayList();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			/*while(rs.next()){
				DepartmentBean cnbean=new DepartmentBean();
				cnbean.setDepartment_ID(rs.getInt("Department_ID"));
				cnbean.setDepartment_People(rs.getInt("Department_People"));
				cnbean.setDepartment_Subject(rs.getString("Department_Subject"));
				cnbean.setField(rs.getString("Field"));
				//cnbean.setField(rs.getString(1));
				list.add(cnbean);
			}*/
			ResultSetMetaData md=rs.getMetaData();
			int columnCount = md.getColumnCount();
			while(rs.next()){
				Map rowData = new HashMap();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            list.add(rowData);
			}
			//System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void SQL2(DepartmentBean cnbean,String str){
		String sql=str;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Update(DepartmentBean cnbean){
		String sql="update department set ";
		sql+="Department_People='"+cnbean.getDepartment_People()+"',";
		sql+="Department_Subject='"+cnbean.getDepartment_Subject()+"',";;
		sql+="Field='"+cnbean.getField()+"'";
		sql+=" where Department_ID='"+cnbean.getDepartment_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Delete(String strwhere){
		String sql="delete from department where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

