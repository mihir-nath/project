package services;

import java.util.List;

public class PolicyServiceImplementation implements PolicyService {
     
	
	PolicyDAO policydao=new PolicyDAOImplimentation() {
		
	}
	@Override
	public void createPolicyService(Policy policy) {
		// TODO Auto-generated method stub
		policydao.insertPolicy(policy);
	}

	@Override
	public Policy FindPolicyService(int policyId) {
		// TODO Auto-generated method stub
		return policydao.selectPolicy(policyId);
	}

	@Override
	public List<Policy> findPolicyService() {
		// TODO Auto-generated method stub
		return policydao.selectPolicies();
	}

	@Override
	public void modifyPolicyService(Policy policy) {
		// TODO Auto-generated method stub
		policydao.updatePolicy(policy);
	}

}
