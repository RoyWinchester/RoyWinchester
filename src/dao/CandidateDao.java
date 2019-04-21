package dao;

import model.Candidate;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import util.DBManager;
import java.sql.SQLException;
import java.util.Collections;

public class CandidateDao {
    private Candidate candidate;

    public List<Candidate> pickCandidate(){
        List<Candidate> candidateArrayList=new ArrayList<Candidate>();

        try{
            Connection conn=DBManager.getConnection();
            Statement stmt=conn.createStatement();
            String sql;
            sql="select * from candidate";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                Candidate candidateTemp=new Candidate();
                candidateTemp.setCandidateid(rs.getInt("candidateid"));
                candidateTemp.setCandidatename(rs.getString("candidatename"));
                candidateArrayList.add(candidateTemp);
            }
        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("error");
        }
        Collections.shuffle(candidateArrayList);
//        return candidateArrayList.get(0).getCandidatename();

        return candidateArrayList;
    }
}
