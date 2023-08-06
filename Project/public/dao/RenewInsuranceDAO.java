package dao;

import java.util.List;

import entities.Insurance;

public interface RenewInsuranceDAO {
        public Insurance selectExpiredInsurance(int policyNumber);
        public List<Insurance> selectExpiredInsurances();
        public void updateExpiredInsurance(Insurance ins);
}
