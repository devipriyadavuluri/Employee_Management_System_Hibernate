package com.Employee_Management_System_Hibernate;

import java.util.Scanner;

import com.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeservice = new EmployeeService();
		System.out.println(
				" enter \n 1.employee registraion \n 2.Display employee details \n 3.updte emloyee details by using employee id \n 4.delete employee details by using employee id \n 5.to update employee salary by using employee deptno");
		switch (sc.nextInt()) {
		case 1:
			employeeservice.employeeRegistration();
			break;
		case 2:
			employeeservice.getTheDetails();
			break;
		case 3:
			employeeservice.updateEmployeeMobilenumberByUsingEmpID();
			break;
		case 4:
			employeeservice.deleteEmployeeByUsingEmpId();
			break;
		case 5:
		//	employeeservice.updateSalaryByUsingDeptNumber();
		//	employeeservice.updateEmployyEmailIdByUsingMobileNumber();
			employeeservice.updateMobileNumberByUsingEmailId();
			
			break;
			
		}
	}
}
