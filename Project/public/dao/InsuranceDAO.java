package dao;

import java.util.List;

import entities.Insurance;

public interface InsuranceDAO {
	public void insertInsurance(Insurance ins); //C
	public Insurance selectInsurance(int regNumber);//R
	public List<Insurance> selectInsurance(); //RA
	public void updateInsurance(Insurance ins); //U
	public void deleteInsurance(int regNumber);
}
