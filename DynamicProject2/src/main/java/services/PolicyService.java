package services;

import java.util.List;

import entities.Policy;

public interface PolicyService {
	 void createPolicyService(Policy policy);
     Policy FindPolicyService(int policyId);
     List<Policy> findPolicyService();
     void modifyPolicyService(Policy policy);
}
