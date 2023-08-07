package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.Policy;

public class PolicyDAOImplementation implements PolicyDAO1 {
	
Connection conn ; //GLOBAL 
	
	public PolicyDAOImplementation() {
		try {
			//1. Load the Driver
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

	@Override
	public void insertPolicy(Policy policy) {
		// TODO Auto-generated method stub

		 String query = "INSERT INTO policies (policy_id, user_id, vehicle_id, start_date, end_date, " +
                 "premium_amount, policy_status, policy_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		 
  try (PreparedStatement statement = conn.prepareStatement(query)) {
      statement.setInt(1, policy.getPolicyId());
      statement.setInt(2, policy.getUserId());
      statement.setInt(3, policy.getVehicleId());
      statement.setString(4, policy.getStartDate());
      statement.setString(5, policy.getEndDate());
      statement.setFloat(6, policy.getPremiumAmount());
      statement.setBoolean(7, policy.isPolicyStatus());
      statement.setString(8, policy.getPolicyNumber());

      statement.executeUpdate();
  }
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Policy selectPolicy(int policyId) {
		// TODO Auto-generated method stub
		 String query = "SELECT * FROM policies WHERE policy_id = ?";
	        Policy policy = null;

	        try (PreparedStatement statement = conn.prepareStatement(query)) {
	            statement.setInt(1, policyId);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    policy = new Policy();
	                            policy.setPolicyId(resultSet.getInt(1));
	                            policy.setUserId(resultSet.getInt(2));
	                            policy.setVehicleId(resultSet.getInt(3));
	                            policy.setStartDate(resultSet.getString(4));
	                            policy.setEndDate(resultSet.getString(5));
	                            policy.setPremiumAmount(resultSet.getFloat(6));
	                            policy.setPolicyStatus(resultSet.getBoolean(7));
	                            policy.setPolicyNumber(resultSet.getString(8));
	                            
	                }
	            }
	        }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        return policy;
	}

	@Override
	public List<Policy> selectPolicies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePolicy(Policy policy) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = 
					conn.prepareStatement("UPDATE policies set (policy_id, user_id, vehicle_id, start_date, end_date, " +
			                 "premium_amount, policy_status, policy_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			pst.setInt(1, policy.getPolicyId());
			pst.setInt(2, policy.getUserId());
			pst.setInt(3, policy.getVehicleId());
			pst.setString(4, policy.getStartDate()); 
			pst.setString(5, policy.getEndDate()); 
			pst.setFloat(6, policy.getPremiumAmount());
			pst.setBoolean(7, policy.isPolicyStatus());
			pst.setString(8, policy.getPolicyNumber());
			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row MODIFIED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
