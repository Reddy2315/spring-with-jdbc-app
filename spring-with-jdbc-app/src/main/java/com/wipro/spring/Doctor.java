package com.wipro.spring;

public class Doctor {

	private long regNo;
	private String name;
	private String specilization;
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	@Override
	public String toString() {
		return "Doctor [regNo=" + regNo + ", name=" + name + ", specilization=" + specilization + "]";
	}
	
	
	
}
