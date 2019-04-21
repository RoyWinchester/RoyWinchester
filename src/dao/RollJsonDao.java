package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Candidate;
import model.Roll;
import util.DBManager;

public class RollJsonDao {
    //查询所有转盘信息
    public List<Roll> finall() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Roll> list = new ArrayList<Roll>();
        try {

            conn = DBManager.getConnection();
            Statement stmt=conn.createStatement();
            String sql = "SELECT * FROM roll";
            rs=stmt.executeQuery(sql);

            while (rs.next()) {
                Roll ub = new Roll();
                ub.setName(rs.getString("name"));
                ub.setWeight(rs.getInt("weight"));
                list.add(ub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
