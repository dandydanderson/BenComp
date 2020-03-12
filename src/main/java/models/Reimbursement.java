package models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class Reimbursement {
	private int reimbursementId;
	private int employeeId;
	private Timestamp dateSubmitted;
	private Timestamp eventDate;
	private String approvalState;//this value is actually the manager position
	private double amount;
	private String gradingFormat;
	private boolean active;
	private Timestamp lastApprovalDate;
	private String eventType;
	private String courseName;
	
	//String variables to handle json parsing from form
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	private String StringdateSubmitted;
	private String StringeventDate;
	private String StringlastApprovalDate;
	
	
	
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public String getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Timestamp getLastApprovalDate() {
		return lastApprovalDate;
	}
	public void setLastApprovalDate(Timestamp lastApprovalDate) {
		this.lastApprovalDate = lastApprovalDate;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	
	
	
	
	
	public String getStringdateSubmitted() {
		return StringdateSubmitted;
	}
	public void setStringdateSubmitted(String stringdateSubmitted) {
		StringdateSubmitted = stringdateSubmitted;
	}
	public String getStringeventDate() {
		return StringeventDate;
	}
	public void setStringeventDate(String stringeventDate) {
		StringeventDate = stringeventDate;
	}
	public String getStringlastApprovalDate() {
		return StringlastApprovalDate;
	}
	public void setStringlastApprovalDate(String stringlastApprovalDate) {
		StringlastApprovalDate = stringlastApprovalDate;
	}
	@Override
	public String toString() {
		return "Reimbursement [employeeId=" + employeeId + ", eventDate=" + eventDate + ", approvalState="
				+ approvalState + ", amount=" + amount + ", gradingFormat=" + gradingFormat + ", active=" + active
				+ ", lastApprovalDate=" + lastApprovalDate + ", eventType=" + eventType + "]";
	}
	
	
	

}
