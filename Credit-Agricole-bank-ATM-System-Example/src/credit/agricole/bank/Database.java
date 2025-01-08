package credit.agricole.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class Database {

    public static Connection getConnection() throws SQLException {
        String username = "system";
        String password = "admin";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(true);
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from HR.JOBS");

            while (rs.next()) {
                System.out.println(rs.getString("job_id") + "   " + rs.getString("job_title") + "  " + rs.getInt("min_salary"));
            }

            System.out.println("Done");
        } catch (SQLException ex) {
            //  Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("chatch ");

        }
    }

}