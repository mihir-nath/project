package service;

import java.util.List;
import dao.InsuranceDAO;
import dao.InsuranceDAOImplementation;

import entities.Insurance;

public class RenewInsuranceServiceImplementation implements RenewInsuranceService {
             InsuranceDAO insDAO=new InsuranceDAOImplementation();
	@Override
	public Insurance findExpiredInsuranceService(int policyNumber) {
		// TODO Auto-generated method stub
		   return insDAO.selectInsurance(policyNumber);
	}

	@Override
	public List<Insurance> findExpiredInsuranceServices() {
		// TODO Auto-generated method stub
		return insDAO.selectInsurance();
	}

	@Override
	public void modefyExpiredInsuranceService(Insurance ins) {
		// TODO Auto-generated method stub
                 insDAO.updateInsurance(ins);
	}

}
