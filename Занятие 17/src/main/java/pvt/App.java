package pvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/user?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "Chelseatorres9";

        String query = "SELECT * FROM user.userdata;";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("login"));
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}