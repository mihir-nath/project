package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Insurance;

public class InsuranceDAOImplementation implements InsuranceDAO {
       Connection conn ; //GLOBAL 
	
	public InsuranceDAOImplementation() 
	{
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertInsurance(Insurance ins) {
		
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO INSDB VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setBoolean(1, ins.isTwoWheeler());
			pst.setBoolean(2, ins.isFourWheeler());
			pst.setString(4, ins.getVehcileModel());
			pst.setString(3,ins.getVehcileManufacturer());
			pst.setString(5, ins.getDrivingLicense());
			pst.setString(6,ins.getPurchaseDate());
			pst.setInt(7, ins.getRegistrationNumber());
			pst.setString(8,ins.getEngineNumber());
			pst.setString(9, ins.getChasisNumber());
			pst.setBoolean(10,ins.isThirdPartyLiabilityInsurance());
			pst.setBoolean(11,ins.isComprehensiveInsurance());
			pst.setBoolean(12,ins.isOneYear());
			pst.setBoolean(13,ins.isTwoYear());
			pst.setBoolean(14,ins.isThreeYear());
			pst.setBoolean(15,ins.isPlanStatus());
			pst.setInt(16,ins.getAmount());
			
			
			System.out.println("PreparedStatement is created : "+ pst);
			
			
			int rows = pst.executeUpdate();
			
			System.out.println("Rows created : "+rows);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
    public Insurance selectInsurance(int regNumber) {
		
    	Insurance insObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			
			ResultSet result = statement.executeQuery("SELECT * FROM INSDB WHERE REGNO="+regNumber);
			
			//5. process teh result if any
			if(result.next()) {
				insObj = new Insurance(); 
				
				insObj.setTwoWheeler(result.getBoolean(1));
				insObj.setFourWheeler(result.getBoolean(2));
				insObj.setVehcileModel(result.getString(4));
				insObj.setVehcileManufacturer(result.getString(3));
				insObj.setDrivingLicense(result.getString(5));
				insObj.setPurchaseDate(result.getString(6));
				insObj.setRegistrationNumber(result.getInt(7));
				insObj.setEngineNumber(result.getString(8));
				insObj.setChasisNumber(result.getString(9));
				insObj.setThirdPartyLiabilityInsurance(result.getBoolean(10));
				insObj.setComprehensiveInsurance(result.getBoolean(11));
				insObj.setOneYear(result.getBoolean(12));
				insObj.setTwoYear(result.getBoolean(13));
				insObj.setThreeYear(result.getBoolean(14));
				insObj.setPlanStatus(result.getBoolean(15));
				insObj.setAmount(result.getInt(16));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insObj;
	}
    
   public List<Insurance> selectInsurance() {
		
		List<Insurance> insList = new ArrayList<Insurance>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			
			ResultSet result = statement.executeQuery("SELECT * FROM INSDB");
			
			
			while(result.next()) 
			{
				Insurance insObj = new Insurance(); 
				
				insObj.setTwoWheeler(result.getBoolean(1));
				insObj.setFourWheeler(result.getBoolean(2));
				insObj.setVehcileModel(result.getString(4));
				insObj.setVehcileManufacturer(result.getString(3));
				insObj.setDrivingLicense(result.getString(5));
				insObj.setPurchaseDate(result.getString(6));
				insObj.setRegistrationNumber(result.getInt(7));
				insObj.setEngineNumber(result.getString(8));
				insObj.setChasisNumber(result.getString(9));
				insObj.setThirdPartyLiabilityInsurance(result.getBoolean(10));
				insObj.setComprehensiveInsurance(result.getBoolean(11));
				insObj.setOneYear(result.getBoolean(12));
				insObj.setTwoYear(result.getBoolean(13));
				insObj.setThreeYear(result.getBoolean(14));
				insObj.setPlanStatus(result.getBoolean(15));
				insObj.setAmount(result.getInt(16));
			}
		    }
		   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   return insList;
	}
   
   public void updateInsurance(Insurance ins) 
   {
		
		
		try {
			PreparedStatement pst =conn.prepareStatement("UPDATE INSDB set tplins=?, cins=? ,oyr=? ,tyr=?,thyr=?,pstatus=? =>where regno=?");
					
			pst.setBoolean (10, ins.isThirdPartyLiabilityInsurance());
			pst.setBoolean (11, ins.isComprehensiveInsurance());		
			pst.setBoolean (12, ins.isOneYear());
			pst.setBoolean (13, ins.isTwoYear());
			pst.setBoolean (14, ins.isThreeYear());
			pst.setBoolean (15, ins.isPlanStatus());
			pst.setInt (7, ins.getRegistrationNumber());
			System.out.println("PreparedStatement is created : "+ pst);
					
					
			int rows = pst.executeUpdate();
					
			System.out.println("Row MODIFIED : "+rows);
		} 
		catch (SQLException e) 
		{
					
			e.printStackTrace();
		}
	}
   public void deleteInsurance(int regNumber) {
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM INSDB where regno=?");
			
			pst.setInt(7, regNumber); 

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
