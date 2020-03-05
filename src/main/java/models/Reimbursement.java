package models;

import java.time.LocalDate;
import java.util.Date;

public class Reimbursement {
	
	private int employeeId;
	private LocalDate dateSubmitted;
	private LocalDate eventDate;
	private String approvalState;//this value is actually the manager position
	private double amount;
	private String gradingFormat;
	private boolean active;
	private LocalDate lastApprovalDate;
	private String eventType;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
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
	public LocalDate getLastApprovalDate() {
		return lastApprovalDate;
	}
	public void setLastApprovalDate(LocalDate lastApprovalDate) {
		this.lastApprovalDate = lastApprovalDate;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDate getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(LocalDate dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	@Override
	public String toString() {
		return "Reimbursement [employeeId=" + employeeId + ", eventDate=" + eventDate + ", approvalState="
				+ approvalState + ", amount=" + amount + ", gradingFormat=" + gradingFormat + ", active=" + active
				+ ", lastApprovalDate=" + lastApprovalDate + ", eventType=" + eventType + "]";
	}
	
	
	

}
