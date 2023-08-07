package dao;
import java.sql.*;
import java.util.*;


public class PolicyDAO {
    private Connection connection;

    public PolicyDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPolicy(int policyId, int userId, int vehicleId, String startDate, String endDate,
                          float premiumAmount, boolean policyStatus, String policyNumber) throws SQLException {
        String query = "INSERT INTO policies (policy_id, user_id, vehicle_id, start_date, end_date, " +
                       "premium_amount, policy_status, policy_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, policyId);
            statement.setInt(2, userId);
            statement.setInt(3, vehicleId);
            statement.setString(4, startDate);
            statement.setString(5, endDate);
            statement.setFloat(6, premiumAmount);
            statement.setBoolean(7, policyStatus);
            statement.setString(8, policyNumber);

            statement.executeUpdate();
        }
    }

    public Policy getPolicyById(int policyId) throws SQLException {
        String query = "SELECT * FROM policies WHERE policy_id = ?";
        Policy policy = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, policyId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    policy = new Policy(
                            resultSet.getInt("policy_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("vehicle_id"),
                            resultSet.getString("start_date"),
                            resultSet.getString("end_date"),
                            resultSet.getFloat("premium_amount"),
                            resultSet.getBoolean("policy_status"),
                            resultSet.getString("policy_number")
                    );
                }
            }
        }

        return policy;
    }

    // Other methods for updating, deleting, or querying policies could be added here

    public static class Policy {
        private int policyId;
        private int userId;
        private int vehicleId;
        private String startDate;
        private String endDate;
        private float premiumAmount;
        private boolean policyStatus;
        private String policyNumber;

        public Policy(int policyId, int userId, int vehicleId, String startDate, String endDate,
                      float premiumAmount, boolean policyStatus, String policyNumber) {
            this.policyId = policyId;
            this.userId = userId;
            this.vehicleId = vehicleId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.premiumAmount = premiumAmount;
            this.policyStatus = policyStatus;
            this.policyNumber = policyNumber;
        }

        // Getter methods for the fields
    }
}

