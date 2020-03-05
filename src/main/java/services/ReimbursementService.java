package services;

import daos.ReimbursementDao;
import models.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDao reimDao = new ReimbursementDao();



	public void addReimbursement(Reimbursement reim) {
		reimDao.addReimbursement(reim);
	}
	
	public void setReimbursementDao(ReimbursementDao reimDao) {
		this.reimDao = reimDao;
	}
}
