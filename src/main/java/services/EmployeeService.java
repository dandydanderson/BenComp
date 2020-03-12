package services;

import daos.ReimbursementDao;
import models.Employee;

public class EmployeeService {
	
	ReimbursementDao dao = new ReimbursementDao();
	
	
	public Employee checkForUser(String lastName, int employeeId) {
		
		System.out.println("Made it to the Employee Service");
		
		Employee emp = dao.getEmployee(lastName, employeeId);
		
		emp.setReimbursementTotal(dao.getAwardLeft(employeeId));
		
		return  emp;
	}


	public Employee getEmployeeById(int employeeId) {
		return dao.getEmployeeById(employeeId);
		
	}

}
