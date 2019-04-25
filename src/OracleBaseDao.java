// AJ Sijpenhof(1745798)

import java.sql.*;

public class OracleBaseDao {
    private Connection conn;

    protected Connection getConnection() {
        Connection res = null;
        try {
            Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.40:1522:XE", "testdb", "test");

            res = myConn;
        } catch (Exception err) {
            err.printStackTrace();
        }
        return conn = res;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

}
