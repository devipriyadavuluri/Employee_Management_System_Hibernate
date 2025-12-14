package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.EmployeeDetails;

public class EmployeeDAO {
	public void insertionOperation(EmployeeDetails employeedetails) {
		/* 1) load the persistence.xml file */
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Employee_Management_System_Hibernate");
		/*
		 * 2. Established the connection 3. Creating the platform
		 */
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTranscation = entitymanager.getTransaction();
		/* 4. Begin the transaction */
		entityTranscation.begin();
		entitymanager.persist(employeedetails);
		System.out.println("data inserted");

		/*
		 * 5. performing the operation . insertion . update .deletion .selection
		 */
		/* 6. committing transcation */
		entityTranscation.commit();
	}

	public void findEmployeeDetailsByUsingEmpId(int empid) {
		EntityManagerFactory entitymanagerfactory = Persistence
				.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entityManager = entitymanagerfactory.createEntityManager();
		EntityTransaction entityTranscation = entityManager.getTransaction();
		entityTranscation.begin();
		EmployeeDetails employeedetails = entityManager.find(EmployeeDetails.class, 2);
		if (employeedetails != null) {
			System.out.println("employee dept no:" + employeedetails.getEmpdeptno());
			System.out.println("Employee name:" + employeedetails.getEmpname());
			System.out.println("Employee Mobile bumber:" + employeedetails.getEmpMobileNo());
		} else {
			System.out.println("data is not found.");
		}
	}
	public void updateEmployeeMobileNumberByUsingEmpId(int empid,long MobileNumber )
	{
		EntityManagerFactory entitymanagerfactory=
		Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		EntityTransaction entitytranscation=entitymanager.getTransaction();
		entitytranscation.begin();
		EmployeeDetails employeedetails =entitymanager.find(EmployeeDetails.class,empid);
		if(employeedetails!=null)
		{
			employeedetails.setEmpMobileNo(MobileNumber);
			System.out.println("update sucessfully.......");
		}
		else
		{
			System.out.println("data is not found....");
		}
		entitytranscation.commit();
		
	}
	public void deleteEmployeeByUsingEmpId(int empid)
	{
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		EntityTransaction entitytranscation=entitymanager.getTransaction();
		entitytranscation.begin();
		EmployeeDetails employeedetails=entitymanager.find(EmployeeDetails.class, empid);
		if(employeedetails!=null)
		{
			entitymanager.remove(employeedetails);
		}
		else
		{
			System.out.println("data is not found");
		}
		entitytranscation.commit();
		
	}
	public void updateEmployeeSalaryByUsingEmpDeptNO(double salary, int deptno)
	{
		String Update="update EmployeeDetails emp set emp.empsalary=?1 where emp.empdeptno=?2";
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanger=entitymanagerfactory.createEntityManager();
		EntityTransaction entitytrnscation=entitymanger.getTransaction();
		entitytrnscation.begin();
		Query query=entitymanger.createQuery(Update);
		query.setParameter(1, salary);
		query.setParameter(2, deptno);
		int result=query.executeUpdate();
		if(result!=0) {
			System.out.println("salary update sucessfully..");
		}
		else
		{
			System.out.println("no data found");
		}
		entitytrnscation.commit();
		
	}
	public static void deleteEmployeeEmailId()
	{
		String delete="delete  from EmployeeDetails emp where emp.empEmailId='suman@gmail.com'";
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanger=entitymanagerfactory.createEntityManager();
		EntityTransaction transcation=entitymanger.getTransaction();
		transcation.begin();
		Query query=entitymanger.createQuery(delete);
		int result=query.executeUpdate();
		if(result!=0)
		{
			System.out.println("update succesfully....");
		}
		else
		{
			System.out.println("no data found..");
		}
		transcation.commit();
	}
	/*  write a hibernate program to update the emailid of employee by using mobile number*/
	public void toUpdateEmailIdByUsingMobileNumber(String emailId,long mobilenumber)
	{
		String update="update EmployeeDetails emp set  emp.empEmailId=?1  where emp.empMobileNo=?2";
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		EntityTransaction transcation=entitymanager.getTransaction();
		transcation.begin();
		Query query=entitymanager.createQuery(update);
		query.setParameter(1, emailId);
		query.setParameter(2, mobilenumber);
		int result=query.executeUpdate();
		if(result!=0)
		{
			System.out.println("excute sucessfully......");
		}
		else
		{
			System.out.println("no data found.............");
		}
		transcation.commit();
	}
	public void updateMobileNumberByUsingEmailId(long number,String emailId)
	{
		String update="update EmployeeDetails emp set emp.empMobileNo=:mobilenumber where emp.empEmailId=:emailid";
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("Employee_Management_System_Hibernate");
		EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		EntityTransaction entitytranscation=entitymanager.getTransaction();
		entitytranscation.begin();
		Query query=entitymanager.createQuery(update);
		query.setParameter("mobilenumber", number);
		query.setParameter("emailid", emailId);
		int result=query.executeUpdate();
		if(result!=0)
		{
			System.out.println("update sucessfully............");
		}
		else
		{
			System.out.println("no data found.........");
		}
	}
	
		
}
