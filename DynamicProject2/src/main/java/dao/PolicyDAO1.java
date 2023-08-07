package dao;

import java.util.List;

import entities.Policy;


public interface PolicyDAO1 {
	public void insertPolicy(Policy policy); //C
	public Policy selectPolicy(int policyId);//R
	public List<Policy> selectPolicies(); //RA
	public void updatePolicy(Policy policy); //U
}
