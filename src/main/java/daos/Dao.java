package daos;

import java.time.LocalDate;
import java.util.List;

import models.Employee;
import models.Reimbursement;

public interface Dao {

	    //CREATE
	
		public void addReimbursement(Reimbursement reimbursement);
		
		//READ
		
		public Reimbursement getReimbursement(int reimbursementId);
		public List<Reimbursement> getReimbursementList(int userId);
		public List<Employee> getEmployeeList();
		
		//UPDATE
		
		public void approveReimbursement(int reimbursementId);
		public void denyReimbursement(int reimbursementId);
		
		
		
		//DELETE

		public void deleteReimbursement();//this should only be used for Reimbursements that are not relevant to any sort of data, like joke submissions
		
		
		//FUNCTIONS AND PROCEDURES
		
		
		
	}
