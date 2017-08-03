package com.dao;

import com.db.DBHelper;
import com.bean.PatientBean;

import java.util.*;
import java.sql.*;

public class PatientDao {
	

	public List<PatientBean> GetList(String strwhere,String strorder){
		String sql="select * from patient";
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
		List<PatientBean> list=new ArrayList<PatientBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				PatientBean cnbean=new PatientBean();
				cnbean.setPatient_ID(rs.getInt("Patient_ID"));
				cnbean.setPatient_Age(rs.getInt("Patient_Age"));
				cnbean.setPatient_Disease(rs.getString("Patient_Disease"));
				cnbean.setPatient_Name(rs.getString("Patient_Name"));
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

	public PatientBean GetBean(int id){
		String sql="select * from patient where Patient_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		PatientBean cnbean=new PatientBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setPatient_ID(rs.getInt("Patient_ID"));
				cnbean.setPatient_Age(rs.getInt("Patient_Age"));
				cnbean.setPatient_Disease(rs.getString("Patient_Disease"));
				cnbean.setPatient_Name(rs.getString("Patient_Name"));
				
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
	
	public void Add(PatientBean cnbean){
		String sql="insert into patient (";
		sql+="Patient_Age,Patient_Disease,Patient_Name";
		sql+=") values(";
		sql+="'"+cnbean.getPatient_Age()+"','"+cnbean.getPatient_Disease()+"','"+cnbean.getPatient_Name()+"'";
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
				PatientBean cnbean=new PatientBean();
				cnbean.setPatient_ID(rs.getInt("Patient_ID"));
				cnbean.setPatient_Age(rs.getInt("Patient_Age"));
				cnbean.setPatient_Disease(rs.getString("Patient_Disease"));
				cnbean.setPatient_Name(rs.getString("Patient_Name"));
				//cnbean.setPatient_Name(rs.getString(1));
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
	
	public void SQL2(PatientBean cnbean,String str){
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
	
	public void Update(PatientBean cnbean){
		String sql="update patient set ";
		sql+="Patient_Age='"+cnbean.getPatient_Age()+"',";
		sql+="Patient_Disease='"+cnbean.getPatient_Disease()+"',";;
		sql+="Patient_Name='"+cnbean.getPatient_Name()+"'";
		sql+=" where Patient_ID='"+cnbean.getPatient_ID()+"'";
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
		String sql="delete from patient where ";
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

