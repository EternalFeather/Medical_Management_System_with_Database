package com.dao;

import com.db.DBHelper;
import com.bean.DoctorBean;

import java.util.*;
import java.sql.*;

public class DoctorDao {
	

	public List<DoctorBean> GetList(String strwhere,String strorder){
		String sql="select * from employee";
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
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public List<DoctorBean> GetFunc(String SearchRowF1,String SearchRowF2){
		//SELECT Doctor_Specialty as Groupby,AVG(Doctor_Age) AS Result FROM employee GROUP BY Doctor_Specialty
		String sql="select "+SearchRowF1+" as Groupby,"+SearchRowF2+" as Result from employee group by "+SearchRowF1;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setGroup(rs.getString("Groupby"));
				cnbean.setResult(rs.getString("Result"));
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
	
	public List<DoctorBean> GetAggExists(String strwhere){
		//SELECT * FROM employee WHERE EXISTS (SELECT * FROM department WHERE FIELD=Specialty...
		String sql="select * from employee where exists (select * from department where field=Doctor_specialty and "+strwhere+")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public List<DoctorBean> GetAggNotExists(String strwhere){
		//SELECT * FROM employee WHERE EXISTS (SELECT * FROM department WHERE FIELD=Specialty...
		String sql="select * from employee where not exists (select * from department where field=Doctor_specialty)";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public List<DoctorBean> GetAggIn(String SearchRow,String SearchKey){
		//SELECT * FROM employee WHERE Doctor_Name IN ('Lisa')
		String sql="select * from employee where "+SearchRow+" in ('"+SearchKey+"')";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public List GetFuncSQL(String str){
		//SELECT Doctor_Specialty as Groupby,AVG(Doctor_Age) AS Result FROM employee GROUP BY Doctor_Specialty
		String sql=str;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List list=new ArrayList();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			/*while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setGroup(rs.getString("Groupby"));
				cnbean.setResult(rs.getString("Result"));
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
	
	public List GetAggSQL(String str){
		String sql=str;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List list=new ArrayList();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			/*while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public List<DoctorBean> GetAggNotIn(String SearchRow,String SearchKey){
		//SELECT * FROM employee WHERE Doctor_Name not IN ('Lisa')
		String sql="select * from employee where "+SearchRow+" not in ('"+SearchKey+"')";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DoctorBean> list=new ArrayList<DoctorBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
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
	
	public DoctorBean GetBean(int id){
		String sql="select * from employee where Doctor_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DoctorBean cnbean=new DoctorBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
				
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
	
	public void Add(DoctorBean cnbean){
		String sql="insert into employee (";
		sql+="Doctor_Age,Doctor_Name,Doctor_Specialty";
		sql+=") values(";
		sql+="'"+cnbean.getDoctor_Age()+"','"+cnbean.getDoctor_Name()+"','"+cnbean.getDoctor_Specialty()+"'";
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
				DoctorBean cnbean=new DoctorBean();
				cnbean.setDoctor_ID(rs.getInt("Doctor_ID"));
				cnbean.setDoctor_Age(rs.getInt("Doctor_Age"));
				cnbean.setDoctor_Name(rs.getString("Doctor_Name"));
				cnbean.setDoctor_Specialty(rs.getString("Doctor_Specialty"));
				//cnbean.setDoctor_Specialty(rs.getString(1));
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
	
	public void SQL2(DoctorBean cnbean,String str){
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
	
	public void Update(DoctorBean cnbean){
		String sql="update employee set ";
		sql+="Doctor_Age='"+cnbean.getDoctor_Age()+"',";
		sql+="Doctor_Name='"+cnbean.getDoctor_Name()+"',";;
		sql+="Doctor_Specialty='"+cnbean.getDoctor_Specialty()+"'";
		sql+=" where Doctor_ID='"+cnbean.getDoctor_ID()+"'";
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
		String sql="delete from employee where ";
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

