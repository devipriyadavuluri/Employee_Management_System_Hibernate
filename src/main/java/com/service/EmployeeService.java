package com.service;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.entity.EmployeeDetails;

public class EmployeeService {
	Scanner sc = new Scanner(System.in);
	EmployeeDAO employeedao = new EmployeeDAO();

	public void employeeRegistration() {
		System.out.println("enter employee name:");
		String name = sc.next();
		System.out.println("enter employee email id:");
		String id = sc.next();
		System.out.println("enter employee mobile number:");
		long number = sc.nextLong();
		System.out.println("enter employee deptno: ");
		int deptno = sc.nextInt();
		System.out.println("enter employee salary:");
		int salary = sc.nextInt();
		EmployeeDetails employedetails = new EmployeeDetails();
		employedetails.setEmpdeptno(deptno);
		employedetails.setEmpEmailId(id);
		employedetails.setEmpMobileNo(number);
		employedetails.setEmpsalary(salary);
		employedetails.setEmpname(name);
		employeedao.insertionOperation(employedetails);

	}

	public void getTheDetails() {
		System.out.println("enter employee id");
		int id = sc.nextInt();
		employeedao.findEmployeeDetailsByUsingEmpId(id);
	}

	public void updateEmployeeMobilenumberByUsingEmpID() {
		System.out.println("enter employee mobilenumber");
		long empNumber = sc.nextLong();
		System.out.println("enter employee id");
		int id=sc.nextInt();
		employeedao.updateEmployeeMobileNumberByUsingEmpId(id, empNumber);

	}
	public void deleteEmployeeByUsingEmpId()
	{
		System.out.println("enter Employee Id");
		int id=sc.nextInt();
		employeedao.deleteEmployeeByUsingEmpId(id);
	}
	public void updateSalaryByUsingDeptNumber()
	{
		System.out.println("enter employee salary:");
		double salary=sc.nextDouble();
		System.out.println("enter employee deptno:");
		int deptno=sc.nextInt();
		employeedao.updateEmployeeSalaryByUsingEmpDeptNO(salary,deptno);
	}
	public void updateEmployyEmailIdByUsingMobileNumber()
	{
		System.out.println("enter employee emailId");
		String email=sc.next();
		System.out.println("enter employee mobile number");
		long mobileNumber=sc.nextLong();
		employeedao.toUpdateEmailIdByUsingMobileNumber(email, mobileNumber);
	}
	public void updateMobileNumberByUsingEmailId()
	{
		System.out.println("enter mobile number");
		long number=sc.nextLong();
		System.out.println("enter emailid");
		String email=sc.next();
		employeedao.updateMobileNumberByUsingEmailId( number,email);
	}

}
