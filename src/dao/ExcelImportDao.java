package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;




import model.Candidate;
import util.DBManager;

public class ExcelImportDao {

    //保存导入的信息
    public void save(List<Candidate> list) {
        for (int i = 0; i < list.size(); i++) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DBManager.getConnection();
                String sql = "insert into candidate(candidateid, candidatename) values('"
                        + list.get(i).getCandidateid()
                        + "', '"
                        + list.get(i).getCandidatename()
                        + "')";
                ps = conn.prepareStatement(sql);
                ps.execute();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

