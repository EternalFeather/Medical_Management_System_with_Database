package com.dao;

import com.db.DBHelper;
import com.bean.ReportBean;

import java.util.*;
import java.sql.*;

public class ReportDao {
	

	public List<ReportBean> GetList(String strwhere,String strorder){
		String sql="select * from report";
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
		List<ReportBean> list=new ArrayList<ReportBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ReportBean cnbean=new ReportBean();
				cnbean.setReport_ID(rs.getInt("Report_ID"));
				cnbean.setReport_Disease(rs.getString("Report_Disease"));
				cnbean.setReport_PatientName(rs.getString("Report_PatientName"));
				cnbean.setReport_Medicine(rs.getString("Report_Medicine"));
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
	
	public ReportBean GetBean(int id){
		String sql="select * from report where Report_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ReportBean cnbean=new ReportBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setReport_ID(rs.getInt("Report_ID"));
				cnbean.setReport_Disease(rs.getString("Report_Disease"));
				cnbean.setReport_PatientName(rs.getString("Report_PatientName"));
				cnbean.setReport_Medicine(rs.getString("Report_Medicine"));
				
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
	
	public void Add(ReportBean cnbean){
		String sql="insert into report (";
		sql+="Report_Disease,Report_PatientName,Report_Medicine";
		sql+=") values(";
		sql+="'"+cnbean.getReport_Disease()+"','"+cnbean.getReport_PatientName()+"','"+cnbean.getReport_Medicine()+"'";
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
				ReportBean cnbean=new ReportBean();
				cnbean.setReport_ID(rs.getInt("Report_ID"));
				cnbean.setReport_Disease(rs.getString("Report_Disease"));
				cnbean.setReport_PatientName(rs.getString("Report_PatientName"));
				cnbean.setReport_Medicine(rs.getString("Report_Medicine"));
				//cnbean.setReport_Medicine(rs.getString(1));
				list.add(cnbean);
			}*/ResultSetMetaData md=rs.getMetaData();
			int columnCount = md.getColumnCount();
			while(rs.next()){
				Map rowData = new HashMap();
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            list.add(rowData);
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
	
	public void SQL2(ReportBean cnbean,String str){
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
	
	public void Update(ReportBean cnbean){
		String sql="update report set ";
		sql+="Report_Disease='"+cnbean.getReport_Disease()+"',";
		sql+="Report_PatientName='"+cnbean.getReport_PatientName()+"',";;
		sql+="Report_Medicine='"+cnbean.getReport_Medicine()+"'";
		sql+=" where Report_ID='"+cnbean.getReport_ID()+"'";
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
		String sql="delete from report where ";
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

