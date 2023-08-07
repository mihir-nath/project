package entities;

import java.util.Date;

public class Policy {
	private int policyId; 
	private int userId;
	private int vehicleId;
	private String startDate; 
	private String endDate;
	private float premiumAmount;
	private  boolean policyStatus; 
	private String policyNumber;
	
	
	public Policy() {
		
	}


	public int getPolicyId() {
		return policyId;
	}


	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public float getPremiumAmount() {
		return premiumAmount;
	}


	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}


	public boolean isPolicyStatus() {
		return policyStatus;
	}


	public void setPolicyStatus(boolean policyStatus) {
		this.policyStatus = policyStatus;
	}


	public String getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	
	
}
