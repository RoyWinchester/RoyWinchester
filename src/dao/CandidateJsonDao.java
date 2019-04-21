package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import model.Candidate;
import util.DBManager;

//持久层
public class CandidateJsonDao {

    //查询所有用户信息
    public List<Candidate> finall() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Candidate> list = new ArrayList<Candidate>();
        try {

            conn = DBManager.getConnection();
            Statement stmt=conn.createStatement();
            String sql = "SELECT * FROM candidate";
            rs=stmt.executeQuery(sql);


            while (rs.next()) {
                Candidate ub = new Candidate();
                ub.setCandidateid(rs.getInt("candidateid"));
                ub.setCandidatename(rs.getString("candidatename"));
                list.add(ub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
