package com.bean;
public class DoctorBean {

    private int Doctor_ID ;
    private String Doctor_Name ;
    private int Doctor_Age ;
    private String Doctor_Specialty ;
    private String Result;
    private String Group;
    private float Sum;
    private float Count;
    private float Max;
    private float Min;
    private float Avg;
    public float getSum() {
		return Sum;
	}
	public void setSum(float sum) {
		Sum = sum;
	}
	public float getCount() {
		return Count;
	}
	public void setCount(float count) {
		Count = count;
	}
	public float getMax() {
		return Max;
	}
	public void setMax(float max) {
		Max = max;
	}
	public float getMin() {
		return Min;
	}
	public void setMin(float min) {
		Min = min;
	}
	public float getAvg() {
		return Avg;
	}
	public void setAvg(float avg) {
		Avg = avg;
	}
	
	public int getDoctor_ID() {
		return Doctor_ID;
	}
	public void setDoctor_ID(int DoctorID) {
		Doctor_ID = DoctorID;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getGroup() {
		return Group;
	}
	public void setGroup(String group) {
		Group = group;
	}
	public String getDoctor_Name() {
		return Doctor_Name;
	}
	public void setDoctor_Name(String DoctorName) {
		Doctor_Name = DoctorName;
	}
	public int getDoctor_Age() {
		return Doctor_Age;
	}
	public void setDoctor_Age(int DoctorAge) {
		Doctor_Age = DoctorAge;
	}
	public String getDoctor_Specialty() {
		return Doctor_Specialty;
	}
	public void setDoctor_Specialty(String DoctorSpecialty) {
		Doctor_Specialty = DoctorSpecialty;
	}
}
