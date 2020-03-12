package services;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import daos.ReimbursementDao;
import models.Employee;
import models.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDao reimDao = new ReimbursementDao();

	


	public void addReimbursement(Reimbursement reim) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		reim.setDateSubmitted(now);
		reim.setLastApprovalDate(now);
		
		reimDao.addReimbursement(reim);
	}
	
	public List<Reimbursement> getReimbursementList(Employee employee) {
		

		System.out.println("Made it into the Service.");
		return reimDao.getReimbursementList(employee.getEmployeeId());
		
	}
	
	public List<Reimbursement> getManagerReimbursementList(Employee employee){
		

		return reimDao.getManagerReimbursementList(employee.getPosition());
		
		
	}
	
	
	
	
	public void setReimbursementDao(ReimbursementDao reimDao) {
		this.reimDao = reimDao;
	}

	public Reimbursement getReimbursementById(int reimIdInt) {
		
		return reimDao.getReimbursement(reimIdInt);
			
	}
	
	
	public void denyReimbursement(int reimbursementId) {
		
		System.out.println("made it into denyReim in ReimService");
		reimDao.denyReimbursement(reimbursementId);
	}

	public void approveReimbursement(int reimbursementId, String approvalState, int employeeId) {
		
		String newState = "approvalState";
		
		switch(approvalState) {
		
		case "Detention Sergeant":
			newState = "Detention Captain";
			break;
		case "Detention Captain":
			newState = "Lieutenant";
			break;
		case "Patrol Sergeant":
			newState = "Patrol Captain";
			break;
		case "Patrol Captain":
			newState = "Lieutenant";
			break;
		case "CID Sergeant":
			newState = "CID Captain";
			break;
		case "CID Captain":
			newState = "Lieutenant";
			break;
		case "Lieutenant":
			if(employeeId==8) {
			newState = "Approved";	
			}
		   else {newState = "Major";}
			break;
		case "Major":
			newState = "Approved";
			break;
			
		
		}
		
		
		reimDao.approveReimbursement(reimbursementId, newState);
		
	}
	

}
