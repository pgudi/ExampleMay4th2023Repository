package com.sgtesting.tests.pojo;

public class Students {
	
	private int rollNo;
	private String firstName;
	private String emailId;
	private String branchName;
	
	public Students()
	{
		
	}
	public Students(int rollNo, String firstName, String emailId, String branchName) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.emailId = emailId;
		this.branchName = branchName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "Students [rollNo=" + rollNo + ", firstName=" + firstName + ", emailId=" + emailId + ", branchName="
				+ branchName + "]";
	}

}
