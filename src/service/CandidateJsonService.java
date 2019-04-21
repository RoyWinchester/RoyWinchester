package service;
import java.util.List;

import dao.CandidateJsonDao;
import model.Candidate;

public class CandidateJsonService {


    //用户业务层

    CandidateJsonDao dao = new CandidateJsonDao();

    //查询所有用户
    public List<Candidate> finall() {
            return dao.finall();
        }
}
