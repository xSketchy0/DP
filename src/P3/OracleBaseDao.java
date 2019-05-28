// AJ Sijpenhof(1745798)

import java.sql.*;

public class OracleBaseDao {

	private static final String DB_URL = "jdbc:oracle:thin:@192.168.2.40:1522:XE";
	private static final String DB_USER = "testdb";
	private static final String DB_PASS = "test";
    static Connection conn;

    protected Connection getConnection() throws SQLException {
        Connection res = null;
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            res = myConn;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return conn = res;
    }

    public void closeConnection() throws SQLException {
        try {
            conn.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

}
