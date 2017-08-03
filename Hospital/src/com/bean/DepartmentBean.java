package com.bean;
public class DepartmentBean {

    private int Department_ID ;
    private String Department_Subject ;
    private int Department_People ;
    private String Field ;
	public int getDepartment_ID() {
		return Department_ID;
	}
	public void setDepartment_ID(int DepartmentID) {
		Department_ID = DepartmentID;
	}
	public String getDepartment_Subject() {
		return Department_Subject;
	}
	public void setDepartment_Subject(String DepartmentSubject) {
		Department_Subject = DepartmentSubject;
	}
	public int getDepartment_People() {
		return Department_People;
	}
	public void setDepartment_People(int DepartmentPeople) {
		Department_People = DepartmentPeople;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
}
