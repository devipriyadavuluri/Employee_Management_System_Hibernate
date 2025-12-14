package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_details")
public class EmployeeDetails {
	@Id
	@Column(name="Employee_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	@Column(name="Employee_name" ,nullable=false)
	private String empname;
	@Column(name="Emp_Salary" ,nullable=false)
	private double empsalary;
	@Column(name="Employee_DeptNo", nullable=false)
	private int empdeptno;
	@Column(name="Email_Id",nullable=false,unique=true)
	private String empEmailId;
	@Column(name="Emp_Mobile_Num",nullable=false,unique=true)
	private  long empMobileNo;
	public EmployeeDetails()
	{
		
	}
	public EmployeeDetails(int empid, String empname, double empsalary, int empdeptno, String empEmailId,
			long empMobileNo) {

		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.empdeptno = empdeptno;
		this.empEmailId = empEmailId;
		this.empMobileNo = empMobileNo;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}
	public int getEmpdeptno() {
		return empdeptno;
	}
	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public long getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	

}
