package com.dao;

import com.db.DBHelper;
import com.bean.HospitalBean;

import java.util.*;
import java.sql.*;

public class HospitalDao {
	

	public List<HospitalBean> GetList(String strwhere,String strorder){
		String sql="select * from hospital";
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
		List<HospitalBean> list=new ArrayList<HospitalBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				HospitalBean cnbean=new HospitalBean();
				//if(rs.findColumn("Hospital_ID")>0)
				cnbean.setHospital_ID(rs.getInt("Hospital_ID"));
				cnbean.setHospital_Address(rs.getString("Hospital_Address"));
				cnbean.setHospital_Name(rs.getString("Hospital_Name"));
				cnbean.setHospital_Scale(rs.getString("Hospital_Scale"));
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
	
	public HospitalBean GetBean(int id){
		String sql="select * from hospital where Hospital_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		HospitalBean cnbean=new HospitalBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setHospital_ID(rs.getInt("Hospital_ID"));
				cnbean.setHospital_Address(rs.getString("Hospital_Address"));
				cnbean.setHospital_Name(rs.getString("Hospital_Name"));
				cnbean.setHospital_Scale(rs.getString("Hospital_Scale"));
				
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
	
	public void Add(HospitalBean cnbean){
		String sql="insert into hospital (";
		sql+="Hospital_Address,Hospital_Name,Hospital_Scale";
		sql+=") values(";
		sql+="'"+cnbean.getHospital_Address()+"','"+cnbean.getHospital_Name()+"','"+cnbean.getHospital_Scale()+"'";
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
				HospitalBean cnbean=new HospitalBean();				
				cnbean.setHospital_ID(rs.getInt("Hospital_ID"));
				cnbean.setHospital_Address(rs.getString("Hospital_Address"));
				cnbean.setHospital_Name(rs.getString("Hospital_Name"));
				cnbean.setHospital_Scale(rs.getString("Hospital_Scale"));
				//cnbean.setHospital_Scale(rs.getString(1));
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
	
	public void SQL2(HospitalBean cnbean,String str){
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
	
	public void Update(HospitalBean cnbean){
		String sql="update hospital set ";
		sql+="Hospital_Address='"+cnbean.getHospital_Address()+"',";
		sql+="Hospital_Name='"+cnbean.getHospital_Name()+"',";;
		sql+="Hospital_Scale='"+cnbean.getHospital_Scale()+"'";
		sql+=" where Hospital_ID='"+cnbean.getHospital_ID()+"'";
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
		String sql="delete from hospital where ";
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

