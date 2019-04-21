package util;
import java.sql.*;

public class DBManager {
    public static Connection getConnection(){
        Connection conn=null;
        String CLASSFORNAME="com.mysql.cj.jdbc.Driver";
        String SERVANDDB= "jdbc:mysql://localhost:3306/PlanetLottery?useSSL=false";
        String USER="root";
        String PWD="98fan@kun";
        try{
            Class.forName(CLASSFORNAME);
            conn=DriverManager.getConnection(SERVANDDB,USER,PWD);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if(conn != null) {
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if(stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStmt(Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeRs(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
