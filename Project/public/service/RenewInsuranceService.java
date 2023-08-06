package service;

import java.util.List;

import entities.Insurance;


public interface RenewInsuranceService {
       Insurance findExpiredInsuranceService(int policyNumber);
       List<Insurance> findExpiredInsuranceServices();
       void modefyExpiredInsuranceService(Insurance ins);
}
