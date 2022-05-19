package dat.startcode.model.persistence;

import dat.startcode.model.DTO.AccountDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDTOMapper implements IAccountDTOMapper{
        ConnectionPool connectionPool;

        public AccountDTOMapper (ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

    @Override
    public AccountDTO getAccountAndCustomerDTO(int customerId) {

        String sql = "SELECT * FROM carport.customer_and_account_overview WHERE customer_id = ?";

        AccountDTO accountDTO = null;

        try(Connection connection = connectionPool.getConnection()) {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,customerId);

                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    int accountId = rs.getInt("account_id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int role = rs.getInt("role");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    int zip = rs.getInt("zip");

                    accountDTO = new AccountDTO(accountId,email,password,role,customerId,name,address,city,zip);
                    return accountDTO;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return accountDTO;
    }
}
